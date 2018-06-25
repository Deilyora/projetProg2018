package view;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import data.*;
/**
* This class creates the BoardPanel : it displays a graphic board with all the pawns.
*/
public class BoardPanel extends JPanel{

	private static final int height = 7;
	private static final int width = 8;
	private static java.awt.Color white=java.awt.Color.WHITE;

	public BoardPanel(){
		Square[][] theGrid=new Square[this.height][this.width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				theGrid[i][j]=new Square(i,j);
			}
		}
		setLayout(new GridLayout(this.height,this.width));

		this.setBoard(theGrid);
	}
	public void setBoard(Square[][] grid){
		removeAll();
		ImageIcon img= null;
		for(int i=0;i<this.height;i++){

			for(int j=0;j<this.width;j++){
				Square theSquare=grid[i][j];
				Pawn greaterPawn = null;
				int rep=1;
				int nbPawns = theSquare.getPawns().size();
				if (nbPawns!=0) {
					greaterPawn = theSquare.getPawns().get(nbPawns-1);
				}
				else {
					rep=0;
				}
				if (greaterPawn != null) {

					if (greaterPawn instanceof PawnS1 && greaterPawn.getColor()==data.Color.RED) {
						rep =1;
					}
					else if (greaterPawn instanceof PawnS2 && greaterPawn.getColor()==data.Color.RED) {
						rep =2;
					}
					else if (greaterPawn instanceof PawnS3 && greaterPawn.getColor()==data.Color.RED) {
						rep =3;
					}
					else if (greaterPawn instanceof PawnS4 && greaterPawn.getColor()==data.Color.RED) {
						rep =4;
					}
					else if (greaterPawn instanceof PawnS1 && greaterPawn.getColor()==data.Color.GREEN) {
						rep =5;
					}
					else if (greaterPawn instanceof PawnS2 && greaterPawn.getColor()==data.Color.GREEN) {
						rep =6;
					}
					else if (greaterPawn instanceof PawnS3 && greaterPawn.getColor()==data.Color.GREEN) {
						rep =7;
					}
					else if (greaterPawn instanceof PawnS4 && greaterPawn.getColor()==data.Color.GREEN) {
						rep =8;
					}
				}
				switch(rep){
					case 0:
					img=new ImageIcon("../image/void.png");
					break;
					case 1:
					img=new ImageIcon("../image/1R.png");
					break;
					case 2:
					img=new ImageIcon("../image/2R.png");
					break;
					case 3:
					img=new ImageIcon("../image/3R.png");
					break;
					case 4:
					img=new ImageIcon("../image/4R.png");
					break;
					case 5:
					img=new ImageIcon("../image/1V.png");
					break;
					case 6:
					img=new ImageIcon("../image/2V.png");
					break;
					case 7:
					img=new ImageIcon("../image/3V.png");
					break;
					case 8:
					img=new ImageIcon("../image/4V.png");
					break;
					default:
					break;
				}
				GridButton button=new GridButton(img,i,j);
				button.setBackground(white);
				add(button);
				revalidate();
				repaint();
			}
		}
	}
}
