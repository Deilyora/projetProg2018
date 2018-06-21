package data;
import java.util.*;
/* This class is used to represent a human player.
* Human players choose their own name.
*/
public class HumanPlayer extends Player implements Serializable  {

	/**
	* This is the constructor of the class, it defines the name of the player
	* @param name the name chosen by the human player
	* @param pawnList the pawns of the player
	* @param board the board
	* @param top if the player is on top of the grid or not
	* @param color the color of the player
	*/
	public HumanPlayer(String name,ArrayList<Pawn> pawnList,Board board,boolean top, Color color) {
		super(name, pawnList,board,top,color);
	}


	/**
	* This method manages the next move of the human player
	* It asks the player wich pawn he wants to move, and where he wants to move it.
	*/
	public void play() {
		boolean playable = false;
		boolean existing = false;
		int newX;
		int newY;
		int currentX=-1;
		int currentY=-1;
		Pawn thePawn = null;
		int goodPawn = -1;
		ArrayList<Pawn> thisPawnList = getPawnList();
		String yn = "";
		boolean releasing =false;
		Scanner in = new Scanner(System.in);
		System.out.println(getPlayerName()+"'s turn :");
		while (!playable) {
			while(!existing) {

				System.out.println("Enter coordinate X of the pawn you want to move");
				while (!in.hasNextInt()) {
					System.out.println("Enter a valid number");
					in.next();
				}			
				currentX = in.nextInt();
				System.out.println("Enter coordinate Y of the pawn you want to move");
				while (!in.hasNextInt()) {
					System.out.println("Enter a valid number");
					in.next();
				}	
				currentY = in.nextInt();
				for (Pawn p : thisPawnList) {
					if (p.getPosX() == currentX && p.getPosY() == currentY && !p.getEaten() && !p.getFrozen() ) {
						existing = true;
						thePawn = p;
						System.out.println("Now choose where you want to move your pawn");
					}
				}
				if (!existing) {
					System.out.println("Error : No valid Pawn with these coordinates, try again");
				}
			}
			System.out.println("Enter the coordinate X of the square you want to move that pawn to");
			while (!in.hasNextInt()) {
				System.out.println("Enter a valid number");
				in.next();
			}	
			newX = in.nextInt();
			System.out.println("Enter the coordinate Y of the square you want to move that pawn to");
			while (!in.hasNextInt()) {
				System.out.println("Enter a valid number");
				in.next();
			}	
			newY = in.nextInt();
			if (thePawn.getEating()) {
				while (!yn.equals("y") && !yn.equals("n")) {
					System.out.println("Do you want to release the pawn under it ? y/n");
					yn = in.nextLine();
				}
				if (yn.equals("y")) {
					releasing = true;
				}
				else {
					releasing = false;
				}
			}
			if (this.getBoard().movePawn(currentX, currentY, newX, newY, releasing, this) && (newX != currentX || newY != currentY) ) {
				playable = true;
			}
			else {
				System.out.println("You cannot do that move right now, try again with new coordinates");
			}
		}
	}
}
