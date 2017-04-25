package entity;
import java.awt.*;
import java.awt.image.*;

import content.ImageBank;

public abstract class Item {
	// ITEM TYPE.
	protected ItemType _item;
	
	// SPRITE.
	protected BufferedImage _img;
	
	// COORDINATES.
	protected float _x;
	protected float _y;
	
	// SIZE.
	protected int _width;
	protected int _height;
	
	// VISIBILITY.
	protected boolean _visible;
	
	public Item() {
		_img = ImageBank.get().loadImage("../img/blank.gif");
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
	
	public Item(ItemType item) {
		_item = item;
		
		_img = item.image();
		_width = item.getWidth();
		_height = item.getHeight();
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
	public abstract void effect(Player p);
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setLocation(float x, float y) {
		_x = x;
		_y = y;
	}
	
	public void setVisible(boolean v) {
		_visible = v;
	}
	
	public Rectangle getBoundingBox() {
		int x = (int)(_x - (_width / 2));
		int y = (int)(_y - (_height / 2));
		return new Rectangle(x, y, _width, _height);
	}
	
	public BufferedImage getImage(ItemType it) {
		return it.image();
	}
	
	public boolean isVisible() {
		return _visible;
	}
	
	public boolean typeIs(String s) {
		return s.equals(_item.type());
	}
}
