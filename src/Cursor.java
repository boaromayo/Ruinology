import java.awt.*;
import java.awt.image.*;

public class Cursor {
	
	// SPRITE.
	private BufferedImage _cursorImg;
	
	// IMAGE PATH.
	private String _cursorPath = "../img/cursor.png";
	
	// COORDINATES.
	private int _x;
	private int _y;
	
	// SIZE.
	private int _width;
	private int _height;
	
	// MENU POSITION.
	private int _position;
	
	public Cursor() {
		_x = 100;
		_y = 100;
		
		_cursorImg = Game._imageBank.loadImage(_cursorPath);
		
		_width = _cursorImg.getWidth();
		_height = _cursorImg.getHeight();
		
		_position = 0;
	}
	
	public Cursor(int x, int y) {
		_x = x;
		_y = y;
		
		_cursorImg = Game._imageBank.loadImage(_cursorPath);
		
		_width = _cursorImg.getWidth();
		_height = _cursorImg.getHeight();
		
		_position = 0;
	}
	
	public void draw(Graphics g) {
		g.drawImage(_cursorImg, _x, _y, _width, _height, null);
	}
	
	public void move(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setPosition(int pos) {
		_position = pos;
	}
	
	public void increment() {
		_position++;
	}
	
	public void decrement() {
		_position--;
	}
	
	public int position() {
		return _position;
	}
}
