package view;
import javax.swing.*;
import java.awt.*;
/**
 * This class creates the BoardPanel : it displays a graphic board with all the pawns.
 */
public class BoardPanel extends JPanel{

	private static final int height = 7;
	private static final int width = 8;
	private static Color green=Color.GREEN;


	public BoardPanel(){
		setLayout(new GridLayout(this.height,this.width));

		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				JPanel panel=new JPanel();
				panel.setBackground(green);
			}
		}
	}
}
