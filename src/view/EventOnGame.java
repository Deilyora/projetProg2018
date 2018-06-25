package view;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class EventOnGame implements ActionListener {
	
	private MainFrame theMain;
	private MenuPanel menu;
	private BoardPanel board;
	private PausePanel pause;
	private PopUp popUp;
	private SelectionPanel selection;
	private LoadPanel load;
	
	public EventOnGame(MainFrame theMain, MenuPanel menu, BoardPanel board, PausePanel pause, PopUp popUp, SelectionPanel selection, LoadPanel load) {
		this.theMain = theMain;
		this.menu = menu;
		this.board = board;
		this.pause = pause;
		this.popUp = popUp;
		this.selection = selection;
		this.load = load;
	}
	
	public void actionPerformed (ActionEvent ev) {
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
			theMain.setFrame(selection,board,false,true);
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
	}
}

	
		
		
		
			