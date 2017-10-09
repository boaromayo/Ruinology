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
			_file = new File("/assets/maps/" + path);
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
		
		for (int row = 0; row < _height; row++)
			for (int col = 0; col < _width; col++)
				_tileids[row][col] = ids[row][col];
		
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
			String delim = "\\s,+"; // Ignore whitespace or commas.
			
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
			String strSolid;
			String strDanger;
			String strDamage;
			int damage = 0;
		
			// Read file per line.
			for (int row = 0; row < tableRows; row++) {
				line = tablereader.readLine();
				strId = Integer.valueOf(line.split(delim)[0]);
				strType = line.split(delim)[1];
				strSolid = line.split(delim)[2];
				strDanger = line.split(delim)[3];
				strDamage = line.split(delim)[4];
				
				// Set default if substring has no
				// states or has null input. Otherwise, read
				// in substrings of text file line.
				if (strType.equals("")) {
					strType = "blank";
				} else {
					strType = line.split(delim)[1];
				}
				
				if (strSolid.equals("") || 
						!(strSolid.equals("true") || strSolid.equals("false")) ||
						strSolid.isEmpty()) {
					strSolid = "false";
				} else {
					strSolid = line.split(delim)[2];
				}
				
				if (strDanger.equals("") || 
						!(strDanger.equals("true") || strDanger.equals("false")) ||
						strDanger.isEmpty()) {
					strDanger = "false";
				} else {
					strDanger = line.split(delim)[3];
				}
				
				if (strDamage.equals("")) {
					damage = 0;
				} else {
					damage = Integer.valueOf(strDamage);
				}
				
				// load tileset into arrays.
				_tilesetids[row] = strId;
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
		Tile tile;
		int row, col;
		int tileid;
		int r, c;
		int w = Constants.getRoomWidth();
		BufferedImage[][] tilesetimg = Constants.getTileset();
		
		for (row = 0; row < _tiles.length; row++) {
			for (col = 0; col < _tiles[row].length; col++) {
				tile = _tiles[row][col];
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
			}
		}
	}
	
	private void printRoom(File file) {
		// Read through each line of the map.
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(file));			
			String delim = "\\s+"; // Ignore whitespace.

			Tile tile;
			int row, col;
			int tileid;
			int r, c;
			int w = Constants.getRoomWidth();
			
			String line;
			String [] ids;
			
			BufferedImage[][] tilesetimg = Constants.getTileset();
			
			// Get tile ID from the text file containing the map.
			for (row = 0; row < _tiles.length; ) {
				line = reader.readLine();
				
				char digit = line.charAt(0);
				boolean isnum = (digit >= '0' && digit <= '9');
				
				// Check for ID if the first line read is an integer.
				if (isnum) {
					ids = line.split(delim);
					
					for (col = 0; col < _tiles[row].length; col++) {
						// Get out of the loop if there is a null string.
						if (ids[col].equals(null))
							break;
						
						_tileids[row][col] = Integer.valueOf(ids[col]);
					}
					
					// Increment row if row is completely checked.
					if (col == _tiles[row].length)
						row++;
				}
			}
			
			// Now get tile corresponding to tile ID.
			for (row = 0; row < _tiles.length; row++) {
				for (col = 0; col < _tiles[row].length; col++) {
					tile = _tiles[row][col];
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
				}
			}
					
			reader.close(); // Close reader.
		} catch (Exception e) {
			System.err.println("Unable to read file " + _file + "\n" + 
					"Reason: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		for (int row = 0; row < _tiles.length; row++)
			for (int col = 0; col < _tiles[row].length; col++)
				_tiles[row][col].draw(g, col, row);
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
			return new Tile(Constants.getBlankTile(), 0, _tiletypes[0]); // Return a blank tile.
		
		return tile;
	}
	
	public Tile getTile(int row, int col) {
		Tile tile = _tiles[row][col];
		if (tile == null)
			return new Tile(Constants.getBlankTile(), 0, _tiletypes[0]); // Return a blank tile.
		
		return tile;
	}
}
