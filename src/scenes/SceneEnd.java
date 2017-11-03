package scenes;

import java.awt.*;
import java.awt.image.*;

import content.*;

public class SceneEnd extends Scene {

	// END GAME TITLES.
	private BufferedImage _victoryTitle;
	private BufferedImage _gameoverTitle;
	
	// PLAYER FINAL SCORE
	private int _score;
	
	// END CONDITION.
	private int _condition;
	
	public SceneEnd(int condition, int score) {
		_condition = condition;
		_score = score;
		
		init(_sb);
	}
	
	@Override
	public void init(SceneBank sb) {
		// TODO Auto-generated method stub
		_sb = sb;
		// branch end conditions depending on victory or gameover
		if (_condition == 0) {
			// make victory appear
			//_victoryTitle = Constants._victoryTitle;
		} else if (_condition == 1) {
			// make gameover appear
			//_gameoverTitle = Constants._gameoverTitle;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		// keyboard output here
		if (InputBank.keyPressed(InputBank._ENTER)) {
			// go back to title screen
			_sb.clear();
			_sb.setScene(new SceneMenu(_sb));
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub	
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT_FINAL);
		
		// Draw graphic depending on end conditions
		if (_condition == 0) {
			//g.drawImage(_victoryTitle, 100, 100, _victoryTitle.getWidth(), _victoryTitle.getHeight(), null);
		} else if (_condition == 1) {
			//g.drawImage(_gameoverTitle, 100, 100, _gameoverTitle.getWidth(), _gameoverTitle.getHeight(), null);
		}
		
		drawScore(g, _score);
	}
	
	private void drawScore(Graphics g, int score) {
		g.drawString("Score: " + _score, 150, 240);
	}
}
