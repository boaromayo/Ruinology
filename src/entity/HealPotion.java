package entity;

import java.awt.*;

public class HealPotion extends UsableItem {
	
	public HealPotion() {
		// TODO Auto-generated constructor stub
		//_img = Constants._bluePotion;
		
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
	public void use(Player p) {
		// TODO Auto-generated method stub
		//AudioBank.play(Constants._drink); // play drinking sound
		p.heal(3);
	}

}