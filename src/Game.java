import java.awt.Dialog.*;
import javax.swing.*;

public class Game {
	
	// CONSTANTS.
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	public static final int FPS = 60;
	
	public static ImageBank _imageBank = ImageBank.getInstance();
	
	// MAIN FRAME.
	private JFrame _frame;
	
	// MAIN PANEL.
	private GamePanel _panel;
	
	public Game() {
		// Initialize game.
		init();
		
		// Set up frame.
		_frame.setTitle("Ruinology");
		_frame.setSize(WIDTH, HEIGHT);

		_frame.add(_panel);
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setLocationRelativeTo(null);
		_frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		_frame.setVisible(true);
		_frame.setResizable(false);
	}
	
	public void init() {
		// Initialize frame.
		_frame = new JFrame();
		
		// Initialize panel.
		_panel = new GamePanel();
	}
}
