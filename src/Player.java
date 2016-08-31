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
	
	// DIRECTION.
	private enum Direction { 
		LEFT, RIGHT, UP, DOWN 
	};
	private Direction _dir;
	
	// STATUS.
	private int _hp;
	private int _maxhp;
	
	private int _sp;
	private int _maxsp;
	
	// SCORE.
	private int _score;
	
	public Player() {
		//_pImg = new BufferedImage[4]; 
		
		_maxhp = 10;
		_hp = _maxhp;
		
		_maxsp = 15;
		_sp = _maxsp;
		
		_dir = Direction.UP;
		
		_speed = 2;
		
		_score = 0;
	}
	
	public void update() {
		// keyboard output here
		if (InputBank.keyDown(InputBank._W) || 
				InputBank.keyDown(InputBank._UP)) {
			setdy(-_speed);
			setDirection(Direction.UP);
		} else if (InputBank.keyDown(InputBank._A) ||
				InputBank.keyDown(InputBank._LEFT)) {
			setdx(-_speed);
			setDirection(Direction.LEFT);
		} else if (InputBank.keyDown(InputBank._D) ||
				InputBank.keyDown(InputBank._RIGHT)) {
			setdx(_speed);
			setDirection(Direction.RIGHT);
		} else if (InputBank.keyDown(InputBank._S) ||
				InputBank.keyDown(InputBank._DOWN)) {
			setdy(_speed);
			setDirection(Direction.DOWN);
		}
		
		move();
	}
	
	private void move() {
		_x += _dx;
		_y += _dy;
		
		// change direction if possible
	}
	
	public void draw(Graphics g) {
		// placeholder tri
		int[] xp = {(int)_x, (int)_x-5, (int)_x+5};
		int[] yp = {(int)_y, (int)_y+5, (int)_y+5};
		g.drawPolygon(xp, yp, 3);
	}
	
	// EFFECTS.
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
	
	// SCORE VALUE.
	public void add(int val) {
		_score += val;
	}
	
	public void add() {
		add(1);
	}
	
	public void setLocation(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setdx(int x) {
		_dx = x;
	}
	
	public void setdy(int y) {
		_dy = y;
	}
	
	public void setDirection(Direction d) {
		_dir = d;
	}
	
	public int getHealth() {
		return _hp;
	}
	
	public int getMaxHealth() {
		return _maxhp;
	}
	
	public int getStamina() {
		return _sp;
	}
	
	public int getMaxStamina() {
		return _maxsp;
	}
	
	public int getScore() {
		return _score;
	}
}
