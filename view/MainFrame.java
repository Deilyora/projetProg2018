package view;

/**
 * This class creates the MainFrame of the game. It manages all the different panels of the game :
 * The popup menu when the game is over
 * The Menu when you start the game
 * The board of the current game
 * The in game pause menu
 * The options panel
 */
public class MainFrame {

	private PopUp popUp;
	private MenuPanel menu;
	private BoardPanel board;
	private PausePanel pause;
	private OptionPanel option;
	
	public MainFrame(){
		
	}
	
	/**
	 * Get the popUp
	 * @return the popUp
	 */
	public PopUp getPopUp() {
		return this.popUp;
	}
	
	/**
	 * Get the menu
	 * @return the menu
	 */
	public MenuPanel getMenu() {
		return this.menu;
	}

	/**
	 * Get the board of the game
	 * @return the board
	 */
	public BoardPanel getBoard() {
		return this.board;
	}

	/**
	 * Get the pause menu
	 * @return the pause
	 */
	public PausePanel getPause() {
		return this.pause;
	}

	/**
	 * Get the option menu
	 * @return the option
	 */
	public OptionPanel getOption() {
		return this.option;
	}

}
