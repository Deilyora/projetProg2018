package data;

import java.util.Scanner;

public class ChooseGame {
	
	Game theGame;
	
	public ChooseGame() {
		System.out.println("Do you want to create a new Game or load one ? c/l");
		Scanner sc = new Scanner(System.in);
		String rep = sc.nextLine();
		String file;
		while(!((rep.equals("c") || (rep.equals("l"))) {
			System.out.println("Create or load ? c/l");
			rep = sc.nextLine();
		}
		
		if (rep.equals("c")) {
			initializeGame();
		}
		else {
			System.out.println("enter the name of the save");
			file = sc.nextLine();
			loadGame("../save/"+file);
		}
	}
	
	/**
	 * This method creates a new game.
	 */
	public void initializeGame() {
		String player1;
		String player2;
		int width = -1;
		int height = -1;
		int nbOfPawns = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of player 1");
		player1 = sc.nextLine();
		System.out.println("Enter the name of player 2");
		player2 = sc.nextLine();		
		System.out.println("width of the board ? Type 0 for default");
		while (!(width > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a valid number");
				sc.next();
			}
			width = sc.nextInt();
		}
		System.out.println("height of the board ? Type 0 for default");
		while (!(height > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a valid number");
				sc.next();
			}
			height = sc.nextInt();
		}
		System.out.println("Number of pawns par player ? Type 0 for default");
		
		while(!(nbOfPawns > 0)) {
			System.out.println("You need enter a positive number");
			while (!sc.hasNextInt()) {
				System.out.println("Enter a vaild number");
				sc.next();
			}
			nbOfPawns = sc.nextInt();
		}
		this.width = width;
		this.height = height;
		this.player1 = player1;
		this.player2 = player2;
		this.nbOfPawns = nbOfPawns;
		Board theBoard = new Board(this.width, this.height);
		this.board = theBoard;
	}
	
	private void loadGame(String filename) {
		
	}
	
}