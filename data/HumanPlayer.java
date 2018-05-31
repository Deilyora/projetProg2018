package data;
/**
 * This class is used to represent a human player.
 * Human players choose their own name.
 */
public class HumanPlayer extends Player {

	/**
	 * This is the constructor of the class, it defines the name of the player
	 * @param nom the name chosen by the human player
	 * @param pawnList the pawns of the player
	 */
	public HumanPlayer(String nom,Pawn[] pawnList) {
		super(nom, pawnList);
	}


	/**
	 * This method manages the next move of the human player
	 * It asks the player wich pawn he wants to move, and where he wants to move it.
	 */
	public void play() {

	}
}
