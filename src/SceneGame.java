import java.awt.*;

public class SceneGame extends Scene {

	// PLAYER.
	private Player _player;
	
	// TIMER.
	//Timer _timer;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		_player.update();
		//_timer.update();
	}

	@Override
	public void draw(Graphics g) {
		_player.draw(g);
		//_timer.draw(g);
	}

}
