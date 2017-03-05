package entity;

import java.awt.*;

public abstract class Powerup extends Item {
	// TIME LIMIT FOR POWERUP ON SCREEN.
	private int _POWERUPTIME = 15;
	private int _sec = 0;
	
	@Override
	public void update() {
		int frame = 0;
		
		frame++;
		
		if (frame == 60) {
			_sec++;
			frame = 0;
			
			if (_sec == _POWERUPTIME) {
				_sec = 0;
				this.setVisible(false);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int x = (int)_x;
		int y = (int)_y;
		float opacity = 0.5f;
		
		if (_sec == _POWERUPTIME - 5) {
			g2.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, opacity));
			
		}
		
		g2.drawImage(_img, x, y, _width, _height, null);
	}
	
	@Override
	public abstract void effect(Player p);

}
