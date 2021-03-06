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
	ArrayList<Money> _moneys;
	
	@Override
	public void init(SceneBank sb) {
		// TODO Auto-generated method stub
		_sb = sb;
		
		_maze = new Maze(); // Let maze set player's starting room.
		
		_player = new Player(); 
		
		_player.setTime(360); // Six minutes is default for 8x8 maze.
		
		_maze.setLocation(_player); // Set random location for player.
		
		// Set camera to player's current room location.
		//int px = _player.getx() / Constants.WIDTH;
		//int py = _player.gety() / Constants.HEIGHT;
		//_camera = new Camera(_maze, _player, px, py);
		
		_items = new ArrayList<Item>(); // make items into list
		
		for (Item item : _items) {
			// Add items into list if visible on map.
			if (item.isVisible()) {
				_items.add(item);
			}
		}
		
		for (Money money : _moneys) {
			// Add currency into list if visible on map.
			if (money.isVisible()) {
				_moneys.add(money);
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//_camera.update();
		_player.update();
		
		// Set timer on if game scene is the scene being used.
		if (_sb.getCurrentScene().equals(this)) {
			if (!_player.isTimerActive()) {
				_player.activateTimer();
			}
			
			_player.updateTimer();
		}
		
		// Check game over conditions.
		if (_player.isDead() || _player.getTimerCount() == 0)
			_sb.setScene(new SceneEnd(1, _player.getScore()));
	
		// Update items if they are visible.
		for (Item item : _items) {
			if (item.isVisible()) {
				item.update();
			
				// Check if player touches items.
				if (_player.intersects(item)) {
					item.effect(_player);
					item.setVisible(false);
					_items.remove(item);
				}
			}
		}
		
		// Update money if visible.
		for (Money money : _moneys) {
			if (money.isVisible()) {
				money.update();
				
				// Check if player touches items.
				if (_player.intersects(money)) {
					money.effect(_player);
					money.setVisible(false);
					_items.remove(money);
				}
			}
		}
		
		// Check inputs.
		updateInput();
	}
	
	private void updateInput() {
		// Go to pause screen if 'ESC' pressed. Timer stops when not in game scene.
		if (InputBank.keyPressed(InputBank._ESC)) {
			_player.deactivateTimer();
			_sb.saveScene();
			_sb.setScene(new ScenePause());
		}
	}

	@Override
	public void draw(Graphics g) {
		//_camera.draw(g);
		_player.draw(g);
		
		// Draw items if items are visible in the camera.
		for (Item item : _items) {
			if (item.isVisible()) {
				item.draw(g);
			}
		}
		
		for (Money money : _moneys) {
			if (money.isVisible()) {
				money.draw(g);
			}
		}
	}
}
