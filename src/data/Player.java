package data;
/**
 * This class manages the 2 players in the game. It's abstract because there's 2 subtypes
 * of players : human and IA. It contains the name of the player, and 2 lists of pawns, one with the pawns that are still
 * movable and one with the pawn that are on the last line, meaning they're cannot be moved again
 * and give points to that player.
 */
public abstract class Player {

	private String playerName;
	private Pawn[] pawnList;
	private Pawn[] frozenList;
	private Board board;

	/**
	 * The constructor of the Player has two attribute, the name of that player and his pawns.
	 * AI player will always have the same defined name.
	 * @param name The name of the player
	 * @param pawns the pawns of the player
	 */
	public Player(String name,Pawn[] pawns,Board board) {
		this.playerName = name;
		this.pawnList = pawns;
		this.frozenList = new Pawn[12];
		this.board=board;
	}

	/**
	 * Gets the array with the pawns that are still movable
	 * @return the array of the pawns still movable
	 */
	public Pawn[] getPawnList() {
		return this.pawnList;
	}

	/**
	 * Changes the array of movable pawns with a new one
	 * @param pawnList The new array of pawns
	 */
	public void setPawnList(Pawn[] pawnList) {
		this.pawnList = pawnList;
	}

	/**
	 * Gets the array with the frozen pawns of the player
	 * @return the array with the frozen pawns
	 */
	public Pawn[] getFrozenList() {
		return this.frozenList;
	}
	/**
	 * Replaces the array of frozen pawns with a new one
	 * @param frozen the new array of pawns
	 */
	public void setFrozenList(Pawn[] frozen) {
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
	 * This method manages the next move of a player, whether or not it is a human player.
	 */
	public abstract void play();
}
