package data;
import java.util.Scanner;
 /* This class is used to represent a human player.
 * Human players choose their own name.
 */
public class HumanPlayer extends Player {

	/**
	 * This is the constructor of the class, it defines the name of the player
	 * @param name the name chosen by the human player
	 * @param pawnList the pawns of the player
	 */
	public HumanPlayer(String name,Pawn[] pawnList) {
		super(name, pawnList);
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
		int actualX;
		int actualY;
		int thePawn;
		System.out.println(this.playerName+"'s turn :");
		while (!playable) {
			while(!valid) {

				System.out.println("Enter coordinate X of the pawn you want to move");
				Scanner in = new Scanner(System.in);
				actualX = in.NextInt();
				System.out.println("Enter coordinate Y of the pawn you want to move");
				actualY = in.NextInt();
				for (int i = 0; i < this.pawnList.length; i++) {
					if (this.pawnList[i].getPosX() == actualX && this.pawnList[i].getPosY() == actualY && !this.pawnList[i].getEaten() && !this.pawnList[i].getFrozen() ) {
						existing = true;
					}
				}
				if (!existing) {
					System.out.println("Error : No valide Pawn with these coordinates, try again");
				}
			}
			if  (!this.pawnList[i].getEaten() && !this.pawnList[i].getFrozen() 
			
						
						
			
		
		
	}
}
