package entity;

import java.awt.*;

import content.*;

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
	
	public Camera() {
		_xmin = -Constants.WIDTH - _OFFSET;
		_xmax = 0;
		_ymin = -Constants.HEIGHT - _OFFSET;
		_ymax = 0;
		
		_x = _xmin;
		_y = _ymin;
		
		setLocation(_x, _y);
	}
	
	public Camera(int x, int y) {
		_xmin = -x - _OFFSET;
		_xmax = 0;
		_ymin = -y - _OFFSET;
		_ymax = 0;
		
		_x = _xmin;
		_y = _ymin;
		
		setLocation(x,y);
	}
	
	public void update() {
		
		setBounds();
	}
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void translate(int movex, int movey) {
		// move camera based on destination
		if (_x > movex) {
			_x -= _speed;
		} 
		if (_x < movex) {
			_x += _speed;
		}
		if (_y > movey) {
			_y -= _speed;
		} 
		if (_y < movey) {
			_y += _speed;
		}
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
		
	}
}
