package content;
import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.*;

public final class ImageBank {
	// Prevents any client code instantiation.
	private ImageBank() {}
	
	// SINGLETON OBJECT.
	private static ImageBank _ib = null;
	
	//========================
	// Call instance to ensure only one object is made. Special thanks to:
	// "http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples"
	// "http://www.tutorialspoint.com/java/java_using_singleton.htm" and
	// "http://www.oodesign.com/singleton-pattern.html" for information. 
	//=========================
	public static ImageBank get() {
		// Deal with thread concurrency issues with this block.
		if (_ib == null) {
			synchronized (ImageBank.class) {
				if (_ib == null)
					_ib = new ImageBank(); // Create Singleton object.
			}
		}
		
		return _ib;
	}
	
	// FOR THE APPLICATION ICON.
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
		System.out.println("Loading image file...");
		BufferedImage bi;
		try {
			System.out.println("Loading images...");
			bi = ImageIO.read(new File(path));
			BufferedImage img = new BufferedImage( 
					bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.createGraphics();
			g.drawImage(bi, 0, 0, null);
			g.dispose();
			return img;
		} catch (Exception e) {
			System.err.println("ERROR: Image failed to load.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public BufferedImage[][] loadImages(String path, int x, int y, int size) {
		return loadImages(path, x, y, size, size);
	}
	
	public BufferedImage[][] loadImages(String path, int x, int y, int w, int h) {
		try {
			BufferedImage img = loadImage(path);
			// Get dimensions for each entry based on actual img size / needed size
			int col = (int) (img.getWidth() / w);
			int row = (int) (img.getHeight() / h);
			// Put images in
			BufferedImage[][] newImg = new BufferedImage[row][col];
			for (int j = 0; j < row; j++) {
				y = j * h;
				for (int i = 0; i < col; i++) {
					x = i * w;
					newImg[j][i] = img.getSubimage(x, y, w, h);
				}
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
