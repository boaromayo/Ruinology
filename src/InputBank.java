import java.awt.event.*;

public class InputBank {

	// CURRENT KEYS.
	private static final int _TOTALKEYS = 10;
	
	public static final int _W = KeyEvent.VK_W;
	public static final int _A = KeyEvent.VK_A;
	public static final int _S = KeyEvent.VK_S;
	public static final int _D = KeyEvent.VK_D;
	public static final int _UP = KeyEvent.VK_UP;
	public static final int _LEFT = KeyEvent.VK_LEFT;
	public static final int _RIGHT = KeyEvent.VK_RIGHT;
	public static final int _DOWN = KeyEvent.VK_DOWN;
	public static final int _ENTER = KeyEvent.VK_ENTER;
	public static final int _ESC = KeyEvent.VK_ESCAPE;
	
	private static int [] _keys = { _W, _A, _S, _D, _UP, _LEFT, _RIGHT, _DOWN, _ENTER, _ESC };
	
	// KEY PRESS MEMORY STORAGE.
	private static boolean [] _keyBefore = new boolean[_TOTALKEYS];
	private static boolean [] _keyNow = new boolean[_TOTALKEYS];
	
	// CHECK FOR KEYS.
	private static int checkKey(int key) {
		int newKey = 0;
		for (int i = 0; i < _keys.length; i++) {
			if (key == _keys[i]) { newKey = i; break; }
		}
		
		return newKey;
	}
	
	public static void setKey(int key, boolean set) {
		int i = checkKey(key);
		
		switch(key) {
		case _W:
			_keyNow[0] = set;
			break;
		case _A:
			_keyNow[1] = set;
			break;
		case _S:
			_keyNow[2] = set;
			break;
		case _D:
			_keyNow[3] = set;
			break;
		case _UP:
			_keyNow[4] = set;
			break;
		case _LEFT:
			_keyNow[5] = set;
			break;
		case _RIGHT:
			_keyNow[6] = set;
			break;
		case _DOWN:
			_keyNow[7] = set;
			break;
		case _ENTER:
			_keyNow[8] = set;
			break;
		case _ESC:
			_keyNow[9] = set;
			break;
		default:
			break;
		}
	}
	
	public static void update() {
		for (int i = 0; i < _TOTALKEYS; i++) {
			_keyBefore[i] = _keyNow[i];
		}
	}
	
	public static boolean keyPressed(int key) {
		int i = checkKey(key);
		return _keyNow[i] && !_keyBefore[i];
	}
	
	public static boolean keyDown(int key) {
		int i = checkKey(key);
		return _keyNow[i];
	}
}
