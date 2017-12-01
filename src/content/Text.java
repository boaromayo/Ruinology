package content;
import java.awt.*;
import java.awt.image.*;

import content.Constants;

public final class Text {

	// TEXT.
	private static BufferedImage [][] _text = Constants.getGameFont();
	
	public static void draw(Graphics g, String str, int x, int y) {
		// convert upcased string to char array to handle letter-by-letter.
		str = str.toUpperCase();
		char [] cset = str.toCharArray(); 
		
		for (int i = 0; i < cset.length; i++) {
			int ch = cset[i]; // set char to an int
			
			if (ch >= 48 && ch <= 57) {
				// for numbers, shift ch pos to 
			}
			
			int r = ch / 32; // row for the text
			int c = ch % 32; // column for the text
			g.drawImage(_text[r][c], x, y, null);
		}
	}
}
