import java.awt.*;
import java.awt.image.*;

public class SceneMenu extends Scene {

	// CURSOR POSITION.
	private int _cursorX;
	private int _cursorY;
	
	// CURSOR IMAGE.
	private BufferedImage _heartImg;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_cursorX = 100;
		_cursorY = 80;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// keyboard output here
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		drawIcon(g);
	}
	
	private void drawIcon(Graphics g) {
		g.drawImage(_heartImg, _cursorX, _cursorY, _heartImg.getWidth(), _heartImg.getHeight(), null);
	}

	
}
