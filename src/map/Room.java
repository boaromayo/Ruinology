package map;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

import content.*;

public class Room {
	
	/** 
	 * Make a Room based on these rules:
	 *============================================================
	 * Each Room starts with solid walls, then a floor is created.
	 *
	 * Have at least one exit for each Room connecting to another Room.
	 *
	 * Also have one Room be the exit out of the Maze (containing a ladder), 
	 * which will be the first Room to be created.
	 *
	 * Each Room contains either nothing, a few items, money, 
	 * dangerous tiles, or traps. Several Rooms may contain a key to open a way to another Room ()
	 *
	 * The Room may contain a mixture of items and dangers.
	 *
	 * All of the Rooms made will be exactly the same size.
	 *
	 * The tiles making the Room will also be the same size.
	 * 
	 * Some Rooms can be duplicated. The only exception should be for the Room
	 * exiting out of the Maze (ie, the room that has a ladder).
	 *============================================================
	**/
	
	// TEXT FILE TO LOAD ROOM.
	private File _file;
	
	// TILESET IDs TABLE.
	private int[] _tilesetids;
	
	// TILE TYPES TABLE.
	private String[] _tiletypes;
	
	// TILE SOLID TABLE.
	private boolean[] _tileSolid;
	
	// TILE DANGEROUS TABLE AND DAMAGE VALUES.
	private boolean[] _tileDanger;
	private int[] _tiledmgs;
	
	// EXIT LADDER.
	private boolean _hasLadder = false;
	
	// TILES FROM TILESET.
	private Tile[][] _tiles;
	
	// ARRAY OF TILE IDs TO BUILD ROOM.
	private int[][] _tileids;
	
	// ROOM DIMENSIONS.
	private int _width;
	private int _height;
	
	// DEFAULT CONSTRUCTOR.
	public Room() {
		_width = Constants.getRoomWidth();
		_height = Constants.getRoomHeight();
		
		_tileids = new int[_height][_width];
		_tiles = new Tile[_height][_width];
		
		init();
	}
	
	// CONSTRUCTOR FOR SINGLE ROOM FROM ONE FILE.
	public Room(String path) {
		_width = Constants.getRoomWidth();
		_height = Constants.getRoomHeight();
		
		_tileids = new int[_height][_width];
		_tiles = new Tile[_height][_width];
		
		try {
			_file = new File(Constants.getMapPath() + path);
		} catch (Exception e) {
			System.err.println("Unable to find or load " + path + "/n" + 
					"Reason:" + e.getMessage());
			e.printStackTrace();
		}
		
		init();
	}
	
	// CONSTRUCTOR FOR MULTIPLE ROOMS, TRANSLATED FROM ONE FILE.
	public Room(int[][] ids) {
		_width = Constants.getRoomWidth();
		_height = Constants.getRoomHeight();
		
		_tileids = new int[_height][_width];
		_tiles = new Tile[_height][_width];
		
		for (int i = 0; i < _height*_width; i++) {
			int row = i / _width;
			int col = i % _width;
			_tileids[row][col] = ids[row][col];
		}
		
		init();
	}
	
	public Room(File file) throws IOException {
		_width = Constants.getRoomWidth();
		_height = Constants.getRoomHeight();
		
		_file = file;
	
		init();
	}
	
	private void init() {
		loadTiles();
		
		if (_file.exists()) {
			printRoom(_file); // Make the Room from a csv or txt file.
		} else {
			printRoom();
		}
	}
	
