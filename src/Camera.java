
public class Camera {
	
	// CONSTANTS.
	private final int _OFFSET = 2;
	
	// COORDINATES.
	private int _x;
	private int _y;
	
	// THRESHOLDS.
	private int _xmin;
	private int _xmax;
	private int _ymin;
	private int _ymax;
	
	public Camera() {
		_xmin = 0;
		_xmax = _OFFSET;
		_ymin = 0;
		_ymax = _OFFSET;
	}
	
	public Camera(int x, int y) {
		_xmin = 0;
		_xmax = _OFFSET;
		_ymin = 0;
		_ymax = _OFFSET;
		
		setLocation(x,y);
	}
	
	public void update() {
		
	}
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
		
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
	
	public void translate(int x, int y) {
		int xmove = x; // add more to translate method
		int ymove = y;
		
		_x += xmove;
		_y += ymove;
		
		setBounds();
	}
	
	public int getx() {
		return _x;
	}
	
	public int gety() {
		return _y;
	}
}
