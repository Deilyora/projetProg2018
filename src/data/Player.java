package data;
import java.util.ArrayList;
/**
* This class manages the 2 players in the game. It's abstract because there's 2 subtypes
* of players : human and IA. It contains the name of the player, and 2 lists of pawns, one with the pawns that are still
* movable and one with the pawn that are on the last line, meaning they're cannot be moved again
* and give points to that player.
*/
public abstract class Player implements Serializable  {

	private String playerName;
	private ArrayList<Pawn> pawnList;
	private Board board;
	private boolean top;
	private Color playerColor;

	/**
	* The constructor of the Player has two attribute, the name of that player and his pawns.
	* AI player will always have the same defined name.
	* @param name The name of the player
	* @param pawns the pawns of the player
	* @param top whether or not the player is at the top of the board
	* @param board the board
	* @param color the color of the player
	*/
	public Player(String name,ArrayList<Pawn> pawns,Board board,boolean top, Color color) {
		this.playerName = name;
		this.pawnList = pawns;
		this.board=board;
		this.top=top;
		this.playerColor = color;
	}

	/**
	* Gets the array with the pawns that are still movable
	* @return the array of the pawns still movable
	*/
	public ArrayList<Pawn> getPawnList() {
		return this.pawnList;
	}

	/**
	* Changes the array of movable pawns with a new one
	* @param pawnList The new array of pawns
	*/
	public void setPawnList(ArrayList<Pawn> pawnList) {
		this.pawnList = pawnList;
	}

	/**
	* Gets the name of the player
	* @return the name of the player
	*/
	public String getPlayerName() {
		return this.playerName;
	}
	/**
	* Returns the game board
	* @return the game board
	*/
	public Board getBoard(){
		return this.board;
	}
	/**
	* Returns top's value
	* @return top's value
	*/
	public boolean getTop(){
		return this.top;
	}
	/**
	 * Return the color of the player
	 * @return the color of the player
	 */
	public Color getColor() {
		return this.playerColor;
	}
	/**
	* This method manages the next move of a player, whether or not it is a human player.
	*/
	public abstract void play();
}
