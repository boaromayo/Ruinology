package entity;

import content.Constants;

public class HealPotion extends UsableItem {
	
	public HealPotion() {
		_img = Constants.getBluePotionImg();
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
