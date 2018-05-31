package data;
/**
 * This class represents an automated player.
 * Automated players have a defined name.
 */
public class AIPlayer extends Player {

	/**
	 * The constructor of AIPlayer. The name of the player is directly written in the class.
	 * @param the pawns of the player
	 */
	public AIPlayer(Pawn[] pawnList) {
		super("Computer",pawnList);
		
	}

	/**
	 * This method manages the next move of the IA, randomly generated.
	 */
	public int[] play() {
		//play au hasard
	}

}
