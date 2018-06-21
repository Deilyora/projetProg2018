package view;
import javax.swing.*;
import java.awt.*;
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
	private BoardPanel board;
	private PausePanel pause;
*/
	public MainFrame(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ARCANOR");
	//	PopUp thePopUp = new PopUp();
		MenuPanel menu = new MenuPanel();
	//	BoardPanel board = new Boardpanel();
	//	PausePanel pause = new PausePanel();
	//	ChoosePanel choose = new ChoosePanel();
		add(menu);
	}



	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}
