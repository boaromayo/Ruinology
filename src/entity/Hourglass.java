package entity;

import content.Constants;

public class Hourglass extends Powerup {
	
	public Hourglass() {
		_img = Constants.getHrglassImg();
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
	
	@Override
	public void effect(Player p) {
		// play sound here and add 30 more secs.
		int time = 30;
		
		p.addTime(time);
	}
}
