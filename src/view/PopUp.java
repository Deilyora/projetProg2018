package view;

import javax.swing.*;
import java.awt.*;
/**
 * This class creates the PopUp, a small window that appears when the game is over
 */
public class PopUp {
	
	private JLabel message;
	private JButton end;
	
	public PopUp(){
		this.message = new JLabel("Game ended");
		this.end = new JButton("QUIT");
	}
	
	public JButton getEndButton() {
		return this.end;
	}
}
