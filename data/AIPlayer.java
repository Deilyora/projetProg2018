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
	public void play() {
		int rdPawn = (int) (Math.random() * this.pawnList.length);
		int[] newMove = new int[3];
		newMove = {-1, 0, 1};
		int rdPosX = (int) (Math.random() * this.pawnList[rdPawn].getPosX() + newMove[(int) Math.Random() * 3];
		int rdPosY = (int) (Math.random() * this.pawnList[rdPawn].getPosY() + newMove[(int) Math.Random() * 3];
		boolean release = false;
		while (!this.pawnList[rdPawn].movePawn(rdPosX, rdPosY, release) {
			rdPosX = (int) (Math.random() * this.pawnList[rdPawn].getPosX() + newMove[(int) Math.Random() * 3];
			rdPosY = (int) (Math.random() * this.pawnList[rdPawn].getPosY() + newMove[(int) Math.Random() * 3];		
		}			
		
	}

}
