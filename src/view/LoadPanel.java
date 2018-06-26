package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create the panel that enables loading of games
 */
public class LoadPanel extends JPanel {
	
	private JTextField filename;
	private JButton ok;
	private JButton back;
	
	/**
	 * The constructor of the panel containing all the elements to display
	 */
	public LoadPanel() {
		this.filename = new JTextField("name of the save");
		this.ok = new JButton("OK");
		this.back = new JButton("BACK");
		JLabel empty = new JLabel(" ");
		setLayout(new GridLayout(2,2));
		add(filename);
		add(empty);
		add(ok);
		add(back);
		setSize(500,500);
	}
	
	/**
	 * Return the button "ok" used to validate the loading
	 * @return the button ok
	 */
	public JButton getOkButton() {
		return this.ok;
	}
	
	/**
	 * Return the button "back" used to get back to the main menu
	 * @return the button back
	 */
	public JButton getBackButton() {
		return this.back;
	}
}