import java.awt.*;
import java.awt.image.*;

public class Player {
	
	// SPRITE.
	private BufferedImage[] _pImg;
	private int _frames = 4;
	
	// SPRITE PATH.
	private String _pImgPath = Constants._playerPath;
	
	// COORDINATES.
	private float _x;
	private float _y;
	
	// SIZE.
	private final int SIZE = 24;
	private int _width;
	private int _height;
	
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
	
	// ITEM BAG.
	private UsableItem[] _bag;
	private int _bagSize;
	private int _position;
	
	// SCORE.
	private int _score;
	
	public Player() {
		_width = SIZE;
		_height = SIZE;
		
		_pImg = ImageBank.loadImages(_pImgPath, 0, 0, _width, _height, _frames); 
		
		_dir = Direction.UP;
		
		_speed = 2;
		
		_maxhp = 10;
		_hp = _maxhp;
		
		_maxsp = 15;
		_sp = _maxsp;
		
		_bag = new UsableItem[3];
		_bagSize = 0;
		_position = 0;
		
		_score = 0;
	}
	
	public void update() {
		// if health is 0, kill him
		
		
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
		} else {
			setdx(0);
			setdy(0);
		}
		
		move();
		
	}
	
	private void move() {
		_x += _dx;
		_y += _dy;
	}
	
	public void draw(Graphics g) {
		// cast floats to int
		int xi = (int) _x;
		int yi = (int) _y;
		
		// placeholder tri
		int[] xp = {xi, xi-5, xi+5};
		int[] yp = {yi, yi+5, yi+5};
		g.drawPolygon(xp, yp, 3);
		
		// draw image based on direction
		/*if (_dir == Direction.UP) {
			g.drawImage(_pImg[0], xi, yi, _width, _height, null);
		} else if (_dir == Direction.LEFT) {
			g.drawImage(_pImg[1], xi, yi, _width, _height, null);
		} else if (_dir == Direction.RIGHT) {
			g.drawImage(_pImg[2], xi, yi, _width, _height, null);
		} else if (_dir == Direction.DOWN) {
			g.drawImage(_pImg[3], xi, yi, _width, _height, null);
		}*/
	}
	
	public void drawHealth(Graphics g) {
		// draw hud for health
		//String barPath = "../img/health_bar.gif";
		BufferedImage heartImg = Constants._heart;
		//BufferedImage bar = ImageBank.loadImage(barPath);
		
		int heartWidth = heartImg.getWidth();
		int heartHeight = heartImg.getHeight();
		
		g.drawImage(heartImg, 20, Constants.HEIGHT - 30, heartWidth, heartHeight, null);
		
		//g.drawImage(bar, 50, Game.HEIGHT - 30, bar.getWidth(), bar.getHeight(), null);
		
		g.setColor(Color.RED);
		g.fillRect(50, Constants.HEIGHT - 30, (_hp / _maxhp) * 100, 8);
	}
	
	public void drawStamina(Graphics g) {
		// draw hud for stamina
		//String barPath = "../img/stamina_bar.gif";
		BufferedImage stamImg = Constants._stamina;
		//BufferedImage bar = ImageBank.loadImage(barPath);
		
		int stamWidth = stamImg.getWidth();
		int stamHeight = stamImg.getHeight();
		
		g.drawImage(stamImg, 20, Constants.HEIGHT - 10, stamWidth, stamHeight, null);
		
		//g.drawImage(bar, 50, Game.HEIGHT - 10, bar.getWidth(), bar.getHeight(), null);
		
		g.setColor(Color.GREEN);
		g.fillRect(50, Constants.HEIGHT - 10, (_sp / _maxsp) * 50, 8);
	}
	
	public void drawBag(Graphics g) {
		// draw hud part for bag
		g.setColor(Color.WHITE);
		for (int i = 0; i < _bagSize; i++) {
			g.drawRect(180 + (36 * i), Constants.HEIGHT - 24, 32, 32);
		}
		
		// draw bag cursor
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		
		g2.drawRect(180 + (36 * _position), Constants.HEIGHT - 24, 32, 32);
	}
	
	// ITEMS.
	public void addItem(UsableItem item) {
		if (_bagSize < _bag.length - 1)
			_bag[_bagSize++] = item;
	}
	
	public void useItem() {
		if (_bag[_position] != null) {
			_bag[_position].effect();
			_bag[_position] = null;
			_bagSize--;
		}
	}
	
	// EFFECTS.
	public void hit(int dmg) {
		if (_hp < dmg) {
			_hp = 0;
		}
		
		_hp -= dmg;
	}
	
	public void heal(int rec) {
		if (_maxhp < rec) {
			_hp = _maxhp;
		}
		
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
	
	// OTHER METHODS.
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
	
	public Rectangle getBoundingBox() {
		return new Rectangle((int)_x, (int)_y, _width, _height);
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
