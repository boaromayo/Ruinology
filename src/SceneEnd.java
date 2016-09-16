import java.awt.*;
import java.awt.image.*;

public class SceneEnd extends Scene {

	// END GAME TITLES.
	private BufferedImage _victoryTitle;
	private BufferedImage _gameoverTitle;
	
	// END CONDITION.
	private int _condition;
	
	public SceneEnd(int condition) {
		_condition = condition;
		
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		// branch end conditions depending on victory or gameover
		if (_condition == 0) {
			// make victory appear
			_victoryTitle = Constants._victoryTitle;
		} else if (_condition == 1) {
			// make gameover appear
			_gameoverTitle = Constants._gameoverTitle;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		// keyboard output here
		if (InputBank.keyDown(InputBank._ENTER)) {
			// go back to title screen
			SceneBank.clear();
			SceneBank.setScene(new SceneMenu());
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// Draw graphic depending on end conditions
		if (_condition == 0) {
			g.drawImage(_victoryTitle, 100, 100, _victoryTitle.getWidth(), _victoryTitle.getHeight(), null);
		} else if (_condition == 1) {
			g.drawImage(_gameoverTitle, 100, 100, _gameoverTitle.getWidth(), _gameoverTitle.getHeight(), null);
		}
	}
	

}
