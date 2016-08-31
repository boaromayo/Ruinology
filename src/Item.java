import java.awt.*;

public abstract class Item {
	// SPRITE.
	//private BufferedImage[] img;
	
	// COORDINATES.
	private int _x;
	private int _y;
	
	// BOUNDING BOX.
	private int _boxX;
	private int _boxY;
	private int _boxW;
	private int _boxH;
	
	// VISIBILITY.
	private boolean _visible;
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
		_boxX = x;
		_boxY = y;
	}
	
	public boolean isVisible() {
		return _visible;
	}
}
