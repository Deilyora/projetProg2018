package data;
/**
 * This class represents the size 4 pawn.
 * Size 4 pawns cannot eat any size of pawns and can be eaten by size 3 pawns.
 */
public class PawnS4 extends Pawn {

	/**
	 *	The Pawn constructor : it inherits of the position on the grid, if it has eaten a pawn or if it is eating a pawn.
	 * @param posX The postion of the pawn on X
	 * @param posY The postion of the pawn on Y
	 * @param eating is true if the pawn has eaten a pawn
	 * @param eaten is true if the pawn has been eaten
	 */
	public PawnS4(int posX, int posY, boolean eating, boolean eaten, Color color) {
		super(posX,posY,eating,eaten, color);
	}
}
