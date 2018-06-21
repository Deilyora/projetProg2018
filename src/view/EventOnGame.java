package view;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EventOnGame implements ActionListener {

	private MenuPanel menu;
	private BoardPanel board;
	private PausePanel pause;
	private PopUp popUp;
	
	public ClickOnButton(menu, board, pause, popUp);
		this.menu = menu;
		this.board = board;
		this.pause = pause;
		this.popUp = popUp;
	}
	
	public void actionPerformed (ActionEvent ev) {
		