package scenes;

import java.awt.*;
import java.awt.image.*;

import content.*;
import entity.Cursor;

public class SceneMenu extends Scene {

	// TITLE SCREEN.
	private BufferedImage _titleImg;
	
	// CHOICES.
	private final int _START = 0;
	private final int _MAP = 1;
	private final int _QUIT = 2;
	
	// CURSOR.
	private Cursor _cursor;
	
	// MENU ARRAY.
	private String [] _choices = { "START", "MAP SIZE", "QUIT" };
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		// Initialize title screen, bg, and cursor.
		//_titleImg = Constants._title;
		
		_cursor = new Cursor(240, 240);
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
		//g.drawImage(_titleImg, 30, 50, _titleImg.getWidth(), _titleImg.getHeight(), null);
	}
	
	private void drawCursor(Graphics g) {
		if (_cursor.position() == _START) {
			_cursor.move(240,240);
		} else if (_cursor.position() == _MAP) {
			_cursor.move(240,280);
		} else if (_cursor.position() == _QUIT) {
			_cursor.move(240,320);
		}
		
		_cursor.draw(g);
	}
	
	private void drawChoices(Graphics g) {
		int offset = 10;
		
		for (int i = 0; i < _choices.length; i++) {
			//Text.draw(g, _choices[i], 260, (40 * i) + 240 + offset);
			g.drawString(_choices[i], 260, (40 * i) + 240 + offset);
		}
	}
	
	private void branchChoices(int choice) {
		if (choice == _START) {
			// Start game
			//SceneBank.setScene(new SceneGame());
		} else if (choice == _MAP) {
			// Go to map menu scene
			SceneBank.saveScene();
			SceneBank.setScene(new SceneMapMenu());
		} else if (choice == _QUIT) {
			System.exit(0); // shutdown
		}
	}
}
