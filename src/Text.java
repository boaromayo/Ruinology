import java.awt.*;
import java.awt.image.*;

public final class Text {

	// TEXT.
	private static BufferedImage _text = Constants._text;
	
	public static void draw(Graphics g, String text, int x, int y) {
		// convert text to char array to handle letter-by-letter.
		char [] baseText = text.toCharArray(); 
		
		for (int i = 0; i < baseText.length; i++) {
			
		}
	}
}
