import java.awt.*;
import java.awt.image.*;

public class ScenePause extends Scene {

	// PAUSE TITLE.
	private BufferedImage _pauseImg;
	
	// PAUSE TITLE PATH.
	private String _pauseImgPath = "../img/pausetitle.png";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_pauseImg = ImageBank.loadImage(_pauseImgPath);
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// Press 'ENTER' to resume, 'ESC' to go to menu.
		if (InputBank.keyDown(InputBank._ENTER)) {
			SceneBank.removeScene();
			SceneBank.setScene(SceneBank.getCurrentScene());
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
