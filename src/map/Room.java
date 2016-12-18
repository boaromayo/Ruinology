package map;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

import java.util.*;

import content.Constants;
import content.ImageBank;

public class Room {
	
	// Make a Room based on these rules:
	//
	// Each Room starts with solid walls, then a floor is created.
	//
	// Have at least one exit for each Room connecting to another Room.
	//
	// Also have one Room be the exit out of the maze, which will be created first.
	//
	// Each Room contains either nothing, a few items, money, 
	// dangerous tiles, or traps. Several Rooms may contain a key to open a way to another Room(?)
	//
	// The Room may contain a mixture of items and dangers.
	//
	// All of the Rooms made will be exactly the same size.
	//
	// The tiles making the Room will also be the same size.
	
	// RANDOMIZER.
	//private Random _rand;
	
	// TEXT FILE FOR ROOM.
	private File _file;
	
	// TILESET.
	private BufferedImage[] _tilesetImg;
	
	// TILE TYPES TABLE.
	private String[] _tiletypes;
	
	// TILE SOLID TABLE.
	private boolean[] _tileSolid;
	
	// TILE DANGEROUS TABLE AND DAMAGE VALUES.
	private boolean[] _tileDanger;
	private int[] _tiledmgs;
	
	// TILES FROM TILESET.
	private Tile[][] _tiles;
	
	// ARRAY OF TILE IDs TO BUILD ROOM.
	private int[][] _tileids;
	
	// ROOM DIMENSIONS.
	private int _width;
	private int _height;
	
	// DEFAULT CONSTRUCTOR.
	public Room() {
		//_tileset = Constants._tileset;
		
		_width = Constants.WIDTH / Constants.TILE_SIZE;
		_height = Constants.HEIGHT / Constants.TILE_SIZE;
		
		_tileids = new int[_height][_width];
		
		init();
	}
	
	// CONSTRUCTOR FOR SINGLE ROOM.
	public Room(String path) {
		//_tileset = Constants._tileset
		
		_width = Constants.WIDTH / Constants.TILE_SIZE;
		_height = Constants.HEIGHT / Constants.TILE_SIZE;
		
		_tileids = new int[_height][_width];
		
		try {
			_file = new File("../assets/maps/" + path);
		} catch (Exception e) {
			System.err.println("Unable to find or load " + path + "/n" + 
					"Reason:" + e.getMessage());
			e.printStackTrace();
		}
		
		init();
	}
	
	// CONSTRUCTOR FOR MULTIPLE ROOMS, TRANSLATED FROM ONE FILE.
	public Room(int[][] tileids) {
		_width = Constants.WIDTH / Constants.TILE_SIZE;
		_height = Constants.HEIGHT / Constants.TILE_SIZE;
		
		_tileids = tileids;
		
		init();
	}
	
	private void init() {
		loadTiles(); // Load images as Room Tiles.
		
		if (_file.exists()) {
			printRoom(_file); // Print an array of ints of the Room.
		} else {
			printRoom();
		}
	}
	
