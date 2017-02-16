package entity;
import java.awt.*;

public class Hourglass extends Item {
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
		int time = 30;
		
		p.addTime(time);
	}
}
