package scenes;

import java.awt.*;
import java.awt.image.*;

import content.*;

public class ScenePause extends Scene {

	// PAUSE TITLE.
	private BufferedImage _pauseImg;
	
	@Override
	public void init(SceneBank sb) {
		// TODO Auto-generated method stub
		_sb = sb;
		//_pauseImg = Constants._pauseTitle;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// Press 'ENTER' to resume, 'ESC' to go to menu.
		if (InputBank.keyPressed(InputBank._ENTER)) {
			_sb.removeScene();
			_sb.setScene(_sb.getCurrentScene());
		} else if (InputBank.keyPressed(InputBank._ESC)) {
			_sb.clear();
			_sb.setScene(new SceneMenu(_sb));
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT_FINAL);
		
		drawPause(g);
	}

	private void drawPause(Graphics g) {
		g.drawImage(_pauseImg, 20, 150, _pauseImg.getWidth(), _pauseImg.getHeight(), null);
	}
}
