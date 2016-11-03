package scenes;

import java.awt.*;

import content.*;
import entity.Cursor;

public class SceneMapMenu extends Scene {

	// CURSOR.
	private Cursor _cursor;
	
	// CHOICES.
	private final int _SIX = 0;
	private final int _EIGHT = 1;
	private final int _TEN = 2;
	private final int _BACK = 3;
	
	// MENU STRINGS.
	private String [] _choices = { "6x6", "8x8", "10x10", "BACK" };
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		// Initialize settings
		_cursor = new Cursor(240, 150);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (InputBank.keyPressed(InputBank._W) || 
				InputBank.keyPressed(InputBank._UP)) {
			if (_cursor.position() > 0)
				_cursor.decrement();
			else
				_cursor.setPosition(_choices.length - 1);
		} else if (InputBank.keyPressed(InputBank._S) ||
				InputBank.keyPressed(InputBank._DOWN)) {
			if (_cursor.position() < _choices.length - 1)
				_cursor.increment();
			else
				_cursor.setPosition(0);
		} else if (InputBank.keyPressed(InputBank._ENTER)) {
			branchChoices(_cursor.position());
		} else if (InputBank.keyPressed(InputBank._ESC)) {
			SceneBank.removeScene();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT_FINAL);
		
		drawCursor(g);
		drawChoices(g);
	}
	
	private void drawCursor(Graphics g) {
		// Draw cursor location based on position
		if (_cursor.position() == _SIX) {
			_cursor.move(240,150);
		} else if (_cursor.position() == _EIGHT) {
			_cursor.move(240,190);
		} else if (_cursor.position() == _TEN) {
			_cursor.move(240,230);
		} else if (_cursor.position() == _BACK) {
			_cursor.move(240,270);
		}
		
		_cursor.draw(g);
	}
	
	private void drawChoices(Graphics g) {
		int offset = 10;
		
		for (int i = 0; i < _choices.length; i++) {
			//Text.draw(g, _choices[i], 260, (40 * i) + 150 + offset);
			g.drawString(_choices[i], 260, (40 * i) + 150 + offset);
		}
	}
	
	private void branchChoices(int choice) {
		if (choice == _SIX) {
			
		} else if (choice == _EIGHT) {
			
		} else if (choice == _TEN) {
			
		} else if (choice == _BACK) {
			// Assume the main menu scene is saved scene
			// Push current scene to saved scene and remove this scene
			SceneBank.removeScene();
		}
	}

}
