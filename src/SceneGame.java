import java.awt.*;
import java.util.*;

public class SceneGame extends Scene {
	
	// PLAYER.
	private Player _player;
	
	// TIMER.
	private Timer _timer;
	
	// MAP.

	// CAMERA.
	private Camera _camera;

	// SET OF ITEMS ON MAP.
	ArrayList<Item> _items;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_player = new Player();
		
		_timer = new Timer(360); // Six minutes is default for 8x8 map.
		
		//_map = new Map(rand(), rand()); // Pick a random starting point for the player.
		
		//_camera = new Camera(); // Set camera to player's current room location.
		
		_items = new ArrayList<Item>(); // make items into list
		
		for (Item item : _items) {
			// Add items into list if visible on map.
			if (item.isVisible()) {
				_items.add(item);
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		_player.update();
		
		// Set timer on if game scene.
		if (SceneBank.getCurrentScene().equals(this)) {
			_timer.update();
		}
		
		// Check game over conditions.
		if (_player.isDead() || _timer.getCount() == 0)
			SceneBank.setScene(new SceneEnd(1, _player.getScore()));
	
		// Update items if they are visible.
		for (Item item : _items) {
			if (item.isVisible()) {
				item.update();
			} else if (!item.isVisible()) {
				_items.remove(item);
			}
			
			// Check if player touches items.
			if (_player.intersects(item)) {
				item.effect(_player);
				item.setVisible(false);
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
			// Draw items if items are visible in the camera.
			if (item.isVisible()) {
				item.draw(g);
			}
		}
	}
	
	public void loadMap() {
		
	}
}
