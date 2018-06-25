package view;
import javax.swing.*;
import java.awt.*;

public class SelectionPanel extends JPanel {
	
	private JButton ok;
	private JLabel nplayer1;
	private JLabel nplayer2;
	private JTextField player1;
	private JTextField player2;
	private JRadioButton pvp;
	private JRadioButton pve;
	private JRadioButton eve;
	private ButtonGroup mode;
	private JButton back;
	
	public SelectionPanel() {
		this.ok = new JButton("OK");
		this.nplayer1 = new JLabel("Player 1 name :");
		this.nplayer2 = new JLabel("Player 2 name :");	
		this.player1 = new JTextField("Player1");
		this.player2 = new JTextField("Player2");		
		this.pvp = new JRadioButton("Player vs Player", true);
		this.pve = new JRadioButton("Player vs AI");
		this.eve = new JRadioButton("AI vs AI");
		this.mode = new ButtonGroup();
		this.back = new JButton("BACK");
		mode.add(pvp);
		mode.add(pve);
		mode.add(eve);
		setLayout(new GridLayout(9,1));
		add(nplayer1);
		add(player1);
		add(nplayer2);
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
	
	public JTextField getPlayer1() {
		return this.player1;
	}
	
	public JTextField getPlayer2() {
		return this.player2;
	}
	
	
	public JRadioButton getPVPButton() {
		return this.pvp;
	}
	
	public JRadioButton getPVEButton() {
		return this.pve;
	}
	
	public JRadioButton getEVEButton() {
		return this.eve;
	}
	
}