	private void loadTiles() {
		// Read through a separate file and get the
		// image, type, and behavior corresponding to the ID number.
		File tableFile = new File("../assets/maps/tileset.txt");
		
		try {
			BufferedReader tablereader = new BufferedReader(
					new FileReader(tableFile));
			String delim = "\\s+"; // Ignore whitespace.
			
			// First line read in the tileset file is the number of tiles available in the set.
			int tableRows = Integer.valueOf(tablereader.readLine());
			int row = 0;
						
			// Set array size of tile images, types, and behavior.
			_tilesetImg = new BufferedImage[tableRows];
			_tiletypes = new String[tableRows];
			_tileSolid = new boolean[tableRows];
			_tileDanger = new boolean[tableRows];
			_tiledmgs = new int[tableRows];
						
			for (row = 0; row < tableRows; row++) {
				String line = tablereader.readLine();
				String strImg = line.split(delim)[1];
				String strType = line.split(delim)[2];
				String strSolid = line.split(delim)[3];
				String strDanger = line.split(delim)[4];
				int damage = 0;
				
				// Set default to "false" if substring has no
				// solid or danger states or is a bad input. Otherwise, read
				// in substring of text file line.
				if (strSolid.equals(null) || 
						!(strSolid.equals("true") || strSolid.equals("false")) ||
						strSolid.isEmpty()) {
					strSolid = "false";
				} else {
					strSolid = line.split(delim)[3];
				}
				
				if (strDanger.equals(null) || 
						!(strDanger.equals("true") || strDanger.equals("false")) ||
						strDanger.isEmpty()) {
					strDanger = "false";
				} else {
					strDanger = line.split(delim)[4];
				}
				
				if (line.split(delim)[5].equals(null) || 
						line.split(delim)[5].isEmpty()) {
					damage = 0;
				} else {
					damage = Integer.valueOf(line.split(delim)[5]);
				}
				
				// load tileset into arrays.
				_tilesetImg[row] = ImageBank.loadImage("../assets/img/" + strImg);
				_tiletypes[row] = strType;
				_tileSolid[row] = Boolean.getBoolean(strSolid);
				_tileDanger[row] = Boolean.getBoolean(strDanger);
				_tiledmgs[row] = damage;
			}
			
			tablereader.close(); // Close reader for table.
		} catch (IOException ioe) {
			System.err.println("Could not load the table file " + tableFile.getPath() + "\n"
					+ "Reason: " + ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	
	private void printRoom() {
		// Read through each line of the array.
		// Translate each of the tile IDs to tiles.
		int row, col;
		
		for (row = 0; row < _tiles.length; row++)
			for (col = 0; col < _tiles[row].length; col++)
				_tiles[row][col] = new Tile(_tilesetImg[_tileids[row][col]], 
						_tileids[row][col], 
						_tiletypes[_tileids[row][col]], 
						_tileSolid[_tileids[row][col]],
						_tileDanger[_tileids[row][col]],
						_tiledmgs[_tileids[row][col]]); // Form the tiles for the room.
	}
	
	private void printRoom(File file) {
		// Read through each line of the map.
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(file));			
			String delim = "\\s+"; // Ignore whitespace.

			int row = 0;
			int col = 0;
			
			for (row = 0; row < _tiles.length; row++) {
				String line = reader.readLine();
				for (col = 0; col < _tiles[row].length; col++) {
					String [] id = line.split(delim);
					_tileids[row][col] = id[col].charAt(0); // Get the ID from the text file.
				}
			}
			
			for (row = 0; row < _tiles.length; row++)
				for (col = 0; col < _tiles[row].length; col++)
					_tiles[row][col] = new Tile(_tilesetImg[_tileids[row][col]], 
							_tileids[row][col], 
							_tiletypes[_tileids[row][col]],
							_tileSolid[_tileids[row][col]],
							_tileDanger[_tileids[row][col]],
							_tiledmgs[_tileids[row][col]]); // Form the tiles for the room.
					
			reader.close(); // Close reader.
		} catch (Exception e) {
			System.err.println("Unable to read file " + _file + "\n" + 
					"Reason: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		for (int row = 0; row < _tiles.length; row++)
			for (int col = 0; col < _tiles[row].length; col++)
				g.drawImage(_tiles[row][col].getImage(), 
						Constants.TILE_SIZE, Constants.TILE_SIZE, null); // Draw the room.
	}
	
	public int getRows() {
		return _height;
	}
	
	public int getCols() {
		return _width;
	}
	
	public int[][] getRoomArray() {
		if (_tileids == null)
			return null;
		
		return _tileids;
	}
	
	public Tile getTile(int row, int col) {
		Tile tile = _tiles[row][col];
		if (tile == null)
			return new Tile(_tilesetImg[0], 0, _tiletypes[0]); // Return a blank tile.
		
		return tile;
	}
}
