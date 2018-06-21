package data;
import java.io.*;

/**
 * This class represents the size 1 pawn.
 * A size 1 pawn cannot be eaten and can only eat size 2 pawns.
 */
public class PawnS1 extends Pawn implements Serializable  {

	/**
	 *	The Pawn constructor : it inherits of the position on the grid, if it has eaten a pawn or if it is eating a pawn.
	 * @param posX The postion of the pawn on X
	 * @param posY The postion of the pawn on Y
	 * @param eating is true if the pawn has eaten a pawn
	 * @param eaten is true if the pawn has been eaten
	 */

	public PawnS1(int posX, int posY, boolean eating, boolean eaten, Color color) {
		super(posX,posY,eating,eaten,color);
	}
}
