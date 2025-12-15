import json
import math
from pathlib import Path
import matplotlib.patches as mpatches
import matplotlib.pyplot as plt
from matplotlib.patches import Polygon, Circle
import os
import sys
import time

"""
Visualization script for Catan.

This script supports two execution modes:
(1) Single-render mode
   Usage: python visualize.py base_map.json <state.json>
   Renders one board image from the given state json file.
(2) Watch mode
   Usage: python visualize.py base_map.json --watch
   Continuously watches 'state.json' and re-renders the board whenever
   the file changes.

- base_map.json: defines the board layout.
- state.json: defines the game state (roads, buildings).
"""

RESOURCE_COLORS = {
    "WOOD": "#2e8b57",  # green
    "BRICK": "#b22222",  # red
    "SHEEP": "#9acd32",  # light green
    "WHEAT": "#f0e68c",  # yellow
    "ORE": "#808080",  # gray
    None: "#d2b48c",  # desert
}

OWNER_COLORS = {
    "RED": "red",
    "BLUE": "blue",
    "ORANGE": "orange",
    "WHITE": "black",
    "GREEN": "green"
}

def load_base_map(path="base_map.json"):
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)

# === Geometry helpers ===
def hex_to_pixel(q, r, size=1):
    """
    Axial (q, r) → Cartesian (x, y) for pointy-topped hex grid.
    size = distance from center to vertex.
    This spacing guarantees edge sharing (no gaps).
    """
    x = size * math.sqrt(3) * (q + r / 2)
    y = size * 1.5 * r
    return x, y


def hex_corners(x, y, size):
    """Return vertices of a pointy-topped hex centered at (x, y)."""
    corners = []
    for i in range(6):
        angle_deg = 60 * i - 30  # pointy top
        angle_rad = math.radians(angle_deg)
        corners.append((x + size * math.cos(angle_rad), y + size * math.sin(angle_rad)))
    return corners

# === Buildings and Roads helpers ===
def _round_pt(pt, ndigits=6):
    return (round(pt[0], ndigits), round(pt[1], ndigits))

def build_nodes_and_edges_from_tiles(base_map, size=1.0):
    """
    Build intersection nodes and road edges from the tile layout.
    """
    # collect all unique corners across all tiles
    corner_to_tmp = {}
    corners_list = []
    temp_edges = set()

    for t in base_map["tiles"]:
        q, r = t["q"], t["r"]
        cx, cy = hex_to_pixel(q, r, size)

        corners = hex_corners(cx, cy, size)
        corner_ids = []

        for pt in corners:
            rpt = _round_pt(pt, ndigits=6)
            if rpt not in corner_to_tmp:
                corner_to_tmp[rpt] = len(corners_list)
                corners_list.append(rpt)
            corner_ids.append(corner_to_tmp[rpt])

        # add edges between consecutive corners of this hex
        for i in range(6):
            a = corner_ids[i]
            b = corner_ids[(i + 1) % 6]
            if a > b:
                a, b = b, a
            temp_edges.add((a, b))

    # assign deterministic node ids by sorting corners
    order = sorted(range(len(corners_list)), key=lambda i: (corners_list[i][1], corners_list[i][0]))
    old_to_new = {old: new for new, old in enumerate(order)}

    nodes = {old_to_new[i]: corners_list[i] for i in range(len(corners_list))}

    edges = set()
    for a, b in temp_edges:
        na, nb = old_to_new[a], old_to_new[b]
        if na > nb:
            na, nb = nb, na
        edges.add((na, nb))

    return nodes, edges

