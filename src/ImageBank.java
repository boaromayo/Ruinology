import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.*;

public class ImageBank {
	// SINGLETON OBJECT.
	private static ImageBank _ib = null;
	
	private ImageBank() {}
	
	/*========================
	// Call instance to ensure only one object is made. Special thanks to:
	// "http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples"
	// "http://www.tutorialspoint.com/java/java_using_singleton.htm" and
	// "http://www.oodesign.com/singleton-pattern.html" for information. 
	//=========================*/
	public static ImageBank getInstance() {
		// Deal with thread concurrency issues with this block.
		synchronized (ImageBank.class) {
			if (_ib == null)
				_ib = new ImageBank(); // Create Singleton object.
		}
		
		return _ib;
	}
	
	public Image loadImageIcon(String path) {
		try {
			System.out.println("Image loading...");
			return Toolkit.getDefaultToolkit().createImage(path);
		} catch (Exception e) {
			System.err.println("ERROR: Image failed to load.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public BufferedImage loadImage(String path) {
		try {
			System.out.println("Image loading...");
			BufferedImage bi = ImageIO.read(new File(path));
			return bi;
		} catch (Exception e) {
			System.err.println("ERROR: Image failed to load.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public BufferedImage[] loadImages(String path, int x, int y, int w, int h, int frames) {
		try {
			BufferedImage img = loadImage(path);
			BufferedImage[] newImg = new BufferedImage[frames];
			for (int i = 0; i < frames; i++) {
				newImg[i] = img.getSubimage(x*i, y*i, w, h);
			}
			return newImg;
		} catch (Exception e) {
			System.err.println("ERROR: Failed to partition images.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
