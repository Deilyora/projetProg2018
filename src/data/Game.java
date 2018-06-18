package data;
import java.util.Scanner;
/**
 * This class is used to define and manage a game. It creates 2 players and the board as a grid of squares.
 */
public class Game {

	private Player player1;
	private Player player2;
	private int width;
	private int height;
	private Board board;
	private int nbOfPawns;


	/**
	 * The Game constructor : it chooses a size for the board and create this board
	 * It choose if we play against the AI
	 * @param width
	 * @param height
	 * @param vsIA
	 */
	public Game(int width, int height, boolean vsIA) {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
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
	 * This method creates a new game.
	 */
	public void initializeGame() {
		String player1;
		String player2;
		int width = -1;
		int height = -1;
		int nbOfPawns = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of player 1");
		player1 = sc.nextLine();
		System.out.println("Enter the name of player 2");
		player2 = sc.nextLine();		
		System.out.println("width of the board ? Type 0 for default");
		while (!(width > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a valid number");
				sc.next();
			}
			width = sc.nextInt();
		}
		System.out.println("height of the board ? Type 0 for default");
		while (!(height > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a valid number");
				sc.next();
			}
			height = sc.nextInt();
		}
		System.out.println("Number of pawns par player ? Type 0 for default");
		
		while(!(nbOfPawns > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a vaild number");
				sc.next();
			}
			nbOfPawns = sc.nextInt();
		}
		this.width = width;
		this.height = height;
		this.player1 = player1;
		this.player2 = player2;
		this.nbOfPawns = nbOfPawns;
		Board theBoard = new Board(this.width, this.height);
		this.board = theBoard;
	}
		
		
		
		
	
	/**
	 * This method launches the game from a file's saved game
	 * @param fileName the name of the saved file's game
	 */
	public void runGame(String fileName) {

	}
	/**
	 * This method ends the game.
	 */
	public void endGame() {

	}
	/**
	 * This method saves the game in a file.
	 * @return true if the game has been saved correctly
	 */
	public boolean saveGame() {
		return false;
	}

}
