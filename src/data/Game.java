package data;
import java.util.Scanner;
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
	public Game(String playerName1, String playerName2, Mode theMode) {
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
	 * This method runs the game
	 */
	public void runGame() {
		if (current == null) {
			current = this.player2;
		}
		
		//if someones has 12 points; if both players cannot move; 
		while (board.getPoints(current) < 12) {

			else if (current == player1) {
				current = player2;
			}
			else {
				current = player1;
			}
			System.out.println(current.getPlayerName()+"'s turn");
			current.play();				
		}
		endGame();
	}
	/**
	 * This method ends the game.
	 */
	public void endGame() {
		System.out.println(current+" won the game by being the first to score 12 points !");
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
