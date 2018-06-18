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
	public Game(Player player1, Player player2,int width, int height,Board board, int nbOfPawns, boolean vsIA) {
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
