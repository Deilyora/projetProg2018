package view;

import javax.swing.*;
import java.awt.*;
/**
 * This class creates the PausePanel, the menu displayed when the user pauses a running game.
 */
public class PausePanel extends JPanel{
	
	private JLabel title;
	private JButton save;
	private JButton quit;
	private JButton back;

	public PausePanel(){
		this.title = new JLabel("PAUSED");
		this.save = new JButton("SAVE");
		this.quit = new JButton("QUIT");
		this.back = new JButton("BACK");
		
		setLayout(new GridLayout(4,1));
		
		add(back);
		add(title);
		add(save);
		add(quit);
		setSize(500,500);
	}
	
	public JButton getSaveButton() {
		return this.save;
	}
	
	public JButton getQuitButton() {
		return this.quit;
	}
	
	public JButton getBackButton() {
		return this.back;
	}
}
