import java.awt.*;
import java.util.*;

public class SceneGame extends Scene {

	// PLAYER.
	private Player _player;
	
	// TIMER.
	Timer _timer;
	
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
		_timer.update();
		
		for (Item item : _items) {
			// Check if items are visible, then update them.
			if (item.isVisible()) {
				item.update();
			}
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

}
