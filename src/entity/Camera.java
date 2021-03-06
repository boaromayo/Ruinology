package entity;

import java.awt.*;

import content.*;

import map.*;

public class Camera {
	
	// CONSTANTS.
	private final int _OFFSET = 2;
	
	// COORDINATES.
	private int _x;
	private int _y;
	
	// SPEED.
	private int _speed = 3;
	
	// THRESHOLDS.
	private int _xmin;
	private int _xmax;
	private int _ymin;
	private int _ymax;
	
	// "HAS" VARIABLES.
	private Maze _maze;
	private Player _player;
	
	public Camera(Maze m, Player p) {
		_xmin = -Constants.WIDTH - _OFFSET;
		_xmax = 0;
		_ymin = -Constants.HEIGHT - _OFFSET;
		_ymax = 0;
		
		_x = _xmin;
		_y = _ymin;
		
		_maze = m;
		_player = p;
		
		setLocation(_x, _y);
	}
	
	public Camera(Maze m, Player p, int x, int y) {
		_xmin = -x - _OFFSET;
		_xmax = 0;
		_ymin = -y - _OFFSET;
		_ymax = 0;
		
		_x = _xmin;
		_y = _ymin;
		
		_maze = m;
		_player = p;
		
		setLocation(x,y);
	}
	
	public void update() {
		// Have camera move with player to next Room.
		if (_player.getx() > -_xmin) {
			//translate();
		}
		if (_player.getx() < _xmax) {
			//translate();
		}
		if (_player.gety() > -_ymin) {
			//translate();
		}
		if (_player.gety() < _ymax) {
			//translate();
		}
		
	}
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void translate(int movex, int movey) {
		// move camera based on destination
		if (_x > movex) {
			_x -= _speed;
			if (_x < movex) {
				_x = movex;
			}
		} 
		if (_x < movex) {
			_x += _speed;
			if (_x > movex) {
				_x = movex;
			}
		}
		if (_y > movey) {
			_y -= _speed;
			if (_y < movey) {
				_y = movey;
			}
		} 
		if (_y < movey) {
			_y += _speed;
			if (_y > movey) {
				_y = movey;
			}
		}
		
		setBounds();
	}
	
	public void setBounds() {
		if (_x < _xmin) {
			_x = _xmin;
		}
		if (_x > _xmax) {
			_x = _xmax;
		}
		if (_y < _ymin) {
			_y = _ymin;
		}
		if (_y > _ymax) {
			_y = _ymax;
		}
		
	}
	
	public int getx() {
		return _x;
	}
	
	public int gety() {
		return _y;
	}
	
	public void draw(Graphics g) {
		Room room = _maze.getCurrentRoom();
		
		/*int row, col; // Init variables to optimize looping.
		int tx, txmax, ty, tymax; // Init and end tile coords.
		
		tx = _x / Constants.TILE_SIZE;
		txmax = (_x + room.getCols()) / Constants.TILE_SIZE;
		
		ty = _y / Constants.TILE_SIZE;
		tymax = (_y + room.getRows()) / Constants.TILE_SIZE;*/
		
		room.draw(g);
	}
}
