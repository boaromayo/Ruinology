import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {	
	// MAIN THREAD.
	private Thread _thread;
	
	public GamePanel() {
		init();
	}
	
	public void init() {
		// Initialize panel and settings.
		setFocusable(true);
		requestFocus(); // make this game panel the focus.
		
		// input key listener.
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				InputBank.setKey(key, true);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				InputBank.setKey(key, false);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {}
		});
	}
	
	public void run() {
		long startTime, diffTime;
		
		long waitTime;
		
		long targetTime = 1000/(Constants.FPS);
		
		//long timeElapsed = 0;
		
		int framecount = 0;
		int maxframecount = Constants.FPS;
		
		try {
			while (true) {
				startTime = System.nanoTime();
				
				update();
				repaint();
				
				diffTime = (System.nanoTime() - startTime) / 1000000;
				waitTime = targetTime - diffTime;
				
				if (waitTime < 0) 
					waitTime = targetTime;
				
				Thread.sleep(waitTime);
				
				//timeElapsed += (System.nanoTime() - startTime);
				
				framecount++;
				
				if (framecount == maxframecount) {
					framecount = 0;
				}
			}
		} catch (Exception err) {
			System.err.println("ERROR: Thread unstable. REASON: " + err.getMessage());
			err.printStackTrace();
			System.exit(1);
		}
	}
	
	public void addNotify() {
		super.addNotify();
		
		if (_thread == null) {
			_thread = new Thread(this);
			_thread.start();
		}
	}
	
	public void update() {
		InputBank.update();
		SceneBank.update();
	}
	
	@Override
	public void paint(Graphics g) {
		Image img = createImage(Constants.WIDTH, Constants.HEIGHT);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		draw(g2);
		g.drawImage(img, 0, 0, Constants.WIDTH, Constants.HEIGHT, null);
	}
	
	public void draw(Graphics g) {
		SceneBank.draw(g);
	}
}