	private void loadTiles() {
		// Read through a separate file and get the
		// image, type, and behavior corresponding to the ID number.
		File tableFile = new File(Constants.getTilesetPath());
		
		try {
			BufferedReader tablereader = new BufferedReader(
					new FileReader(tableFile));
			String delim = "\\s+"; // Ignore whitespace or commas.
			
			// First line read in the tileset file is the number of tiles available in the set.
			int tableRows = Integer.valueOf(tablereader.readLine());
						
			// Set array size of tile images, ids, types, and behavior.
			_tilesetids = new int[tableRows];
			_tiletypes = new String[tableRows];
			_tileSolid = new boolean[tableRows];
			_tileDanger = new boolean[tableRows];
			_tiledmgs = new int[tableRows];
			
			// Set properties to take into each array for each tile in set.
			String line;
			int strId;
			String strType;
			boolean strSolid;
			boolean strDanger;
			String strDamage;
			int damage = 0;
		
			// Read file per line.
			for (int row = 0; row < tableRows; row++) {
				line = tablereader.readLine();
				strId = Integer.valueOf(line.split(delim)[0]);
				strType = "blank";
				strSolid = false;
				strDanger = false;
				strDamage = "0";
				
				// Set default if substring has no
				// states or has null input. Otherwise, read
				// in substrings of text file line.
				if (line.split(delim).length == 1) {
					_tilesetids[row] = strId;
					_tiletypes[row] = strType;
					_tileSolid[row] = strSolid;
					_tileDanger[row] = strDanger;
					_tiledmgs[row] = damage;
					continue;
				}
				
				strType = line.split(delim)[1];
				if (line.split(delim)[1].isEmpty()) {
					strType = "blank";
				}
				
				if (line.split(delim).length > 2) {
					if (line.split(delim)[2].isEmpty() || 
							!(line.split(delim)[2].equals("true") || line.split(delim)[2].equals("false"))) {
						strSolid = false;
					} else {
						strSolid = true;
					}
				}
				
				if (line.split(delim).length > 3) {
					if (line.split(delim)[3].equals("") || 
							!(line.split(delim)[3].equals("true") || line.split(delim)[3].equals("false"))) {
						strDanger = false;
					} else {
						strDanger = true;
					}
				}
				
				if (line.split(delim).length > 4) {
					if (line.split(delim)[4].isEmpty()) {
						damage = 0;
					} else {
						strDamage = line.split(delim)[4];
						damage = Integer.valueOf(strDamage);
					}
				}
				
				// load tileset into arrays.
				_tilesetids[row] = strId;
				_tiletypes[row] = strType;
				_tileSolid[row] = strSolid;
				_tileDanger[row] = strDanger;
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
		Tile tile;
		int row, col;
		int tileid;
		int r, c;
		int w = Constants.getTileWidth();
		BufferedImage[][] tilesetimg = Constants.getTileset();
		
		for (int i = 0; i < _height*_width; i++) {
			row = i / _width;
			col = i % _width;
			
			tileid = _tileids[row][col];
			r = tileid / w;
			c = tileid % w;
			
			// TODO: Calculate tileset ID array index from tile ID.
			tile = new Tile(tilesetimg[r][c], 
					tileid, 
					_tiletypes[tileid], 
					_tileSolid[tileid],
					_tileDanger[tileid],
					_tiledmgs[tileid]); // Form the tiles for the room.
			if (tile.isType("ladder"))
				_hasLadder = true;
			
			_tiles[row][col] = tile;
		}
	}
	
	private void printRoom(File file) {
		// Read through each line of the map.
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(file));			
			String delim = "\\s+"; // Ignore commas or whitespace.

			Tile tile;
			int i;
			int row, col;
			int tileid;
			int r, c;
			int w = Constants.getTileWidth();
			
			String line;
			String [] ids;
			
			BufferedImage[][] tilesetimg = Constants.getTileset();
			
			// Get tile ID from the text file containing the map.
			for (row = 0; row < _height; row++) {
				// Read newline if on the first column.
				line = reader.readLine();
				
				// Split line based on whitespace.
				ids = line.split(delim);
						
				if (ids.length == _width) {
					for (col = 0; col < _width; col++) {
						
						if (ids[col].equals(null))
							continue;
					
						_tileids[row][col] = Integer.valueOf(ids[col]);
					}
				}
			}
			
			// Now get tile corresponding to tile ID.
			for (i = 0; i < _height*_width; i++) {
				row = i / _width;
				col = i % _width;
				
				tileid = _tileids[row][col];
				r = tileid / w;
				c = tileid % w;
					
				// TODO: Calculate tileset ID array index from tile ID.
				tile = new Tile(tilesetimg[r][c],
						tileid,
						_tiletypes[tileid],
						_tileSolid[tileid],
						_tileDanger[tileid],
						_tiledmgs[tileid]); // Form the tiles for the room.
				if (tile.isType("ladder"))
					_hasLadder = true;
				
				_tiles[row][col] = tile;
			}
					
			reader.close(); // Close reader.
		} catch (IOException e) {
			System.err.println("Error reading file " + _file + ".\n" + 
					"Reason: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Unable to read file " + _file + ".\n" + 
					"Reason: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		for (int row = 0; row < _height; row++) {
			for (int col = 0; col < _width; col++)
				_tiles[row][col].draw(g, col*Constants.TILE_SIZE, row*Constants.TILE_SIZE);
		}
	}
	
	public boolean hasLadder() {
		return _hasLadder;
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
	
	public Tile getTile(int n) {
		int row = n / _width;
		int col = n % _width;
		Tile tile = _tiles[row][col];
		if (tile == null)
			return new Tile(_tiles[0][0].getImage(), 0, _tiletypes[0]); // Return a blank tile.
		
		return tile;
	}
	
	public Tile getTile(int col, int row) {
		Tile tile = _tiles[row][col];
		if (tile == null)
			return new Tile(_tiles[0][0].getImage(), 0, _tiletypes[0]); // Return a blank tile.
		
		return tile;
	}
	
	// Replace tile(row,col) in current room (ie. useful for locking player in room by replacing floor with wall).
	public void replaceTile(Tile newTile, int row, int col) {
		Tile tile = _tiles[row][col];
		if (tile == null || newTile == null) {
			return;
		}
		Tile.replace(tile, newTile);
	}
}
