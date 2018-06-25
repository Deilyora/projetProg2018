package view;

import javax.swing.*;
import java.awt.*;

public class LoadPanel extends JPanel {
	
	private JTextField filename;
	private JButton ok;
	private JButton back;
	
	
	public LoadPanel() {
		this.filename = new JTextField("name of the save");
		this.ok = new JButton("OK");
		this.back = new JButton("BACK");
		JLabel empty = new JLabel(" ");
		setLayout(new GridLayout(2,2));
		add(filename);
		add(empty);
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