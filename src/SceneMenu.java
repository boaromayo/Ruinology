import java.awt.*;
import java.awt.image.*;

public class SceneMenu extends Scene {

	// CHOICES.
	private final int _START = 0;
	private final int _MAP = 1;
	private final int _QUIT = 2;
	
	// CURSOR POSITION.
	private int _cursorX;
	private int _cursorY;
	
	// CURSOR IMAGE.
	private BufferedImage _cursorImg;
	
	// MENU ARRAY.
	private int _cursorPos;
	private String [] _choices = { "START", "MAP SIZE", "QUIT" };
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_cursorX = 100;
		_cursorY = 120;
		
		_cursorPos = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// keyboard output here
		if (InputBank.keyDown(InputBank._W) || 
				InputBank.keyDown(InputBank._UP)) {
			if (_cursorPos > 0)
				_cursorPos--;
			else
				_cursorPos = _choices.length - 1;
		} else if (InputBank.keyDown(InputBank._S) || 
				InputBank.keyDown(InputBank._DOWN)) {
			if (_cursorPos < _choices.length) 
				_cursorPos++;
			else
				_cursorPos = 0;
		} else if (InputBank.keyDown(InputBank._ENTER)) {
			branchChoices(_cursorPos);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		drawIcon(g);	
		drawChoices(g);
	}
	
	private void drawIcon(Graphics g) {
		if (_cursorPos == _START) {
			moveCursor(100,120);
		} else if (_cursorPos == _MAP) {
			moveCursor(100,160);
		} else if (_cursorPos == _QUIT) {
			moveCursor(100,200);
		}
		
		g.drawImage(_cursorImg, _cursorX, _cursorY, _cursorImg.getWidth(), _cursorImg.getHeight(), null);
	}
	
	private void drawChoices(Graphics g) {
		int offset = 5;
		
		for (int i = 0; i < _choices.length; i++) {
			g.drawString(_choices[i], 140, (40 * i) + 120 - offset);
		}
	}
	
	private void branchChoices(int choice) {
		if (choice == _START) {
			// Load game
		} else if (choice == _MAP) {
			// Go to map menu scene
		} else if (choice == _QUIT) {
			System.exit(0); // shutdown
		}
	}

	private void moveCursor(int x, int y) {
		_cursorX = x;
		_cursorY = y;
	}
}
