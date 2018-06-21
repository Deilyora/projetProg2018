package data;
import java.util.*;
import java.io.*;
/**
* This class is used to define and manage a game. It creates 2 players and the board as a grid of squares.
*/
public class Game implements Serializable {

	private Player player1;
	private Player player2;
	private Player current;
	private Board board;


	/**
	* The Game constructor : it gets everything needed to create the game :
	* Board, size, gamemode, name of players, mode. It then creates the game with these parameters
	* @param playerName1 the name of the player 1
	* @param playerName2 the name of the player 2
	* @param mode the gamemode (AI/Human)
	*/
	public Game(String playerName1, String playerName2, Mode theMode, int height, int width) {
		ArrayList<Pawn> arrayp1 = new ArrayList<Pawn>();
		ArrayList<Pawn> arrayp2 = new ArrayList<Pawn>();
		Square[][] theGrid = initializeGrid(height, width, arrayp1, arrayp2);
		this.board = new Board(width, height, theGrid);
		createPlayers(playerName1,playerName2,arrayp1,arrayp2, theMode);
	}

	/**
	*
	*/
	private Square[][] initializeGrid(int height,int width,ArrayList<Pawn> arrayP1,ArrayList<Pawn> arrayP2){
		Square[][] grid=new Square[height][width];
		if(width>=8){
			for(int i=0;i<height;i++){
				for(int j=0;j<width;j++){
					grid[i][j]=new Square(i,j);
				}
			}

			PawnS4 s4=null;
			PawnS3 s3=null;
			PawnS2 s2=null;
			PawnS1 s1=null;
			Square sq=null;
			Square sq2=null;
			Color color=Color.RED;
			int x=0;
			int y=0;
			for(int i=0;i<3;i++){
				s4=new PawnS4(x,y,false,true,color);
				s3=new PawnS3(x,y,true,false,color);
				arrayP1.add(s4);
				arrayP1.add(s3);
				sq=new Square(x,y);
				sq.addPawn(s4);
				sq.addPawn(s3);
				grid[x][y]=sq;
				s2=new PawnS2(x,y+1,false,true,color);
				s1=new PawnS1(x,y+1,true,false,color);
				arrayP1.add(s2);
				arrayP1.add(s1);
				sq2=new Square(x,y+1);
				sq2.addPawn(s2);
				sq2.addPawn(s1);
				grid[x][y+1]=sq2;
				y+=3;
			}
			color=Color.GREEN;
			x=height-1;
			y=0;
			for(int j=0;j<3;j++){
				s4=new PawnS4(x,y+1,false,true,color);
				s3=new PawnS3(x,y+1,true,false,color);
				arrayP2.add(s4);
				arrayP2.add(s3);
				sq=new Square(x,y+1);
				sq.addPawn(s4);
				sq.addPawn(s3);
				grid[x][y+1]=sq;
				s2=new PawnS2(x,y,false,true,color);
				s1=new PawnS1(x,y,true,false,color);
				arrayP2.add(s2);
				arrayP2.add(s1);
				sq2=new Square(x,y);
				sq2.addPawn(s2);
				sq2.addPawn(s1);
				grid[x][y]=sq2;
				y+=3;
			}

		}

		else{
			System.out.println("initializeGrid error : width<8 : "+width);
		}
		return grid;
	}
	/**
	* Gets the player1.
	* @return the player1
	*/
	public Player getPlayer1() {
		return this.player1;
	}

	/**
	* Replaces the player 1 with another one.
	* @param player1
	*/
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}


	/**
	* Gets the player2.
	* @return the player2
	*/
	public Player getPlayer2() {
		return this.player2;
	}

	/**
	* Replaces the player 2 with another one.
	* @param player2
	*/
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}


	/**
	* Creates the players
	* @param name1 the name of player 1
	* @param name2 the name of player 2
	* @param arrayp1 the arraylist of pawns of player 1
	* @param arrayp2 the arraylist of pawns of player 2
	* @param theMode the mode of the game
	*/
	private void createPlayers(String name1, String name2, ArrayList<Pawn> arrayp1, ArrayList<Pawn> arrayp2, Mode theMode) {
		if (theMode == Mode.HH) {
			this.player1 = new HumanPlayer(name1, arrayp1,this.board,true,Color.RED);
			this.player2 = new HumanPlayer(name2, arrayp2,this.board,false,Color.GREEN);
		}
		else if(theMode == Mode.HA) {
			this.player1 = new HumanPlayer(name1, arrayp1, this.board,true,Color.RED);
			this.player2 = new AIPlayer(name2, arrayp2, this.board,false,Color.GREEN);
		}
		else {
			this.player1 = new AIPlayer(name1, arrayp1, this.board,true,Color.RED);
			this.player2 = new AIPlayer(name2, arrayp2, this.board,false,Color.GREEN);
		}
	}
	/**
	* This method runs the game
	*/
	public void runGame() {
		this.current=this.player2;
		//if someones has 12 points; if both players cannot move;
		System.out.println(this.board);
		while (this.board.getPoints(this.current.getColor()) < 12) {

			if (this.current == this.player1) {
				this.current = this.player2;
			}
			else {
				this.current = this.player1;
			}
			System.out.println(current.getPlayerName()+"'s turn");
			this.current.play();
			System.out.println(this.board);
		}
		endGame();
	}
	/**
	* This method ends the game.
	*/
	public void endGame() {
		System.out.println(current.getPlayerName()+" won the game by being the first to score 12 points !");
		System.exit(0);
	}
	/**
	* This method saves the game in a file.
	* @return true if the game has been saved correctly
	*/
	public void saveGame(String fileName) {
		try {
			ObjectOutputStream out =  new ObjectOutputStream(new FileOutputStream("../save/"+fileName));
			out.writeObject(this);
			out.close();
			System.exit(0);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error - unknown file : "+fileName);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
