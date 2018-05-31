package data;
import java.util.ArrayList;
/**
 * This class represents a square on the grid.
 * It contains an ArrayList of pawn, which are the pawns on this square.
 */
public class Square{
   private ArrayList<Pawn> pawns;

   /**
    * The constructor of Square.
    * It creates a new pawn ArrayList.
    */
   public Square(){
		ArrayList<Pawn> = new ArrayList<Pawn>();
   }
   /**
    * Gets the ArrayList of pawns of the square.
    * @return the ArrayList of pawns.
    */
   public ArrayList<Pawn> getPawns(){
      return this.pawns;
   }
}
