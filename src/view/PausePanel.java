package view;

import javax.swing.*;
import java.awt.*;
/**
 * This class creates the PausePanel, the menu displayed when the user pauses a running game.
 */
public class PausePanel {
	
	private JLabel title;
	private JButton save;
	private JButton quit;

	public PausePanel(){
		this.title = new JLabel("PAUSED");
		this.save = new JButton("SAVE");
		this.quit = new JButton("QUIT");
		
		setLayout(GridLayout(3,1));
		
		add(title);
		add(save);
		add(quit);
	}
	
	public JButton getSaveButton() {
		return this.save;
	}
	
	public JButton getQuitButton() {
		return this.quit;
	}
}
