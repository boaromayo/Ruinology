import java.awt.*;
import java.awt.image.*;

public abstract class Item {
	// SPRITE.
	protected BufferedImage _img;
	
	// COORDINATES.
	protected int _x;
	protected int _y;
	
	// SIZE.
	protected int _width;
	protected int _height;
	
	// VISIBILITY.
	protected boolean _visible;
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setVisible(boolean v) {
		_visible = v;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(_x, _y, _width, _height);
	}
	
	public boolean isVisible() {
		return _visible;
	}
}
