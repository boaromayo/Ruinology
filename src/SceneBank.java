import java.awt.*;

public class SceneBank {
	
	// SCENE BANK SIZE.
	private static final int SIZE = 4;
	
	// STACK FOR SCENES.
	private static Scene[] _scenes = new Scene[SIZE];
	
	// CURRENT SCENE.
	private static Scene _currentScene = new SceneMenu();
	
	// SCENE STACK POSITION.
	private static int _position = -1;
	
	/*public SceneBank() {
		_scenes = new Scene[SIZE];
		_currentScene = new SceneMenu();
		_position = -1;
		
		setScene(_currentScene);
	}*/
	
	public static void setScene(Scene newScene) {
		_currentScene = newScene;
	}
	
	public static Scene getCurrentScene() {
		if (_currentScene != null)
			return _currentScene;
		
		return null;
	}
	
	public static void saveScene() {
		_scenes[++_position] = _currentScene;
	}
	
	public static void removeScene() {
		_currentScene = _scenes[_position];
		_scenes[_position--] = null;
	}
	
	public static void clear() {
		while (_scenes != null) {
			removeScene();
		}
	}
	
	public static void update() {
		if (_currentScene != null)
			_currentScene.update();
	}
	
	public static void draw(Graphics g) {
		if (_currentScene != null)
			_currentScene.draw(g);
	}
}
