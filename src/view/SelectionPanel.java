package view;
import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create the panel used to display the game choices before creating a new game
 */
public class SelectionPanel extends JPanel {
	
	private JButton ok;
	private JLabel nplayer1;
	private JLabel nplayer2;
	private JTextField player1;
	private JTextField player2;
	private JRadioButton pvp;
	private JRadioButton pve;
	private JRadioButton eve;
	private ButtonGroup mode;
	private JButton back;
	
	/**
	 * The constructor that creates all the components of the frame
	 */
	public SelectionPanel() {
		this.ok = new JButton("OK");
		this.nplayer1 = new JLabel("Player 1 name :");
		this.nplayer2 = new JLabel("Player 2 name :");	
		this.player1 = new JTextField("Player1");
		this.player2 = new JTextField("Player2");		
		this.pvp = new JRadioButton("Player vs Player", true);
		this.pve = new JRadioButton("Player vs AI");
		this.mode = new ButtonGroup();
		this.back = new JButton("BACK");
		mode.add(pvp);
		mode.add(pve);
		setLayout(new GridLayout(8,1));
		add(nplayer1);
		add(player1);
		add(nplayer2);
		add(player2);
		add(pvp);
		add(pve);
		add(ok);
		add(back);
		setSize(500,500);
		
	}

	/**
	 * Returns the "ok" button used to validate the choices on the game
	 * @return the button ok
	 */
	public JButton getOkButton() {
		return this.ok;
	}
	/**
	 * Returns the "back" button used to get back to the main menu
	 * @return the back button
	 */
	public JButton getBackButton() {
		return this.back;
	}
	/**
	 * Returns the textfield of the name of player 1
	 * @return player1's text field
	 */
	public JTextField getPlayer1() {
		return this.player1;
	}
	/**
	 * Returns the textfield of the name of player 
	 * @return player2's text field
	 */	
	public JTextField getPlayer2() {
		return this.player2;
	}
	
	/**
	 * Returns the radiobutton of a player vs player game
	 * @return the pvp radiobutton
	 */
	public JRadioButton getPVPButton() {
		return this.pvp;
	}
	/**
	 * Returns the radiobutton of a player vs IA game
	 * @return the pvp radiobutton
	 */	
	public JRadioButton getPVEButton() {
		return this.pve;
	}
	
	
}