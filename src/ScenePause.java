import java.awt.*;
import java.awt.image.*;

public class ScenePause extends Scene {

	// PAUSE TITLE.
	private BufferedImage _pauseImg;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_pauseImg = Constants._pauseTitle;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// Press 'ENTER' to resume, 'ESC' to go to menu.
		if (InputBank.keyDown(InputBank._ENTER)) {
			SceneBank.removeScene();
			SceneBank.setScene(SceneBank.getCurrentScene());
		} else if (InputBank.keyDown(InputBank._ESC)) {
			SceneBank.clear();
			SceneBank.setScene(new SceneMenu());
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		drawPause(g);
	}

	private void drawPause(Graphics g) {
		g.drawImage(_pauseImg, 20, 150, _pauseImg.getWidth(), _pauseImg.getHeight(), null);
	}
}
