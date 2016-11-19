package map;

import entity.Player;

public class Maze {
	
	// This will be where the game's maze will be assembled.
	// Make the maze based on these rules:
	//
	// Load each created Room onto the maze.
	//
	// All Rooms must be sorted to be reachable to each other.
	//
	// The total number of Rooms in the maze will be determined on the size selected.
	// The default size is 8x8 Rooms, or 64 Rooms.
	//
	// The maze is a square maze.
	//
	// The player is randomly placed in a Room that must NOT have the final exit out of the maze,
	// or be adjacent to the final exit Room.
	
	// MAZE SIZE.
	private int _mazeMode; // Maze mode number indicates size: 0 is 6x6, 1 is 8x8, and 2 is 10x10. 
	
	// MAZE OF ROOMS.
	private Room[][] _rooms;
	
	public Maze(Player p, int mazeMode) {
		_mazeMode = mazeMode;
		
		if (_mazeMode == 0) {
			_rooms = new Room[6][6]; // 6x6 is 36 rooms, easy!
		} else if (_mazeMode == 1) {
			_rooms = new Room[8][8]; // 8x8 is 64 rooms, the default.
		} else if (_mazeMode == 2) {
			_rooms = new Room[10][10]; // 10x10 is 100 rooms!!!
		} else {
			throw new RuntimeException("ERROR: Maze mode number is not within range.\n" +
					"Maze mode number: " + _mazeMode);
		}
	}
}
