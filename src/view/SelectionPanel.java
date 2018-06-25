package view;
import javax.swing.*;
import java.awt.*;

public class SelectionPanel extends JPanel {
	
	private JButton ok;
	private JTextField player1;
	private JTextField player2;
	private JRadioButton pvp;
	private JRadioButton pve;
	private JRadioButton eve;
	private ButtonGroup mode;
	private JButton back;
	
	public SelectionPanel() {
		this.ok = new JButton("OK");
		this.player1 = new JTextField("Player 1 name");
		this.player2 = new JTextField("Player 2 name");		
		this.pvp = new JRadioButton("Player vs Player");
		this.pve = new JRadioButton("Player vs AI");
		this.eve = new JRadioButton("AI vs AI");
		this.mode = new ButtonGroup();
		this.back = new JButton("BACK");
		mode.add(pvp);
		mode.add(pve);
		mode.add(eve);
		setLayout(new GridLayout(7,1));
		add(player1);
		add(player2);
		add(pvp);
		add(pve);
		add(eve);
		add(ok);
		add(back);
		setSize(500,500);
		
	}
	
	public JButton getOkButton() {
		return this.ok;
	}
	
	public JButton getBackButton() {
		return this.back;
	}
}