def draw_roads_and_buildings(ax, nodes, edges, state):
    # roads
    for rd in state.get("roads", []):
        a, b = rd.get("a"), rd.get("b")
        if a is None or b is None:
            continue
        if a not in nodes or b not in nodes:
            continue

        key = (a, b) if a < b else (b, a)
        if key not in edges:
            continue

        x1, y1 = nodes[a]
        x2, y2 = nodes[b]
        color = OWNER_COLORS.get(rd.get("owner", "NONE"), "gray")

        ax.plot([x1, x2], [y1, y2],
                linewidth=5, solid_capstyle="round",
                color=color, zorder=10)

    # buildings
    for bd in state.get("buildings", []):
        nid = bd.get("node")
        if nid is None or nid not in nodes:
            continue

        x, y = nodes[nid]
        color = OWNER_COLORS.get(bd.get("owner", "NONE"), "gray")
        btype = (bd.get("type") or "SETTLEMENT").upper()

        if btype == "SETTLEMENT":
            patch = plt.Circle((x, y), 0.12, facecolor=color, edgecolor="black", lw=1.0, zorder=20)
            ax.add_patch(patch)
        elif btype == "CITY":
            patch = mpatches.RegularPolygon(
                (x, y), numVertices=4, radius=0.17, orientation=math.pi / 4,
                facecolor=color, edgecolor="black", lw=1.0, zorder=20,
            )
            ax.add_patch(patch)
        else:
            patch = plt.Circle((x, y), 0.10, facecolor=color, edgecolor="black", lw=1.0, zorder=20)
            ax.add_patch(patch)

# === Generate board image ===
def generate_board_image(base_map, state=None, output_dir="scraped_boards"):
    fig, ax = plt.subplots(figsize=(8, 8))
    ax.set_aspect("equal")

    size = 1.0

    for t in base_map["tiles"]:
        q, r, s = t["q"], t["r"], t.get("s", -t["q"] - t["r"])
        x, y = hex_to_pixel(q, r, size)

        resource = t.get("resource", None)
        color = RESOURCE_COLORS.get(resource, RESOURCE_COLORS[None])

        # Draw hex
        corners = hex_corners(x, y, size)
        hex_patch = mpatches.Polygon(
            corners, closed=True, edgecolor="black", facecolor=color, lw=1.8
        )
        ax.add_patch(hex_patch)

        # Draw number token
        number = t.get("number") or ""
        if number:
            circ = plt.Circle((x, y), 0.35, color="white", ec="black", lw=1.3, zorder=3)
            ax.add_patch(circ)
            ax.text(
                x,
                y,
                str(number),
                ha="center",
                va="center",
                fontsize=10,
                fontweight="bold",
            )

        # Resource label
        ax.text(
            x,
            y - 0.5,
            resource or "DESERT",
            ha="center",
            va="center",
            fontsize=8,
            fontweight="bold",
        )

    nodes, edges = build_nodes_and_edges_from_tiles(base_map, size=size)
    for nid, (nx, ny) in nodes.items():
        ax.text(nx, ny - 0.08, str(nid),
                ha="center", va="top", fontsize=7, alpha=0.6)
    draw_roads_and_buildings(ax, nodes, edges, state or {})
    # === Layout ===
    ax.axis("equal")
    ax.axis("off")
    ax.set_xlim(-4.5, 4.5)
    ax.set_ylim(-4.5, 4.5)

    # Output naming
    os.makedirs(output_dir, exist_ok=True)

    file_count = len(
        [f for f in os.listdir(output_dir) if os.path.isfile(os.path.join(output_dir, f))]
    )
    output_path = os.path.join(output_dir, f"board{file_count}.png")

    plt.savefig(output_path, dpi=300, bbox_inches="tight")
    print(f"Saved board image to {output_path}")
    plt.close(fig)

    return output_path


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage:")
        print("  python visualize.py base_map.json <state.json>")
        print("  python visualize.py base_map.json --watch")
        sys.exit(1)

    base_map_path = sys.argv[1]
    watch_mode = "--watch" in sys.argv
    base_map = load_base_map(base_map_path)

    state_path = "state.json"
    last_mtime = None
    print("Visualizer started.")
    if watch_mode:
        print("Watch mode enabled. Waiting for state.json changes...")
    while True:
        state = {}
        if os.path.exists(state_path):
            mtime = os.path.getmtime(state_path)
            if (not watch_mode) or (mtime != last_mtime):
                last_mtime = mtime
                with open(state_path, "r", encoding="utf-8") as f:
                    state = json.load(f)
                generate_board_image(base_map, state)
                print("Rendered board from state.json")
        if not watch_mode:
            break
        time.sleep(0.5)
