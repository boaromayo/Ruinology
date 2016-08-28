import java.awt.*;

public class SceneBank {
	
	// SCENE BANK SIZE.
	private final int SIZE = 4;
	
	// STACK FOR SCENES.
	private Scene[] _scenes;
	
	// CURRENT SCENE.
	private Scene _currentScene;
	
	// SCENE STACK POSITION.
	private int _position;
	
	public SceneBank() {
		_scenes = new Scene[SIZE];
		_currentScene = new SceneGame();
		_position = -1;
		
		setScene(_currentScene);
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
