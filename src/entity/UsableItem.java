package entity;

import java.awt.*;

public abstract class UsableItem extends Item {
	// TIME LIMIT FOR USABLE ITEMS ON SCREEN.
	private int _USABLETIME = 30;
	private int _sec = 0;
	
	@Override
	public void update() {
		int frame = 0;
		
		frame++;
		
		if (frame == 60) {
			_sec++;
			frame = 0;
			
			if (_sec == _USABLETIME) {
				_sec = 0;
				this.setVisible(false);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		int x = (int)_x;
		int y = (int)_y;
		float opacity = 0.5f;
		
		if (_sec == _USABLETIME - 5) {
			g2.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, opacity));
		}
		
		g.drawImage(_img, x, y, _width, _height, null);
	}
	
	@Override
	public void effect(Player p) {
		p.addItem(this);
	}
	
	public abstract void use(Player p);
	
}
