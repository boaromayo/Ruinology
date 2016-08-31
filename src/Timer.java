import java.awt.*;

public class Timer {

	// DELAY CONSTANT.
	private final int DELAY = 60;
	
	// SET TIMER COUNTS.
	private int _framecount;
	private int _tick;
	private int _second;
	
	public Timer(int sec) {
		_framecount = 0;
		
		_second = sec;
	}
	
	public void update() {
		_framecount++;
		
		if (_framecount == DELAY) {
			_tick++;
			_framecount = 0;
		}
		
		if (_tick == DELAY) {
			_second--;
			_tick = 0;
		}
	}
	
	public void draw(Graphics g) {
		int minute = (int) (_second / DELAY);
		
		// Draw the clock
		//g.drawImage(clockImg, Game.WIDTH - 50, Game.HEIGHT - 10, clockImg.getWidth(), clockImg.getHeight());
		g.drawString(String.format("%02d:%02d", minute, _second), Game.WIDTH - 20, Game.HEIGHT - 10);
	}
	
	public void setSecond(int s) {
		_second = s;
	}
	
	public int getSecond() {
		return _second;
	}
}
