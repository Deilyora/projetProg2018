package data;

/**
 * This class represents the game board.
 * It represent the game with a 2D array of squares.
 * It contains a method to move a pawn around the board.
 */
public class Board {
	private int width;
	private int height;
	private Square[][] grid;
	private Pawn[] frozenList;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new Square[height][width];
		this.frozenList = new Pawn[12];
	}

	/**
	 * Move the pawn to the chosen location.
	 * The method checkNextMove checks if the new postion is valid for the pawn.
	 * It freezes the pawn if it arrives on the last row.
	 * @param posX the new X position of the pawn
	 * @param posY the new Y position of the pawn
	 * @param release indicate if the the pawn release (stop eating) another pawn
	 * @return true if the move was possible and the pawn has been moved, false otherwise.
	 */
	public boolean movePawn(int posX, int posY, boolean release) {
		return false;
	}

	/**
	 *	Checks if the new positions of the pawn are valid and if the move is possible.
	 * Rules :
	 * A pawn can only move on the postions next to it
	 * A pawn cannot move if it is frozen
	 * A pawn can only eat a pawn that is under it
	 * A pawn cannot eat a friendly pawn
	 * A pawn can eat another pawn by releasing the pawn that it has eaten
	 * A pawn cannot move if it is eaten
	 * @param posX the new x position of the pawn
	 * @param posY the new y position of the pawn
	 * @return true if the move is possible, false otherwise.
	 */
	 //TODO : add the player who's moving the pawn
	private boolean checkNextMove(int posX, int posY){
		boolean ret=false;
		//First we wanna check if the new position exists on the grid
		return ret;
	}

	/**
	 * Returns player1
	 * @return player1
	 */
	public String getPlayer1() {
		return this.player1;
	}

	/**
	 * Returns player2
	 * @return player2
	 */
	public String getPlayer2() {
		return this.player2;
	}

	/**
	 * Returns the board width
	 * @return the board width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns the board height
	 * @return the board height
	 */
	public int getHeight() {
		return this.Height;
	}
}
