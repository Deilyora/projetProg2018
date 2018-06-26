package controller;
import data.*;
import view.*;
import java.awt.event.*;
/**
* This class handles all the action on the GUI.
*/
public class MainListener implements ActionListener{

	private MainFrame theMain;
	private MenuPanel menu;
	private BoardPanel board;
	private PausePanel pause;
	private PopUp popUp;
	private SelectionPanel selection;
	private LoadPanel load;
	private int buttonPressed;
	private Game game;
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;

	public MainListener(MainFrame theMain, MenuPanel menu, BoardPanel board, PausePanel pause, PopUp popUp, SelectionPanel selection, LoadPanel load) {
		this.theMain = theMain;
		this.menu = menu;
		this.board = board;
		this.pause = pause;
		this.popUp = popUp;
		this.selection = selection;
		this.load = load;
		this.buttonPressed=0;
		this.game=null;
		this.oldX=-1;
		this.newX=-1;
		this.oldY=-1;
		this.newY=-1;
	}

	/**
	* This method handles the action on the GUI and interacts with the data part.
	* @param ev the event that happened on the GUI
	*/
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == menu.getNewGameButton()) {
			theMain.setFrame(menu,selection,false,false);
		}
		else if (ev.getSource() == menu.getLoadGameButton()) {
			theMain.setFrame(menu,load,false,false);
		}
		else if (ev.getSource() == menu.getQuitButton()) {
			System.exit(0);
		}
		else if (ev.getSource() == pause.getSaveButton()) {
			//Sauvegarde
		}
		else if (ev.getSource() == pause.getQuitButton()) {
			System.exit(0);
		}
		else if (ev.getSource() == pause.getBackButton()) {
			theMain.setFrame(pause,board,false,true);
		}
		else if (ev.getSource() == selection.getOkButton()) {
			String playerName1 = selection.getPlayer1().getText();
			String playerName2 = selection.getPlayer2().getText();
			Mode mode = null;
			if (selection.getPVPButton().isSelected()) {
				mode = Mode.HH;
			}
			else if (selection.getPVEButton().isSelected()) {
				mode = Mode.HA;
			}
			else {
				mode = mode.AA;
			}

			Game theGame = new Game(playerName1, playerName2, mode, 7, 8);
			theGame.setCurrentPlayer();
			this.game=theGame;

			this.board.boardInit(theGame.getBoard());
			this.board.setBoard(theGame.getBoard().getGrid());
			this.board.setScore();
			theMain.setGridListener();
			theMain.setFrame(selection,board,false,true);
			//theGame.runGame();

		}
		else if (ev.getSource() == selection.getBackButton()) {
			theMain.setFrame(selection,menu,false,false);
		}
		else if (ev.getSource() == popUp.getEndButton()) {
			System.exit(0);
		}
		else if (ev.getSource() == load.getOkButton()) {
			//check if file exists
			theMain.setFrame(load,board,false,true);
		}
		else if (ev.getSource() == load.getBackButton()) {
			theMain.setFrame(load,menu,false,false);
		}
		else if (ev.getSource() == board.getMoveButton()) {
			Player player=game.getCurrentPlayer();
			boolean bool=game.getBoard().movePawn(oldX,oldY,newX,newY,false,player);
			if(bool){
				game.setCurrentPlayer();
			}
			this.board.setBoard(game.getBoard().getGrid());
			this.board.setScore();
			theMain.setGridListener();
		}
		else if (ev.getSource() == board.getReleaseButton()) {
			Player player=game.getCurrentPlayer();
			boolean bool=game.getBoard().movePawn(oldX,oldY,newX,newY,true,player);
			if(bool){
				game.setCurrentPlayer();
			}
			this.board.setBoard(game.getBoard().getGrid());
			this.board.setScore();
			theMain.setGridListener();
		}
		else if(ev.getSource() instanceof GridButton){
			this.buttonPressed++;
			GridButton button=(GridButton)ev.getSource();
			if(this.buttonPressed==1){
				this.oldX=button.x;
				this.oldY=button.y;
				this.newX=-1;
				this.newY=-1;
				System.out.println("oldX:"+oldX+" oldY:"+oldY);
				System.out.println("newX:"+newX+" newY:"+newY);
			}
			else{
				this.newX=button.x;
				this.newY=button.y;
				buttonPressed=0;
				System.out.println("oldX:"+oldX+" oldY:"+oldY);
				System.out.println("newX:"+newX+" newY:"+newY);
			}
		}
	}

}
