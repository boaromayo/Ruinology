package entity;
import java.awt.*;

public class StamPotion extends UsableItem {
	
	public StamPotion() {
		// TODO Auto-generated constructor stub
		//_img = Constants._greenPotion;
		
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
		int x = (int)_x;
		int y = (int)_y;
		g.drawImage(_img, x, y, _width, _height, null);
	}

	@Override
	public void use(Player p) {
		// TODO Auto-generated method stub
		//AudioBank.play(Constants._drink); // play drink sound
		//p.healStamina(30);
	}

}
