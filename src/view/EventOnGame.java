package view;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EventOnGame implements ActionListener {
	
	private MainFrame theMain;
	private MenuPanel menu;
	private BoardPanel board;
	private PausePanel pause;
	private PopUp popUp;
	
	public ClickOnButton(MainFrame theMain, MenuPanel menu, BoardPanel board, PausePanel pause, PopUp popUp);
		this.theMain = theMain;
		this.menu = menu;
		this.board = board;
		this.pause = pause;
		this.popUp = popUp;
	}
	
	public void actionPerformed (ActionEvent ev) {
		if (ev.getSource() == menu.getNewGameButton()) {
			theMain.setFrame(