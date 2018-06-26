package view;

import java.awt.*;
import javax.swing.*;
/**
 * This class creates the menu when you start the game with all the different options.
 */
public class MenuPanel extends JPanel{
	
	private JButton newGame;
	private JButton loadGame;
	private JButton quit;

	/**
	 * the constructor used to creates the components of the panel
	 */
	public MenuPanel() {

		this.newGame = new JButton("NEW GAME");
		this.loadGame = new JButton("LOAD GAME");
		this.quit = new JButton("QUIT");
		setLayout(new GridLayout(3,1));
		

		add(this.newGame);
		add(this.loadGame);
		add(this.quit);
		
		
	}
	/**
	 * Gets the button used to create a new game
	 * @return the new game button
	 */
	public JButton getNewGameButton() {
		return this.newGame;
	}
	/**
	 * Gets the button used to load a game
	 * @return the load game button
	 */
	public JButton getLoadGameButton() {
		return this.loadGame;
	}
	/**
	 * Gets the button used to quit the game
	 * @return the quit button
	 */
	public JButton getQuitButton() {
		return this.quit;
	}
}
