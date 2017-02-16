package entity;
import java.awt.*;
import java.awt.image.*;

public class Money {
	// MONEY TYPE.
	private MoneyType _type;
	
	// SPRITE.
	private BufferedImage _img;
	
	// COORDINATES.
	protected int _x;
	protected int _y;
	
	// SIZE.
	protected int _width;
	protected int _height;
	
	// VISIBILITY.
	protected boolean _visible;
	
	public Money() {
		_type = MoneyType.BRONZE_COIN;
		
		// Set image based on the type of money
		_img = getCoinImage(_type);
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
	
	public Money(MoneyType mt) {
		_type = mt;
	
		_img = getCoinImage(mt);
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
	
	public void update() {}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(_img, _x, _y, _width, _height, null);
	}
	
	public void effect(Player p) {
		// play money get sound
		p.moneyGet();
		p.addValue(value());
	}
	
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
	
	private BufferedImage getCoinImage(MoneyType mt) {
		return mt.image();
	}
	
	public MoneyType type() {
		return _type;
	}
	
	public int value() {
		return _type.value();
	}
	
	public boolean isVisible() {
		return _visible;
	}
	
}
