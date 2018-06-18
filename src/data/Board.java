package data;
import java.util.ArrayList;
/**
* This class represents the game board.
* It represent the game with a 2D array of squares.
* It contains a method to move a pawn around the board.
*/
public class Board {
	private int width;
	private int height;
	private Square[][] grid;
	private Square[] frozenList;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new Square[height][width];
		this.frozenList = new Square[12];
	}

	/**
	* Move the pawn to the chosen location.
	* The method checkNextMove checks if the new postion is valid for the pawn.
	* It freezes the pawn if it arrives on the last row.
	* @param oldX the current X position of the pawn
	* @param oldY the current Y position of the pawn
	* @param newX the new X position of the pawn
	* @param posY the new Y position of the pawn
	* @param release indicate if the the pawn release (stop eating) another pawn
	* @param thePlayer the player who's moving the pawn
	* @return true if the move was possible and the pawn has been moved, false otherwise.
	*/
	//TODO: Freeze the pawn if it arrives on the last row
	public boolean movePawn(int oldX,int oldY,int newX, int newY, boolean release,Player thePlayer) {
		boolean moved=false;
		//First we wanna check if the move is valid
		boolean valid=checkNextMove(oldX,oldY,newX,newY,release,thePlayer);
		//if the move is valid, we start moving it
		if(valid){
			//if the pawn to move releases the other one beneath it we only move the pawn on top
			if(!release){
				Pawn toSwap=this.grid[oldX][oldY].getPawn((this.grid[oldX][oldY].getNbPawns())-1);
				this.grid[oldX][oldY].removePawn();
				toSwap.setPosX(newX);
				toSwap.setPosY(newY);
				this.grid[newX][newY].addPawn(toSwap);
			}
			//otherwise, we move all the pawns beneath
			else{
				ArrayList<Pawn> pawnsToSwap=this.grid[oldX][oldY].getPawns();
				this.grid[oldX][oldY].removeAll();
				for(Pawn p : pawnsToSwap){
					p.setPosX(newX);
					p.setPosY(newY);
					this.grid[newX][newY].addPawn(p);
				}
			}
		}
		//if the move is not valid, we dont do anything and simply return false,
		//stating that the move hasn't been done
		return moved;
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
	* @param oldX the current X position of the pawn
	* @param oldY the current Y position of the pawn
	* @param newX the new X position of the pawn
	* @param posY the new Y position of the pawn
	* @param release indicate if the the pawn release (stop eating) another pawn
	* @param thePlayer the player who's moving the pawn
	* @return true if the move is possible, false otherwise.
	*/
	private boolean checkNextMove(int oldX,int oldY,int newX, int newY, boolean release,Player thePlayer){
		boolean ret=false;
		//First we wanna check if the pawn is'nt frozen or eaten
		if(){
			//Then we wanna check if the new position exists on the grid
			if(newX>=0 && newX<height && newY>=0 && newY<width){
				//We wanna check if the new position is right next to the the current one
				if(){
					//We wanna check if there is a pawn on the new square
					if(){
						//We wanna check if we are relasing the pawns.
						//If not, the move can't be done
						if(){
							//We wanna check if the new pawn is eatable
							if(){
								ret=true;
							}
						}
					}
					//if there isn't we can move it
					else{
						ret=true;
					}
				}
			}

		}
		return ret;
	}
	/**
	 * Checks whether or not a pawn with given cooa
	 */
	private boolean isFrozen(int x,int x){

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
		return this.height;
	}
	/**
	*/
}
