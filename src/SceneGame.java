import java.awt.*;
import java.util.*;

public class SceneGame extends Scene {
	
	// PLAYER.
	private Player _player;
	
	// TIMER.
	private Timer _timer;
	
	// MAP.
	
	// SET OF ITEMS.
	ArrayList<Item> _items;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_player = new Player();
		
		_timer = new Timer(360); // six minutes is default for 8x8 map
		
		_items = new ArrayList<Item>(); // make items into list
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		_player.update();
		
		if (SceneBank.getCurrentScene().equals(this)) {
			_timer.update();
		}
		
		for (Item item : _items) {
			// Check if items are visible, then update them.
			if (item.isVisible()) {
				item.update();
			}
		}
		
		// Check inputs.
		updateInput();
	}
	
	private void updateInput() {
		// Pause timer and go to pause screen if 'ESC' pressed.
		if (InputBank.keyDown(InputBank._ESC)) {
			_timer.setTimer(false);
			
			SceneBank.saveScene();
			SceneBank.setScene(new ScenePause());
		}
	}

	@Override
	public void draw(Graphics g) {
		_player.draw(g);
		_timer.draw(g);
		
		for (Item item : _items) {
			// Draw items if items are visible or on map.
			if (item.isVisible()) {
				item.draw(g);
			}
		}
	}

	public Timer callTimer() {
		return _timer;
	}
	
	public void loadMap() {
		
	}
}
