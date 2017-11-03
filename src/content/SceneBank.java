package content;

import java.awt.*;

import scenes.*;

public final class SceneBank {
	// Prevents any client code instantiation.
	private SceneBank() {}
	
	// SINGLETON OBJECT.
	private static SceneBank _sb = null;
	
	// SCENE BANK SIZE.
	private final int SIZE = 2;
	
	// STACK FOR SCENES.
	private Scene[] _scenes;
	
	// CURRENT SCENE.
	private Scene _currentScene;
	
	// SCENE STACK POSITION.
	private int _position;
	
	//========================
	// Call instance to ensure only one object is made. Special thanks to:
	// "http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples"
	// "http://www.tutorialspoint.com/java/java_using_singleton.htm" and
	// "http://www.oodesign.com/singleton-pattern.html" for information. 
	//=========================
	public static SceneBank get() {
		// Deal with thread concurrency issues with this block.
		if (_sb == null) {
			synchronized (SceneBank.class) {
				if (_sb == null)
					_sb = new SceneBank(); // Create Singleton object.
			}
		}
			
		return _sb;
	}
		
	public void init() {
		_scenes = new Scene[SIZE];
		_position = -1;
		
		setScene(new SceneMenu(this));
	}
	
	public void setScene(Scene newScene) {
		_currentScene = newScene;
	}
	
	public Scene getCurrentScene() {
		if (_currentScene != null)
			return _currentScene;
		
		return null;
	}
	
	public void saveScene() {
		_scenes[++_position] = _currentScene;
	}
	
	public void removeScene() {
		_currentScene = _scenes[_position];
		_scenes[_position--] = null;
	}
	
	public void clear() {
		while (_scenes != null) {
			removeScene();
		}
	}
	
	public void update() {
		if (_currentScene != null)
			_currentScene.update();
	}
	
	public void draw(Graphics g) {
		if (_currentScene != null)
			_currentScene.draw(g);
	}
}
