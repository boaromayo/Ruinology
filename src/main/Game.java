package main;
import java.awt.Dialog.*;
import javax.swing.*;

import content.Constants;

public class Game {
	// MAIN FRAME.
	private JFrame _frame;
	
	// MAIN PANEL.
	private GamePanel _panel;
	
	public Game() {
		// Initialize game.
		init();
		
		// Set up frame.
		_frame.setTitle("Ruinology");
		_frame.setSize(Constants.WIDTH, Constants.HEIGHT);

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
