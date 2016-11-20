package entity;
import java.awt.*;
import java.awt.image.*;

public class Money extends Item {
	// MONEY TYPE.
	private MoneyType _type;
	
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
	
	@Override
	public void update() {}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(_img, _x, _y, _width, _height, null);
	}

	private BufferedImage getCoinImage(MoneyType mt) {
		return mt.image();
	}
	
	@Override
	public void effect(Player p) {
		// play money get sound
		p.moneyGet();
		p.addValue(value());
	}
	
	public MoneyType type() {
		return _type;
	}
	
	public int value() {
		return _type.value();
	}
	
}
