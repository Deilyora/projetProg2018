package data;
import java.util.ArrayList;
import java.io.*;

/**
 * This class represents a square on the grid.
 * It contains an ArrayList of pawn, which are the pawns on this square. The last element in the ArrayList is the pawn on top of the other.
 */
public class Square implements Serializable{
   private int posX;
   private int posY;
   private ArrayList<Pawn> pawns;

   /**
    * The constructor of Square.
    * It creates a new pawn ArrayList.
    */
   public Square(int x,int y){
		this.pawns = new ArrayList<Pawn>();
      this.posX=x;
      this.posY=y;
   }
   /**
    * Gets the ArrayList of pawns of the square.
    * @return the ArrayList of pawns.
    */
   public ArrayList<Pawn> getPawns(){
      return this.pawns;
   }
   /**
    * Gets one of the pawns of the square.
    * @return one of the pawns
    */
   public Pawn getPawn(int index){
      return this.pawns.get(index);
   }
   /**
    * Gets the size of the ArrayList of pawns of the square.
    * @return the size of the ArrayList of pawns
    */
   public int getNbPawns(){
      return this.pawns.size();
   }
   /**
    * Adds a pawn to the square's ArrayList.
    * @param newPawn the pawn to add
    */
   public void addPawn(Pawn newPawn){
      if(this.pawns.size()>0){
         this.pawns.get(this.pawns.size()-1).setEaten(true);
         newPawn.setEating(true);
      }
      this.pawns.add(newPawn);
   }
   /**
    * Removes the last pawn added(which should be the one on top of the others).
    */
   public void removePawn(){
      this.pawns.get(this.pawns.size()-1).setEating(false);
      this.pawns.remove(this.pawns.size()-1);
      this.pawns.get(this.pawns.size()-1).setEaten(false);
   }
   /**
    * Removes all the pawn on the square.
    * This happens if the pawn on top is moved without releasing the ones below.
    */
   public void removeAll(){
      this.pawns = new ArrayList<Pawn>();
   }
   /**
   * Says wheter or not the square is empty
   * @return true if it's empty, false otherwise
   */
   public boolean isEmpty(){
      boolean ret=false;
      if(this.pawns.size()==0){
         ret=true;
      }
      return ret;
   }
   /**
    * Returns the x coordinate of the square
    * @return the x coordinate
    */
   public int getX(){
      return this.posX;
   }
   /**
    * Returns the y coordinate of the square
    * @return the y coordinate
    */
   public int getY(){
      return this.posY;
   }
   /**
    * Returns the top pawn as a number
    * @return the number
    */
   public String toString() {
		String rep = null;
		Pawn greaterPawn = null;
		int nbPawns = pawns.size();
		if (!pawns.isEmpty()) {
			greaterPawn = pawns.get(nbPawns-1);
		}
		else {
			rep = " ";
		}

		if (greaterPawn != null) {
			if (greaterPawn instanceof PawnS1) {
				rep = "1";
			}
			else if (greaterPawn instanceof PawnS2) {
				rep = "2";
			}
			else if (greaterPawn instanceof PawnS3) {
				rep = "3";
			}
			else if (greaterPawn instanceof PawnS4) {
				rep = "4";
			}
		}

		return rep;
   }
}
