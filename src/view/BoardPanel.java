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
	private Board theBoard;
	private JLabel red;
	private JLabel redScore;
	private JLabel green;
	private JLabel greenScore;
	private JPanel center;
	private JPanel bottom;
	private JPanel right;
	private JButton move;
	private JButton release;
	private ArrayList<GridButton> buttonsGrid;
	public BoardPanel(){
		this.buttonsGrid=new ArrayList<GridButton>();
		Square[][] theGrid=new Square[this.height][this.width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				theGrid[i][j]=new Square(i,j);
			}
		}
		this.center = new JPanel();
		this.center.setLayout(new GridLayout(this.height,this.width));
		this.setBoard(theGrid);

		this.bottom= new JPanel();
		this.bottom.setLayout(new FlowLayout());
		this.move=new JButton("Move");
		this.release=new JButton("Move and release");
		this.bottom.add(move);
		this.bottom.add(release);

		this.right= new JPanel();
		this.right.setLayout(new GridLayout(4,1));
		this.red=new JLabel("RED");
		this.redScore=new JLabel("0");
		this.greenScore=new JLabel("0");
		this.green=new JLabel("GREEN");
		this.right.add(red);
		this.right.add(redScore);
		this.right.add(greenScore);
		this.right.add(green);

		setLayout(new BorderLayout());
		add(center,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		add(right,BorderLayout.EAST);
	}
	public void boardInit(Board theBoard){
		this.theBoard=theBoard;
	}
	public ArrayList<GridButton> getButtonsGrid(){
		return this.buttonsGrid;
	}
	public JButton getMoveButton(){
		return this.move;
	}
	public JButton getReleaseButton(){
		return this.release;
	}
	public void setScore(){
		this.redScore.setText(""+this.theBoard.getPoints(data.Color.RED));
		this.greenScore.setText(""+this.theBoard.getPoints(data.Color.GREEN));
	}
	public void setBoard(Square[][] grid){
		this.center.removeAll();
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
				this.center.add(button);
				this.buttonsGrid.add(button);
				revalidate();
				repaint();
			}
		}
	}
}
