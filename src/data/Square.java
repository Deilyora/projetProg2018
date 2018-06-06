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
		this.pawns = new ArrayList<Pawn>();
   }
   /**
    * Gets the ArrayList of pawns of the square.
    * @return the ArrayList of pawns.
    */
   public ArrayList<Pawn> getPawns(){
      return this.pawns;
   }
   /**
    * Adds a pawn to the square's ArrayList.
    * @param newPawn the pawn to add
    */
   public void addPawn(Pawn newPawn){
      this.pawns.add(newPawn);
   }
   /**
    * Removes the last pawn added(which should be the one on top of the others).
    */
   public void removePawn(){
      this.pawns.remove(this.pawns.size()-1);
   }
   /**
    * Removes all the pawn on the square.
    * This happens if the pawn on top is moved without releasing the ones below.
    */
   public void removeAll(){
      this.pawns = new ArrayList<Pawn>();
   }
}
