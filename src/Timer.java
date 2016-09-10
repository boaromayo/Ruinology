import java.awt.*;
import java.awt.image.*;

public class Timer {

	// TIMER SPRITE.
	private BufferedImage _timerImg;
	
	// TIMER PATH.
	private String _timerImgPath = "../img/timer.png";
	
	// DELAY CONSTANT.
	private final int DELAY = 60;
	
	// TIMER COUNT.
	private int _framecount;
	private int _timercount;
	
	// TIMER ACTIVE.
	private boolean _timerOn;
	
	public Timer(int sec) {
		_timerImg = Game._imageBank.loadImage(_timerImgPath);
		
		_framecount = 0;
		
		_timercount = sec;
		
		_timerOn = false;
	}
	
	public void update() {
		_framecount++;
		
		if (_framecount == DELAY) {
			_timercount--;
			_framecount = 0;
		}
	}
	
	public void draw(Graphics g) {
		int minute = (int) (_timercount / DELAY);
		int second = (int) (_timercount % DELAY);
		
		// Draw the timer img and clock
		g.drawImage(_timerImg, Game.WIDTH - 50, Game.HEIGHT - 10, _timerImg.getWidth(), _timerImg.getHeight(), null);
		g.drawString(String.format("%02d:%02d", minute, second), Game.WIDTH - 40, Game.HEIGHT - 10);
	}
	
	public void setTime(int s) {
		_timercount = s;
	}
	
	public void setTimer(boolean b) {
		_timerOn = b;
	}
	
	public int getCount() {
		return _timercount;
	}
	
	public boolean isActive() {
		return _timerOn;
	}
}
