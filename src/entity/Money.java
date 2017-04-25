package entity;
import java.awt.*;
import java.awt.image.*;

public class Money {
	// MONEY TYPE.
	private MoneyType _type;
	
	// SPRITE.
	private BufferedImage _img;
	
	// COORDINATES.
	protected float _x;
	protected float _y;
	
	// SIZE.
	protected int _width;
	protected int _height;
	
	// DURATION.
	protected int _MONEYTIME = 30;
	protected int _sec = 0;
	
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
	
	public void update() {
		int frame = 0;
		
		frame++;
		
		if (frame == 60) {
			_sec++;
			frame = 0;
			
			if (_sec == _MONEYTIME) {
				_sec = 0;
				this.setVisible(false);
			}
		}
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		int x = (int)_x;
		int y = (int)_y;
		float opacity = 0.5f;
		
		if (_sec == _MONEYTIME - 5) {
			g2.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, opacity));
		}
		
		g2.drawImage(_img, x, y, _width, _height, null);
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
		int x = (int)(_x - (_width / 2));
		int y = (int)(_y - (_height / 2));
		return new Rectangle(x, y, _width, _height);
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
