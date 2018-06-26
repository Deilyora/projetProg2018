package view;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import controller.*;
/**
* This class creates the MainFrame of the game. It manages all the different panels of the game :
* The popup menu when the game is over
* The Menu when you start the game
* The Menu when you load a game
* The board of the current game
* The in game pause menu
* The options panel
* The popup when the game is over
*/
public class MainFrame extends JFrame{

	/*	private PopUp popUp;
	private MenuPanel menu;

	private PausePanel pause;
	*/
	private BoardPanel board;
	private MainListener e;

	/**
	 * The constructor of the MainFrame that creates all the different panels and add the listener on all the buttons
	 */
	public MainFrame(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ARCANOR");

		PopUp thePopUp = new PopUp();
		MenuPanel menu = new MenuPanel();
		board = new BoardPanel();
		PausePanel pause = new PausePanel();
		SelectionPanel selection = new SelectionPanel();
		LoadPanel load = new LoadPanel();
		this.e = new MainListener(this, menu, board, pause, thePopUp, selection, load);
		menu.getNewGameButton().addActionListener(e);
		menu.getLoadGameButton().addActionListener(e);
		menu.getQuitButton().addActionListener(e);
		pause.getSaveButton().addActionListener(e);
		pause.getQuitButton().addActionListener(e);
		pause.getBackButton().addActionListener(e);
		thePopUp.getEndButton().addActionListener(e);
		selection.getOkButton().addActionListener(e);
		selection.getBackButton().addActionListener(e);
		load.getOkButton().addActionListener(e);
		load.getBackButton().addActionListener(e);
		this.board.getMoveButton().addActionListener(e);
		this.board.getReleaseButton().addActionListener(e);
		this.setGridListener();
		add(menu);

		pack();
		setSize(500,500);
	}
	/**
	 * This method creates action listeners for all the buttons on the play grid
	 */
	public void setGridListener(){
		ArrayList<GridButton> grid=this.board.getButtonsGrid();
		for(GridButton b : grid){
			b.addActionListener(e);
		}
	}

	/**
	 * The main of the class used to launch the Frame
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
	/**
	 * Gets the board panel 
	 * @return the board panel
	 */
	public BoardPanel getBoardPanel(){
		return this.board;
	}
	
	/**
	 * This method is used when the user clicks on a button that goes to another frame
	 * the old frame is removed and the new one is displayed
	 */
	public void setFrame(JPanel oldFrame, JPanel newFrame) {
		remove(oldFrame);
		add(newFrame);
		revalidate();
		pack();

	}
}
