package entity;
import java.awt.*;

public class Hourglass extends Powerup {
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int x = (int)_x;
		int y = (int)_y;
		g.drawImage(_img, x, y, _width, _height, null);
	}

	@Override
	public void effect(Player p) {
		// play sound here and add 30 more secs.
		int time = 30;
		
		p.addTime(time);
	}
}
