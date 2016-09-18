
public class Camera {
	
	// OFFSET.
	private final int _OFFSET = 10;
	
	// COORDINATES.
	private int _x;
	private int _y;
	
	public Camera(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
}
