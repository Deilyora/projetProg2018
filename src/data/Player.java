package data;
import java.util.ArrayList;
/**
* This class manages the 2 players in the game. It's abstract because there's 2 subtypes
* of players : human and IA. It contains the name of the player, and 2 lists of pawns, one with the pawns that are still
* movable and one with the pawn that are on the last line, meaning they're cannot be moved again
* and give points to that player.
*/
public abstract class Player {

	private String playerName;
	private ArrayList<Pawn> pawnList;
	private ArrayList<Pawn> frozenList;
	private Board board;
	private boolean top;

	/**
	* The constructor of the Player has two attribute, the name of that player and his pawns.
	* AI player will always have the same defined name.
	* @param name The name of the player
	* @param pawns the pawns of the player
	* @param top whether or not the player is at the top of the board
	*/
	public Player(String name,ArrayList<Pawn> pawns,Board board,boolean top) {
		this.playerName = name;
		this.pawnList = pawns;
		this.frozenList = new ArrayList<Pawn>();
		this.board=board;
		this.top=top;
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
	* Gets the array with the frozen pawns of the player
	* @return the array with the frozen pawns
	*/
	public ArrayList<Pawn> getFrozenList() {
		return this.frozenList;
	}
	/**
	* Replaces the array of frozen pawns with a new one
	* @param frozen the new array of pawns
	*/
	public void setFrozenList(ArrayList<Pawn> frozen) {
		this.frozenList = frozen;
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
	* This method manages the next move of a player, whether or not it is a human player.
	*/
	public abstract void play();
}
