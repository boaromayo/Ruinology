package map;

import java.awt.image.*;

import content.*;

public class Tile {
	
	// IMAGE.
	private BufferedImage _img;
	
	// PROPERTIES.
	private int _id; // ID of tile
	private String _type; // Type/name of tile
	private boolean _solid; // Can player collide with tile?
	private boolean _dangerous; // Can player be harmed by tile?
	private int _damage; // Amt of damage taken from tile
	
	public Tile() {
		_img = null;
		
		_id = -1;
		_type = "";
		_solid = false;
		_dangerous = false;
		_damage = 0;
	}
	
	public Tile(BufferedImage img, int id, String type) {
		this(img, id, type, false, false, 0);
	}
	
	public Tile(BufferedImage img, int id, String type, boolean solid) {
		this(img, id, type, solid, false, 0);
	}
	
	public Tile(BufferedImage img, int id, String type, boolean solid, boolean dangerous, int dmg) {
		_img = img;
		
		_id = id;
		_type = type;
		_solid = solid;
		_dangerous = dangerous;
		_damage = dmg;
	}
	
	public void setSolid(boolean s) {
		_solid = s;
	}
	
	public void setDangerous(boolean d) {
		_dangerous = d;
	}
	
	public void setDamage(int dmg) {
		_damage = dmg;
	}
	
	public BufferedImage getImage() {
		return _img;
	}
	
	public int getID() {
		return _id;
	}
	
	public String getType() {
		return _type;
	}
	
	public boolean isType(String type) {
		return _type.equals(type);
	}
	
	public boolean isSolid() {
		return _solid;
	}
	
	public boolean isDangerous() {
		return _dangerous;
	}
	
	public int damage() {
		return _damage;
	}
}
