package entity;

import content.*;

import java.awt.image.*;

public enum ItemType {
	// show the types of items in-game
	HEAL_POTION(1, "heal-potion", Constants.getBluePotionImg(), true),
	HOURGLASS(2, "hourglass", Constants.getHrglassImg(), false);
	
	private int _id;
	
	// NAME.
	private String _name;
	
	// SPRITE.
	private BufferedImage _img;
	
	// PLAYER USABILITY.
	private boolean _usable;
	
	private ItemType(int id, String name, BufferedImage img, boolean usable) {
		_id = id;
		_name = name;
		_img = img;
		_usable = usable;
	}
	
	public int id() {
		return _id;
	}
	
	public String type() {
		return _name;
	}
	
	public BufferedImage image() {
		return _img;
	}
	
	public boolean isUsable() {
		return _usable;
	}
	
	public int getWidth() {
		return _img.getWidth();
	}
	
	public int getHeight() {
		return _img.getHeight();
	}
}
