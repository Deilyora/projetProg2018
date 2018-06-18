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
	public AIPlayer(Pawn[] pawnList,Board board) {
		super("Computer",pawnList,board);

	}

	/**
	* This method manages the next move of the IA, randomly generated.
	*/
	public void play() {
		int rdPawn = (int) (Math.random() * this.getPawnList().length);
		while (this.getPawnList()[rdPawn].getEaten() || this.getPawnList()[rdPawn].getFrozen()) {
			rdPawn = (int) (Math.random() * this.getPawnList().length);
		}
		int[] newMove = {-1, 0, 1};
		int rdPosX = (int) (this.getPawnList()[rdPawn].getPosX() + newMove[(int) Math.random() * 3]);
		int rdPosY = (int) (this.getPawnList()[rdPawn].getPosY() + newMove[(int) Math.random() * 3]);
		boolean release = false;
		while (!this.getBoard().movePawn(this.getPawnList()[rdPawn].getPosX(), this.getPawnList()[rdPawn].getPosY(), rdPosX, rdPosY, release, this)) {
			rdPosX = (int) (this.getPawnList()[rdPawn].getPosX() + newMove[(int) Math.random() * 3]);
			rdPosY = (int) (this.getPawnList()[rdPawn].getPosY() + newMove[(int) Math.random() * 3]);
		}

	}

}
