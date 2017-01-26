package scenes;

import java.awt.*;
import java.util.*;

import content.*;
import entity.*;
import map.*;

public class SceneGame extends Scene {
	
	// PLAYER.
	private Player _player;
	
	// MAZE.
	private Maze _maze;
	
	// CAMERA.
	private Camera _camera;

	// SET OF ITEMS IN MAZE.
	ArrayList<Item> _items;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		_maze = new Maze(); // Let maze set player's starting room.
		
		_player = new Player(); 
		
		_player.setTime(360); // Six minutes is default for 8x8 maze.
		
		_maze.setLocation(_player); // Set random location for player.
		
		// Set camera to player's current room location.
		//_camera = new Camera(_player.x / Constants.WIDTH, _player.y / Constants.HEIGHT_FINAL);
		
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
		
		// Set timer on if game scene is the scene being used.
		if (SceneBank.getCurrentScene().equals(this)) {
			if (!_player.isTimerActive()) {
				_player.activateTimer();
			}
			
			_player.updateTimer();
		}
		
		// Check game over conditions.
		if (_player.isDead() || _player.getTimerCount() == 0)
			SceneBank.setScene(new SceneEnd(1, _player.getScore()));
	
		// Update items if they are visible.
		for (Item item : _items) {
			if (item.isVisible()) {
				item.update();
			}
			
			// Check if player touches items.
			if (_player.intersects(item)) {
				item.effect(_player);
				item.setVisible(false);
				_items.remove(item);
			}
		}
		
		// Check inputs.
		updateInput();
	}
	
	private void updateInput() {
		// Go to pause screen if 'ESC' pressed. Timer stops when not in game scene.
		if (InputBank.keyPressed(InputBank._ESC)) {
			_player.deactivateTimer();
			SceneBank.saveScene();
			SceneBank.setScene(new ScenePause());
		}
	}

	@Override
	public void draw(Graphics g) {
		_player.draw(g);
		
		for (Item item : _items) {
			// Draw items if items are visible in the camera.
			if (item.isVisible()) {
				item.draw(g);
			}
		}
	}
}
