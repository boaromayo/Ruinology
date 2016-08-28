import java.awt.*;

public class Player {
	
	// SPRITE.
	//private BufferedImage[] _pImg;
	
	// COORDINATES.
	private float _x;
	private float _y;
	
	// SPEED.
	private int _dx;
	private int _dy;
	private int _speed;
	
	// STATUS.
	private int _hp;
	private int _maxhp;
	
	private int _sp;
	private int _maxsp;
	
	public Player() {
		//_pImg = new BufferedImage[4]; 
		
		_maxhp = 10;
		_hp = _maxhp;
		
		_maxsp = 15;
		_sp = _maxsp;
	}
	
	public void move() {
		_dx = _speed;
		_dy = _speed;
		
		_x += _dx;
		_y += _dy;
	}
	
	public void hit(int dmg) {
		_hp -= dmg;
	}
	
	public void heal(int rec) {
		_hp += rec;
	}
	
	public void hit() {
		hit(1);
	}
	
	public void heal() {
		heal(1);
	}
	
	public void update() {
		// keyboard output here
	}
	
	public void draw(Graphics g) {
		// placeholder tri
		int[] xp = {(int)_x, (int)_x-2, (int)_x+2};
		int[] yp = {(int)_y, (int)_y+2, (int)_y+2};
		g.drawPolygon(xp, yp, 3);
	}
}
