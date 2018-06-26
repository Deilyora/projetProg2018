package view;

import javax.swing.*;
import java.awt.*;
/**
 * This class creates the PopUp, a small window that appears when the game is over
 */
public class PopUp extends JPanel {
	
	private JLabel message;
	private JButton end;
	
	/**
	 * the constructor that creates all components of the frame
	 */
	public PopUp(){
		this.message = new JLabel("Game ended");
		this.end = new JButton("QUIT");
		setLayout(new GridLayout(2,1));
		add(message);
		add(end);
		setSize(500,500);
	}
	
	/**
	 * Return the button that the user clicks to close the game
	 * @return the end button
	 */
	public JButton getEndButton() {
		return this.end;
	}
}
