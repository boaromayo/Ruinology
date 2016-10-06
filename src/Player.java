import java.awt.*;
import java.awt.image.*;

import javax.sound.sampled.*;

public class Player {
	
	// SPRITE.
	private BufferedImage[][] _pImg = Constants._player;
	
	private BufferedImage[] _pDownImg;
	private BufferedImage[] _pLeftImg;
	private BufferedImage[] _pRightImg;
	private BufferedImage[] _pUpImg;
	
	private BufferedImage[] _pCurrentImg;
	
	// ANIMATION VARS.
	private int _framecount;
	private int _currentFrame;
	
	// COORDINATES.
	private float _x;
	private float _y;
	
	// SIZE.
	private int _width;
	private int _height;
	
	// SPEED.
	private int _dx;
	private int _dy;
	private int _speed;
	
	// DIRECTION.
	private enum Direction { 
		DOWN, LEFT, RIGHT, UP 
	};
	private Direction _dir;
	
	// STATUS.
	private int _hp;
	private int _maxhp;
	
	private int _sp;
	private int _maxsp;
	
	private boolean _dead;
	
	// ITEM BAG.
	private final int _BAGCAP = 3;
	private UsableItem[] _bag;
	private int _bagSize;
	private int _position;
	
	// SCORE.
	private int _score;
	
	// SOUNDS.
	private Clip _getItem;
	private Clip _getMoney;
	private Clip _harm;
	
	public Player() {
		_pDownImg = _pImg[0];
		_pLeftImg = _pImg[1];
		_pRightImg = _pImg[2];
		_pUpImg = _pImg[3];
		
		_width = Constants.PLAYER_SIZE;
		_height = Constants.PLAYER_SIZE;
		
		_framecount = 0;
		_currentFrame = 0;
		
		setDirection(Direction.DOWN); // Also sets the current image.
		
		_speed = 2;
		
		_maxhp = 10;
		_hp = _maxhp;
		
		_maxsp = 15;
		_sp = _maxsp;
		
		_dead = false;
		
		_bag = new UsableItem[_BAGCAP];
		_bagSize = 0;
		_position = 0;
		
		_score = 0;
		
		_getItem = Constants._getItem;
		_getMoney = Constants._getMoney;
		_harm = Constants._harm;
	}
	
	public void update() {
		// if health is 0, kill player.
		if (getHealth() <= 0) {
			kill();
		}
		
		// animate sprite.
		animate();
		
		updateInput();

		move();
	}
	
	private void animate() {
		_framecount++;
		
		if (_framecount == Constants.DELAY_COUNT) {
			_framecount = 0;
			_currentFrame++;
		}
		
		if (_currentFrame == _pCurrentImg.length) {
			_currentFrame = 0;
		}
	}
	
	private void updateInput() {
		// keyboard output here
		if (InputBank.keyDown(InputBank._S) || 
				InputBank.keyDown(InputBank._DOWN)) {
			setdy(-_speed);
			setDirection(Direction.DOWN);
		} else if (InputBank.keyDown(InputBank._A) ||
				InputBank.keyDown(InputBank._LEFT)) {
			setdx(-_speed);
			setDirection(Direction.LEFT);
		} else if (InputBank.keyDown(InputBank._D) ||
				InputBank.keyDown(InputBank._RIGHT)) {
			setdx(_speed);
			setDirection(Direction.RIGHT);
		} else if (InputBank.keyDown(InputBank._W) ||
				InputBank.keyDown(InputBank._UP)) {
			setdy(_speed);
			setDirection(Direction.UP);
		} else {
			setdx(0);
			setdy(0);
		}
			
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
		/*int[] xp = {xi, xi-5, xi+5};
		int[] yp = {yi, yi+5, yi+5};
		g.drawPolygon(xp, yp, 3);*/
		
		// draw image based on direction
		g.drawImage(getCurrentImage(), xi, yi, _width, _height, null);
		
		// draw hud
		drawHealth(g);
		drawStamina(g);
		drawBag(g);
	}
	
