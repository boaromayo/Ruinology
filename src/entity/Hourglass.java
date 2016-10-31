package entity;
import java.awt.*;

public class Hourglass extends Item {

	// TIME VALUE.
	private int _time;
	
	public Hourglass() {
		// TODO Auto-generated constructor stub
		// set time value based on difficulty and map size
		_time = 30;
		
		//_img = Constants._hrglass;
		
		_width = _img.getWidth();
		_height = _img.getHeight();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(_img, _x, _y, _width, _height, null);
	}

	@Override
	public void effect(Player p) {
		// play sound here and add 30 more secs.
		p.addTime(_time);
	}
}
