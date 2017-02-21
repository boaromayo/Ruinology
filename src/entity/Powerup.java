package entity;

import java.awt.*;

public abstract class Powerup extends Item {
	// TIME LIMIT FOR POWERUP ON SCREEN.
	private int _POWERUPTIME = 15;
	
	@Override
	public void update() {
		int frame = 0;
		int sec = 0;
		
		frame++;
		
		if (frame == 50) {
			sec++;
			frame = 0;
			
			if (sec == _POWERUPTIME) {
				sec = 0;
				this.setVisible(false);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		int x = (int)_x;
		int y = (int)_y;
		g.drawImage(_img, x, y, _width, _height, null);
	}
	
	@Override
	public abstract void effect(Player p);

}
