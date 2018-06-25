 package data;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * This class is used to create or load a game
 * the user just have to choose and the game is created/loadedGame
 */
public class ChooseGame {

	/**
	 * The constructor of chooseGame just ask the user to choose between creating or loading a game.
	 * If the player choose to load a game, he's asked the name of the save
	 */
	public ChooseGame() {
		System.out.println("Do you want to create a new Game or load one ? c/l");
		Scanner sc = new Scanner(System.in);
		String rep = sc.nextLine();
		String file;
		while(!((rep.equals("c") || (rep.equals("l"))))) {
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
	 * This method creates a new game with the parameters entered by the user.
	 */
	public void initializeGame() {
		String playerName1;
		String playerName2;
		String mode;
		Mode theMode;
		int width = 8;
		int height = 7;
		int nbOfPawns = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Gamemode (Human or Automatic) ? HH/HA/AA");
		mode = sc.nextLine();
		while (!((mode.equals("HH") || mode.equals("HA") || mode.equals("AA")))) {
			System.out.println("HH/HA/AA");
			mode = sc.nextLine();
		}
		if (mode.equals("HH")) {
			theMode = Mode.HH;
		}
		else if(mode.equals("HA")) {
			theMode = Mode.HA;
		}
		else {
			theMode = Mode.AA;
		}

		System.out.println("Enter the name of player 1");
		playerName1 = sc.nextLine();
		System.out.println("Enter the name of player 2");
		playerName2 = sc.nextLine();
/*		System.out.println("width of the board ? Type 0 for default");
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
		//if the player choose default parameters, they are initialized here
		if (width == 0) {
			width = 8;
		}
		if (height == 0}
			height = 7;
		}

*/
		Game theGame = new Game(playerName1, playerName2, theMode, height, width);
		theGame.runGame();
	}

	private void loadGame(String filename) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			Game loadedGame = (Game) in.readObject();
			loadedGame.runGame();

		}
		catch (FileNotFoundException e) {
			System.out.println("Error - File not found :"+filename);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}



	}

}
