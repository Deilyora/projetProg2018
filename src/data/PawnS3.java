package data;
/**
 * This class represents the size 3 pawn.
 * Size 3 pawns can eat size 4 pawns and can be eaten by size 2 pawns.
 */
public class PawnS3 extends Pawn {

	/**
	 *	The Pawn constructor : it inherits of the position on the grid, if it has eaten a pawn or if it is eating a pawn.
	 * @param posX The postion of the pawn on X
	 * @param posY The postion of the pawn on Y
	 * @param eating is true if the pawn has eaten a pawn
	 * @param eaten is true if the pawn has been eaten
	 */
	public PawnS3(int posX, int posY, boolean eating, boolean eaten, Color color) {
      super(posX,posY,eating,eaten,color);
	}
}
