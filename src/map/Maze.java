package map;

import java.io.*;

import java.util.*;

import content.Constants;

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
	
	// MAZE MODE AND SIZES.
	private int _mazeMode; // Maze mode number indicates size: 0 is 6x6, 1 is 8x8, and 2 is 10x10. 
	private int _mazeSize;
	
	// MAZE SIZE CONSTANTS.
	private final int _SIX = 6;
	private final int _EIGHT = 8;
	private final int _TEN = 10;
	
	// MAZE OF ROOMS.
	private Room[][] _rooms;
	
	// ROOM SIZE.
	private int _roomWidth;
	private int _roomHeight;
	
	public Maze() {
		this(1); // Loads an 8x8 maze by default.
	}
	
	public Maze(int mazeMode) {
		_mazeMode = mazeMode;
		
		if (_mazeMode == 0) {
			_rooms = new Room[_SIX][_SIX]; // 6x6 is 36 rooms, easy!
		} else if (_mazeMode == 1) {
			_rooms = new Room[_EIGHT][_EIGHT]; // 8x8 is 64 rooms, the default.
		} else if (_mazeMode == 2) {
			_rooms = new Room[_TEN][_TEN]; // 10x10 is 100 rooms!!!
		} else {
			throw new RuntimeException("ERROR: Maze mode number is not within range.\n" +
					"Maze mode number: " + _mazeMode);
		}
		
		_mazeSize = _rooms.length; // Set the maze size.
		
		_roomWidth = _rooms[0][0].getCols();
		_roomHeight = _rooms[0][0].getRows();
	}
	
	public void loadRooms(Room[][] newRooms) {
		int roomRows = newRooms.length;
		int roomCols = newRooms[0].length;
		
		// Check for any discrepancies in the Room[][] array. Return if
		// Rooms do not meet requirements.
		if (newRooms == null || roomCols != newRooms[1].length ||
				roomRows != roomCols || roomRows != _mazeSize)
			return;
		
		for (int row = 0; row < roomRows; row++) {
			for (int col = 0; col < roomCols; col++) {
				_rooms[row][col] = newRooms[row][col];
			}
		}
	}
	
	/*public void loadRoomsFromFile(String path) {
		try {
			File file = new File(path);
			File[][] files = new File[_mazeSize][_mazeSize]; // Make the empty files.
			// Create the reader and writer.
			BufferedReader reader = new BufferedReader
					(new FileReader(file));
			Room[][] newRooms = _rooms;
			String delim = "\\s+";
			
			// This file will be read based on the size of numbers
			// in the file and will spit out an error if not enough numbers are read.
			// If 
			int numRows = _roomHeight * _rooms.length;
			int numCols = _roomWidth * _rooms[0].length;
			
			for (int row = 0, r = 0; row < numRows; row++) {
				if (row % _roomHeight == 0)
					r++;
				
				String line = reader.readLine();
				for (int col = 0, c = 0; col < numCols; col++) {
					if (col % _roomWidth == 0)
						c++;
					
					File curFile = files[r][c];
					String[] lines = line.split(delim);
					int linenum = Integer.valueOf(lines[col]);
					
					curFile = new File("room-" + r + "-" + c + ".txt");
				}
			}
			
			reader.close();
		} catch (Exception e) {
			System.err.println("ERROR: Unable to load rooms from file." + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}*/
	
	public void loadRoomsFromFiles(File[][] files) {
		try {
			for (int row = 0; row < files.length; row++) {
				for (int col = 0; col < files[0].length; col++) {
					String pathname = files[row][col].getPath();
					_rooms[row][col] = new Room(pathname);
				}
			}
		} catch (Exception e) {
			System.err.println("ERROR: Cannot load rooms from file." +
					"\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void setLocation(Player p) {
		Random rand = new Random();
		
		int randRow = rand.nextInt(_mazeSize);
		int randCol = rand.nextInt(_mazeSize);
		
		// Get the center of the Room.
		// Since each Room has the same size, this can apply to any Room.
		int centx = _rooms[randRow][randCol].getCols() / 2; 
		int centy = _rooms[randRow][randCol].getRows() / 2;
		int x = rand.nextInt(_roomWidth);
		int y = rand.nextInt(_roomHeight);
		
		// If the randomly picked Room has a ladder, move player to another Room.
		if (_rooms[randRow][randCol].getTile(centx, centy).isType("ladder")) {
			randRow = rand.nextInt(_mazeSize);
			randCol = rand.nextInt(_mazeSize);
			x = rand.nextInt(_roomWidth);
			y = rand.nextInt(_roomHeight);
		}
		
		// Check if tile is solid, or impassable.
		if (_rooms[randRow][randCol].getTile(x,y).isSolid()) {
			x = rand.nextInt(_roomWidth);
			y = rand.nextInt(_roomHeight);
		}
		
		p.setLocation(x,y);
	}
}
