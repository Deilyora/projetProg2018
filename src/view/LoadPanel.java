package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create the panel that enables loading of games
 */
public class LoadPanel extends JPanel {

	private JLabel name;
	private JTextField filename;
	private JButton ok;
	private JButton back;

	/**
	 * The constructor of the panel containing all the elements to display
	 */
	public LoadPanel() {
		this.filename = new JTextField();
		this.name= new JLabel("Name of the save");
		this.ok = new JButton("OK");
		this.back = new JButton("BACK");
		setLayout(new GridLayout(4,1));
		add(name);
		add(filename);
		add(ok);
		add(back);

	}

	/**
	 * Return the button "ok" used to validate the loading
	 * @return the button ok
	 */
	public JButton getOkButton() {
		return this.ok;
	}
	/**
	* Returns the name of the file entered
	* @return the name of the file
	*/
	public String getFileName(){
		return this.filename.getText();
	}
	/**
	 * Return the button "back" used to get back to the main menu
	 * @return the button back
	 */
	public JButton getBackButton() {
		return this.back;
	}
}
