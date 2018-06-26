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
	private JPanel top;
	private JButton move;
	private JButton release;
	private JButton pause;
	private ArrayList<GridButton> buttonsGrid;

	/**
	 * The constructor of boardpanel : initialize the grid with the pawns and the other buttons around the grid
	 */
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
		this.pause = new JButton("Pause");

		this.top = new JPanel();
		this.top.setLayout(new FlowLayout());
		this.top.add(pause);
		
		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		add(right,BorderLayout.EAST);
	}

	/**
	 * Initialize the Board (used to display the score)
	 * @param theBoard the current board
	 */
	public void boardInit(Board theBoard){
		this.theBoard=theBoard;
	}

	/**
	 * Gets the grid with button used to play pawns
	 * @return the arraylist of gridButtons
	 */
	public ArrayList<GridButton> getButtonsGrid(){
		return this.buttonsGrid;
	}

	/**
	 * gets the button to click to move a pawns
	 * @return the move button
	 */
	public JButton getMoveButton(){
		return this.move;
	}
	/**
	 * gets the button to click to release a pawns
	 * @return the release button
	 */
	public JButton getReleaseButton(){
		return this.release;
	}
	/**
	 * gets the button to pause the game
	 * @return the pause button
	 */
	public JButton getPauseButton() {
		return this.pause;
	}
	/**
	 * This method is used to display the score on the interface
	 */
	public void setScore(){
		this.redScore.setText(""+this.theBoard.getPoints(data.Color.RED));
		this.greenScore.setText(""+this.theBoard.getPoints(data.Color.GREEN));
	}
	/**
	 * This method creates the board of buttons using the grid of the game to place pawns and their color at the right place, displaying a real pawn on the button
	 * @param grid the grid with the placement of the pawns
	 */
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
