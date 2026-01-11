# Catan Visualizer

This repository provides a Python visualization script, `light_visualizer.py`, for rendering a Catan board from JSON files.

---

## Overview

The visualizer reads JSON descriptions of a Catan board and game state, and renders the board as an image.

### Input Files
- `base_map.json` — defines the board layout.
- `state.json` — defines the game state (roads, buildings, etc.).
### Output Files
- `scraped_boards/board0.png` — example output image.

---

## Setup Instructions

### 1. Clone this repository
```bash
git clone https://github.com/ssm-lab/2aa4-2026-base.git
cd visualizer
```
### 2. Create and activate a Python virtual environment
```bash
python3.11 -m venv .venv
source .venv/bin/activate
```

### 3. Install required dependencies
```bash
pip install -r requirements.txt
```

### 4. Clone the Catanatron repository
```bash
git clone -b gym-rendering https://github.com/bcollazo/catanatron.git
cd catanatron
```
### 5. Install dependencies for Catanatron
```bash
pip install -e ".[web,gym,dev]"
```
### 6. Return to the visualizer directory
```bash
cd ..
```

### 7. Run the Script
The script supports two execution modes.
#### (1) Single-render mode
Render a single board image from a given state JSON file:
```bash
python light_visualizer.py base_map.json <state.json>
```
#### (2) Watch mode
Continuously watches ```state.json``` and re-renders the board whenever the file changes:
```bash
python light_visualizer.py base_map.json --watch
```
