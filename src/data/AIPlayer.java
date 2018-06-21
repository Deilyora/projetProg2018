package data;
import java.util.*;
/**
* This class represents an automated player.
* Automated players have a defined name.
*/
public class AIPlayer extends Player {

	/**
	* The constructor of AIPlayer. The name of the player is directly written in the class.
	* @param pawnList the pawns of the player
	* @param board the board
	* @param top if the player is on top of the grid or not
	* @param color the color of the player
	*/
	public AIPlayer(String name, ArrayList<Pawn> pawnList,Board board,boolean top,Color color) {
		super(name,pawnList,board,top,color);

	}

	/**
	* This method manages the next move of the IA, randomly generated.
	*/
	public void play() {
		int rdPawn = (int) (Math.random() * this.getPawnList().size());
		while (this.getPawnList().get(rdPawn).getEaten() || this.getPawnList().get(rdPawn).getFrozen()) {
			rdPawn = (int) (Math.random() * this.getPawnList().size());
		}
		int[] newMove = {-1, 0, 1};
		int rdPosX = (int) (this.getPawnList().get(rdPawn).getPosX() + newMove[(int) (Math.random() * 3)]);
		int rdPosY = (int) (this.getPawnList().get(rdPawn).getPosY() + newMove[(int) (Math.random() * 3)]);
		boolean release = false;
		while (!this.getBoard().movePawn(this.getPawnList().get(rdPawn).getPosX(), this.getPawnList().get(rdPawn).getPosY(), rdPosX, rdPosY, release, this)) {
			rdPosX = (int) (this.getPawnList().get(rdPawn).getPosX() + newMove[(int) (Math.random() * 3)]);
			rdPosY = (int) (this.getPawnList().get(rdPawn).getPosY() + newMove[(int) (Math.random() * 3)]);
		}


	}

}
