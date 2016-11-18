package map;

import java.awt.*;
import java.awt.image.*;

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
	
	// TILESET.
	private BufferedImage[][] _tileset;
	
	// TILES FROM TILESET.
	private Tile[][] _tiles;
	
	// ARRAY OF TILE IDs TO BUILD ROOM.
	private int[][] _tileids;
	
	// ROOM DIMENSIONS.
	private int _width;
	private int _height;
	
	public Room() {
		//_tileset = Constants._tileset;
		
		
		_width = Constants.WIDTH / Constants.TILE_SIZE;
		_height = Constants.HEIGHT / Constants.TILE_SIZE;
		
		_tileids = new int[_height][_width];
		
		init();
	}
	
	private void init() {
		loadTiles(); // Load images as Room Tiles.
		printRoom(); // Print an array of ints of the Room.
	}
	
	private void loadTiles() {
		/*for (int row = 0; row < _tiles.length; row++)
			for (int col = 0; col < _tiles[row].length; col++)
				_tiles[row][col] = new Tile(_tileset[row][col]);*/
	}
	
	private void printRoom() {
		for (int row = 0; row < _tiles.length; row++)
			for (int col = 0; col < _tiles[row].length; col++)
				_tileids[row][col] = 1; // Start by making the Room out of wall tiles.
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public int[][] getRoomArray() {
		if (_tileids == null)
			return null;
		
		return _tileids;
	}
}
