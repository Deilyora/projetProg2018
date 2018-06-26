import view.*;
/**
 * This class is used to launch a game
 * The attribute game is the game actually playing
 */
public class Run   {

	/**
	 *Its the main of the run class.
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

}
