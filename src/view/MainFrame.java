package view;
import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * This class creates the MainFrame of the game. It manages all the different panels of the game :
 * The popup menu when the game is over
 * The Menu when you start the game
 * The board of the current game
 * The in game pause menu
 * The options panel
 */
public class MainFrame extends JFrame{

/*	private PopUp popUp;
	private MenuPanel menu;

	private PausePanel pause;
*/
	private BoardPanel board;

	public MainFrame(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ARCANOR");
	//	PopUp thePopUp = new PopUp();
	//	MenuPanel menu = new MenuPanel();
		this.board = new BoardPanel();
	//	PausePanel pause = new PausePanel();
	//	ChoosePanel choose = new ChoosePanel();


		add(board);
		pack();
	}



	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
	public BoardPanel getBoardPanel(){
		return this.board;
	}
	public void setFrame(JPanel oldFrame, JPanel newFrame, boolean hideBoard, boolean displayBoard) {
		if (hideBoard) {
			oldFrame.setVisible(false);
			add(newFrame);
			revalidate();
			pack();
		}
		else if (displayBoard) {
			remove(oldFrame);
			newFrame.setVisible(true);
			revalidate();
			pack();
		}
		else {
			remove(oldFrame);
			add(newFrame);
			revalidate();
			pack();
		}
	}
}
