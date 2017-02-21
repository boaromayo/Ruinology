package entity;

import java.awt.*;

public class HealPotion extends UsableItem {
	
	public HealPotion() {
		// TODO Auto-generated constructor stub
		_width = _img.getWidth();
		_height = _img.getHeight();
	}

	@Override
	public void use(Player p) {
		// TODO Auto-generated method stub
		//AudioBank.play(Constants.drink()); // play drinking sound
		p.heal(3);
	}

}
