package scenes;

import java.awt.*;
import java.awt.image.*;

import content.*;
import entity.Cursor;

public class SceneMenu extends Scene {

	// TITLE SCREEN.
	//private BufferedImage _titleImg = Constants.getTitle();
	private int _titlex = 32;
	private int _titley = 48;
	
	// CHOICES.
	private final int _START = 0;
	private final int _QUIT = 1;
	//private final int _MAP = 1;
	//private final int _QUIT = 2;
	
	// CURSOR.
	private Cursor _cursor;
	private final int _CURSOR_X = 180;
	private final int _CURSOR_Y = 200;
	
	// MENU ARRAY.
	private String [] _choices = { "START", "QUIT" };
	
	public SceneMenu(SceneBank sb) {
		_sb = sb;
		init(_sb);
	}
	
	@Override
	public void init(SceneBank sb) {
		// TODO Auto-generated method stub
		_sb = sb;
		// Initialize title screen, bg, and cursor.
		//_titleImg = Constants._title;
		
		_cursor = new Cursor(_CURSOR_X, _CURSOR_Y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// keyboard output here
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
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT_FINAL);
		
		drawTitle(g);
		drawCursor(g);	
		drawChoices(g);
	}
	
	private void drawTitle(Graphics g) {
		//g.drawImage(_titleImg, _titlex, _titley, _titleImg.getWidth(), _titleImg.getHeight(), null);
	}
	
	private void drawCursor(Graphics g) {
		if (_cursor.position() == _START) {
			_cursor.move(_CURSOR_X, _CURSOR_Y);
		} else if (_cursor.position() == _QUIT) {
			_cursor.move(_CURSOR_X, _CURSOR_Y + 40);
		} /*else if (_cursor.position() == _QUIT) {
			_cursor.move(_CURSOR_X, _CURSOR_Y + 80);
		}*/
		
		_cursor.draw(g);
	}
	
	private void drawChoices(Graphics g) {
		int offset = 10;
		
		for (int i = 0; i < _choices.length; i++) {
			//Text.draw(g, _choices[i], _CURSOR_X + (offset * 3), (40 * i) + _CURSOR_Y + offset);
			g.drawString(_choices[i], _CURSOR_X + (offset * 3), (40 * i) + _CURSOR_Y + offset);
		}
	}
	
	private void branchChoices(int choice) {
		if (choice == _START) {
			// Start game
			//SceneBank.setScene(new SceneGame());
		} else if (choice == _QUIT) {
			System.exit(0); // shutdown
		}/* else if (choice == _MAP) {
			// Go to map menu scene
			SceneBank.saveScene();
			SceneBank.setScene(new SceneMapMenu());
		} else if (choice == _QUIT) {
			System.exit(0); // shutdown
		}*/
	}
}
