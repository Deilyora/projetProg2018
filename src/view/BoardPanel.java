package view;
import javax.swing.*;
import java.awt.*;
/**
 * This class creates the BoardPanel : it displays a graphic board with all the pawns.
 */
public class BoardPanel extends JPanel{

	private static final int height = 7;
	private static final int width = 8;
	private static Color white=Color.WHITE;
	private static Color black=Color.BLACK;


	public BoardPanel(){
		setLayout(new GridLayout(this.height,this.width));
		Color temp;
		for(int i=0;i<height;i++){
			if(i%2==0){
				temp=white
			}
			else{
				temp=black;
			}
			for(int j=0;j<width;j++){
				JPanel panel=new JPanel();
				panel.setBackground(temp);
				add(panel);
				if(temp.equals(white)){
					temp=black;
				}
				else{
					temp=white;
				}
				add(panel);
			}
		}
	}
}
