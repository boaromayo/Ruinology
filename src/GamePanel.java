import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
	
	// SCENE BANK.
	private SceneBank _sb;
		
	// MAIN THREAD.
	private Thread _thread;
	
	public GamePanel() {
		init();
	}
	
	public void init() {
		_sb = new SceneBank();
			
		setFocusable(true);
		requestFocus();
		
		//addKeyListener();
	}
	
	public void run() {
		long startTime, diffTime;
		
		long waitTime;
		
		long targetTime = 1000/(Game.FPS);
		
		//long timeElapsed = 0;
		
		int framecount = 0;
		int maxframecount = Game.FPS;
		
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
		_sb.update();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image img = createImage(Game.WIDTH, Game.HEIGHT);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		draw(g2);
		g.drawImage(img, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
	
	public void draw(Graphics g) {
		_sb.draw(g);
	}
}
