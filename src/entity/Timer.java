package entity;
import java.awt.*;
import java.awt.image.*;

import content.Constants;
import content.Text;

public class Timer {

	// TIMER SPRITE.
	private BufferedImage _timerImg;
	
	// DELAY CONSTANT.
	private final int DELAY = 60;
	
	// TIMER COUNT.
	private int _framecount;
	private int _timercount;
	
	// TIMER ACTIVE.
	private boolean _timerOn;
	
	public Timer(int sec) {
		//_timerImg = Constants.getTimerImg();
		
		_framecount = 0;
		
		_timercount = sec;
		
		_timerOn = false;
	}
	
	public void update() {
		if (isActive()) {
			_framecount++;
			
			if (_framecount == DELAY) {
				_timercount--;
				_framecount = 0;
			}
		}
	}
	
	public void draw(Graphics g) {
		int minute = (int) (_timercount / DELAY);
		int second = (int) (_timercount % DELAY);
		String timeStr = String.format("%02d:%02d", minute, second);
		
		// Draw the timer img and clock
		g.setColor(Color.DARK_GRAY);
		//g.drawImage(_timerImg, Constants.WIDTH - 96, Constants.HEIGHT - 10, _timerImg.getWidth(), _timerImg.getHeight(), null);
		//Text.draw(g, timeStr, Constants.WIDTH - 60, Constants.HEIGHT - 10);
		g.drawString(timeStr, Constants.WIDTH - 96, Constants.HEIGHT_FINAL - 48);
	}
	
	public void setTime(int sec) {
		_timercount = sec;
	}
	
	public void addTime(int sec) {
		_timercount += sec;
	}
	
	public void subtractTime(int sec) {
		_timercount -= sec;
	}
	
	public void activate() {
		_timerOn = true;
	}
	
	public void deactivate() {
		_timerOn = false;
	}
	
	public int getCount() {
		return _timercount;
	}
	
	public boolean isActive() {
		return _timerOn;
	}
}
