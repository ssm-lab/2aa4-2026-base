Python visualization script ```visualize.py``` for rendering a Catan board from JSON files.
- ```base_map.json```: defines the board layout.
- ```state.json```: defines the game state (roads, buildings).
- '''scraped_boards/board0.png```: sample output file.

This script supports two execution modes:
- (1) Single-render mode
   - Usage: ```python visualize.py base_map.json <state.json>```
   - Renders one board image from the given state JSON file.
- (2) Watch mode
   - Usage: ```python visualize.py base_map.json --watch```
   - Continuously watches ```state.json``` and re-renders the board whenever the file changes.
