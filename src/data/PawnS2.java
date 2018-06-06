package data;
/**
 * This class represents the size 2 pawn
 * size 2 pawns can eat size 3 pawns and can be eaten by size 1 pawns
 */

public class PawnS2 extends Pawn {

	/**
	 *	The Pawn constructor : it inherits of the position on the grid, if it has eaten a pawn or if it is eating a pawn
	 * @param posX The postion of the pawn on X
	 * @param posY The postion of the pawn on Y
	 * @param eating is true if the pawn has eaten a pawn
	 * @param eaten is true if the pawn has been eaten
	 */
	public PawnS2(int posX, int posY, boolean eating, boolean eaten) {
		super(posX,posY,eating,eaten);
	}

}
