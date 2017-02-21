package entity;

import java.awt.Graphics;

public abstract class UsableItem extends Item {
	// TIME LIMIT FOR USABLE ITEMS ON SCREEN.
	private int _USABLETIME = 30;
	
	@Override
	public void update() {
		int frame = 0;
		int sec = 0;
		
		frame++;
		
		if (frame == 50) {
			sec++;
			frame = 0;
			
			if (sec == _USABLETIME) {
				sec = 0;
				this.setVisible(false);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int x = (int)_x;
		int y = (int)_y;
		g.drawImage(_img, x, y, _width, _height, null);
	}
	
	@Override
	public void effect(Player p) {
		p.addItem(this);
	}
	
	public abstract void use(Player p);
	
}
