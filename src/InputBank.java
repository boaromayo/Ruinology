import java.awt.event.*;

public class InputBank {

	// CURRENT KEYS.
	private static final int _TOTALKEYS = 10;
	
	public static final int _W = 0;
	public static final int _A = 1;
	public static final int _S = 2;
	public static final int _D = 3;
	public static final int _UP = 4;
	public static final int _LEFT = 5;
	public static final int _RIGHT = 6;
	public static final int _DOWN = 7;
	public static final int _ENTER = 8;
	public static final int _ESC = 9;
	
	// KEY PRESS MEMORY STORAGE.
	private static boolean [] _keyBefore = new boolean[_TOTALKEYS];
	private static boolean [] _keyNow = new boolean[_TOTALKEYS];
	
	// CHECK FOR KEYS.
	private static int checkKey(int key) {
		int newKey = 0;
		switch(key) {
		case KeyEvent.VK_W:
			newKey = _W;
			break;
		case KeyEvent.VK_A:
			newKey = _A;
			break;
		case KeyEvent.VK_S:
			newKey = _S;
			break;
		case KeyEvent.VK_D:
			newKey = _D;
			break;
		case KeyEvent.VK_UP:
			newKey = _UP;
			break;
		case KeyEvent.VK_LEFT:
			newKey = _LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			newKey = _RIGHT;
			break;
		case KeyEvent.VK_DOWN:
			newKey = _DOWN;
			break;
		case KeyEvent.VK_ENTER:
			newKey = _ENTER;
			break;
		case KeyEvent.VK_ESCAPE:
			newKey = _ESC;
			break;
		default:
			break;
		}
		
		return newKey;
	}
	
	public static void setKey(int key, boolean set) {
		int i = checkKey(key);
		
		_keyNow[i] = set;
		
		System.out.println(i);
	}
	
	public static void update() {
		for (int i = 0; i < _TOTALKEYS; i++) {
			_keyBefore[i] = _keyNow[i];
		}
	}
	
	public static boolean keyPressed(int i) {
		//int i = checkKey(key);
		return _keyNow[i] && !_keyBefore[i];
	}
	
	public static boolean keyDown(int i) {
		//int i = checkKey(key);
		return _keyNow[i];
	}
}
