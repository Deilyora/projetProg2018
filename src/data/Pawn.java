package data;

/**
 * This class represents a pawn of the game.
 * There are 4 types of pawn.
 * Each pawn can be moved, and can be either eating or eaten another one.
 * An eaten pawn cannot be moved directly and follow all the moves of the pawn that has eaten it
 */
public abstract class Pawn {

	private int posX;
	private int posY;
	private boolean eating;
	private boolean eaten;
	private boolean frozen;
	private int points;

	/**
	 *	The Pawn constructor : it inherits of the position on the grid, if it has eaten a pawn or if it is eating a pawn
	 * @param posX The position of the pawn on X
	 * @param posY The position of the pawn on Y
	 * @param eating is true if the pawn has eaten a pawn
	 * @param eaten is true if the pawn has been eaten
	 */
	public Pawn(int posX, int posY, boolean eating, boolean eaten) {
		this.posX = posX;
		this.posY = posY;
		this.eating = eating;
		this.eaten = eaten;
		
	}

	/**
	 * Get the position on X of the pawn
	 * @return the postion X
	 */
	public int getPosX() {
		return this.posX;
	}

	/**
	 *	Changes the position of the pawn on the grid
	 * @param posX the new position of the pawn on X
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * Get the position on Y of the pawn
	 * @return the position Y
	 */
	public int getPosY() {
		return this.posY;
	}

	/**
	 *	Changes the position of the pawn on the grid
	 * @param posY the new position of the pawn on Y
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Check if the pawn has eaten a pawn
	 * @return true if the pawn is eating another pawn
	 */
	public boolean getEating() {
		return this.eating;
	}

	/**
	 * Changes the pawn state to eating or not eating
	 * @param eating the new the state of the pawn
	 */
	public void setEating(boolean eating) {
		this.eating = eating;
	}


	/**
	 * Check if the the pawn is eaten or not
	 * @return true if the pawn if being eaten
	 */
	public boolean getEaten() {
		return this.eaten;
	}

	/**
	 * Sets a boolean to symbolize wether a pawn has been eaten or not.
	 * An eaten pawn cannot do anything, and has to wait for the pawn on top of it to release it.
	 * @param eaten a boolean that symbolizes wether a pawn has been eaten or has been released.
	 */
	public void setEaten(boolean eaten) {
		this.eaten = eaten;
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

	/**
	 * Changes the frozen state of the pawn : true if the pawn is frozen
	 * @param frozen the new state of the pawn
	 */
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	/**
	 * Gets if the pawn is frozen or not 
	 * @return true if it is frozen
	 */
	public boolean getFrozen() {
		return this.frozen;
	}

}