	public void drawHealth(Graphics g) {
		// draw hud for health
		BufferedImage heartImg = Constants._heart;
		//BufferedImage bar = Constants._bar;
		
		int heartWidth = heartImg.getWidth();
		int heartHeight = heartImg.getHeight();
		
		g.drawImage(heartImg, 20, Constants.HEIGHT_FINAL - 30, heartWidth, heartHeight, null);
		
		//g.drawImage(bar, 50, Constants.HEIGHT_FINAL - 30, bar.getWidth(), bar.getHeight(), null);
		
		g.setColor(Color.RED);
		g.fillRect(50, Constants.HEIGHT_FINAL - 30, (_hp / _maxhp) * 100, 8);
	}
	
	public void drawStamina(Graphics g) {
		// draw hud for stamina
		BufferedImage stamImg = Constants._stamina;
		//BufferedImage bar = Constants._bar;
		
		int stamWidth = stamImg.getWidth();
		int stamHeight = stamImg.getHeight();
		
		g.drawImage(stamImg, 20, Constants.HEIGHT_FINAL - 10, stamWidth, stamHeight, null);
		
		//g.drawImage(bar, 50, Constants.HEIGHT_FINAL - 10, bar.getWidth(), bar.getHeight(), null);
		
		g.setColor(Color.GREEN);
		g.fillRect(50, Constants.HEIGHT_FINAL - 10, (_sp / _maxsp) * 50, 8);
	}
	
	public void drawBag(Graphics g) {
		// draw hud part for bag
		g.setColor(Color.WHITE);
		for (int i = 0; i < _bagSize; i++) {
			g.drawRect(180 + (36 * i), Constants.HEIGHT_FINAL - 24, 32, 32);
		}
		
		// draw bag cursor
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		
		g2.drawRect(180 + (36 * _position), Constants.HEIGHT_FINAL - 24, 32, 32);
	}
	
	// ITEMS.
	public void addItem(UsableItem item) {
		if (_bagSize < _bag.length - 1) {
			item.setVisible(false);
			itemGet();
			_bag[_bagSize++] = item;
		}
	}
	
	public void useItem() {
		if (_bag[_position] != null) {
			_bag[_position].use(this);
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
		if (_maxhp < _hp + rec)
			_hp = _maxhp;
		else
			_hp += rec;
	}
	
	public void healStamina(int rec) {
		if (_maxsp < _sp + rec)
			_sp = _maxsp;
		else 
			_sp += rec;
	}
	
	public void hit() {
		hit(1);
	}
	
	public void heal() {
		heal(1);
	}
	
	public void kill() {
		_dead = true;
	}
	
	// SCORE VALUE.
	public void addValue(int val) {
		_score += val;
	}
	
	public void addValue() {
		addValue(1);
	}
	
	// MOVE/ANIMATION METHODS.
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
		
		// Update the sprites as well.
		if (_dir.equals(Direction.DOWN))
			_pCurrentImg = _pDownImg;
		else if (_dir.equals(Direction.LEFT))
			_pCurrentImg = _pLeftImg;
		else if (_dir.equals(Direction.RIGHT))
			_pCurrentImg = _pRightImg;
		else if (_dir.equals(Direction.UP))
			_pCurrentImg = _pUpImg;
	}
	
	public BufferedImage getCurrentImage() {
		return _pCurrentImg[_currentFrame];
	}
	
	// COLLISION METHODS.
	public Rectangle getBoundingBox() {
		return new Rectangle((int)_x, (int)_y, _width, _height);
	}
	
	public boolean intersects(Item item) {
		Rectangle rp = getBoundingBox();
		Rectangle ri = item.getBoundingBox();
		
		return rp.intersects(ri);
	}
	
	// STATUS METHODS.
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
	
	public boolean isDead() {
		return _dead;
	}
	
	// SOUNDS.
	public void itemGet() {
		AudioBank.play(_getItem);
	}
	
	public void moneyGet() {
		AudioBank.play(_getMoney);
	}
	
	public void harm() {
		AudioBank.play(_harm);
	}
	
}
