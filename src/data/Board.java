package data;

public class Board {
	private String player1;
	private String player2;
	private int width;
	private int height;
	private Square[][] grid;
	private Pawn[] frozenList;

	public Board(String player1, String player2, int width, int height) {
		this.player1 = player1;
		this.player2 = player2;
		this.width = witdh;
		this.height = height;
		this.grid = new Square[height][width];
		this.frozenList = new Pawn[12];
	}

	/**
	 * Move the pawn to the chosen location
	 * The method checkNextMove checks if the new postion is valid for the pawn
	 * @param posX the new X position of the pawn
	 * @param posY the new Y position of the pawn
	 * @param release indicate if the the pawn release (stop eating) another pawn
	 * @return true if the move was possible and the pawn has been moved, false otherwise.
	 */
	public boolean movePawn(int posX, int posY, boolean release) {
		return false;
	}

	/**
	 *	Checks if the new positions of the pawn are valid and if the move is possible
	 * Rules :
	 * A pawn can only move on the postions next to it
	 * A pawn cannot move if it is frozen
	 * A pawn can only eat a pawn that is onze under it
	 * A pawn cannot eat a friendly pawn
	 * A pawn can eat another pawn by releasing the pawn that it has eaten
	 * A pawn cannot move if it is eaten
	 * @param posX the new x position of the pawn
	 * @param posY the new y position of the pawn
	 * @return true if the move is possible, false otherwise.
	 */
	private boolean checkNextMove(int posX, int posY){
		boolean ret=false;
		//First we wanna check if the new position exists on the grid
		return ret;
	}

	public String getPlayer1() {
		return this.player1;
	}

	public String getPlayer2() {
		return this.player2;
	}

	public void setPlayer1(String newName) {
		this.player1 = newName;
	}

	public void setPlayer2(String newName) {
		this.player2 = newName;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.Height;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}


}
