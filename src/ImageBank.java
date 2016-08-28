import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.*;

public class ImageBank {

	private ImageBank() {}
	
	public static Image loadImageIcon(String path) {
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
	
	public static BufferedImage loadImage(String path) {
		try {
			System.out.println("Image loading...");
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			System.err.println("ERROR: Image failed to load.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
