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
		Pawn thePawn = null;
		int goodPawn = -1;
		Pawn[] thisPawnList = getPawnList();
		String yn = null;
		boolean releasing =false;
		System.out.println(getPlayerName()+"'s turn :");
		while (!playable) {
			while(!existing) {

				System.out.println("Enter coordinate X of the pawn you want to move");
				Scanner in = new Scanner(System.in);
				actualX = in.nextInt();
				System.out.println("Enter coordinate Y of the pawn you want to move");
				actualY = in.nextInt();
				for (int i = 0; i < thisPawnList.length; i++) {
					if (thisPawnList[i].getPosX() == actualX && thisPawnList[i].getPosY() == actualY && !thisPawnList[i].getEaten() && !thisPawnList[i].getFrozen() ) {
						existing = true;
						thePawn = thisPawnList[i];
						goodPawn = i;
						System.out.println("Now choose where you want to move your pawn");
					}
				}
				if (!existing) {
					System.out.println("Error : No valide Pawn with these coordinates, try again");
				}
			}
			System.out.println("Enter the new coordinate X of the pawn you want to move");
			Scanner in = new Scanner(System.in);
			newX = in.nextInt();
			System.out.println("Enter the new coordinate Y of the pawn you want to move");
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
			if (thisPawnList[goodPawn].movePawn(newX, newY, releasing)) {
				playable = true;
			}
			else {
				System.out.println("You cannot do that move right now, try again with new coordinates");
			}
		}
	}
}
