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

	public MenuPanel(){
		this.newGame = new JButton("NEW GAME");
		this.loadGame = new JButton("LOAD GAME");
		this.quit = new JButton("QUIT");
		setLayout(new java.awt.BorderLayout());
		add(this.newGame, BorderLayout.CENTER);
		add(this.loadGame, BorderLayout.CENTER);
		add(this.quit, BorderLayout.CENTER);
	}
	
	public JButton getNewGameButton() {
		return this.newGame;
	}
	
	public JButton getLoadGameButton() {
		return this.loadGame;
	}
	
	public JButton getQuitButton() {
		return this.quit;
	}
}
