import java.awt.*;

public class Money extends Item {
	// MONEY VALUE.
	protected int _value;
	
	public Money() {
		_value = 1;
	}
	
	public Money(int v) {
		_value = v;
	}
	
	@Override
	public void update() {}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(_img, _x, _y, _width, _height, null);
	}

	public void setValue(int val) {
		_value = val;
	}
	
	public int value() {
		return _value;
	}
}
