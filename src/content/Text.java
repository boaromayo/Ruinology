package content;
import java.awt.*;
import java.awt.image.*;

public final class Text {

	// TEXT.
	//private static BufferedImage [][] _text = Constants._font;
	
	public static void draw(Graphics g, String str, int x, int y) {
		// convert upcased string to char array to handle letter-by-letter.
		str = str.toUpperCase();
		char [] cset = str.toCharArray(); 
		
		for (int i = 0; i < cset.length; i++) {
			int ch = cset[i]; // set char to an int
			
			if (ch > 48 && ch < 57) {
				
			}
			if (ch > 90) {
				ch -= 32; // 
			}
			
			/*int r = ch / 32; // row
			int c = ch % 32; // column for the text
			g.drawImage(_text[r][c], x, y, null);*/
		}
	}
}
