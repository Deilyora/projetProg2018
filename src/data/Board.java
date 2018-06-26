package data;
import java.util.ArrayList;
import java.io.*;
import view.*;
/**
* This class represents the game board.
* It represent the game with a 2D array of squares.
* It contains a method to move a pawn around the board.
*/
public class Board implements Serializable  {
	private int width;
	private int height;
	private Square[][] grid;
	private ArrayList<Square> frozenList;
	public static final String ANSI_RESET = "\033[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";

	public Board(int width, int height,Square[][] grid) {
		this.width = width;
		this.height = height;
		this.grid = grid;
		this.frozenList = new ArrayList<Square>();
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
	public boolean movePawn(int oldX,int oldY,int newX, int newY, boolean release,Player thePlayer) {
		boolean moved=false;
		//First we wanna check if the move is valid
		boolean valid=checkNextMove(oldX,oldY,newX,newY,release,thePlayer);
		//if the move is valid, we start moving it
		if(valid){
			//if the pawn to move releases the other one beneath it we only move the pawn on top
			if(release){
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
			//Checks whether or not the pawn arrived on the last row and should be frozen
			if(this.toFreeze(newX,newY,thePlayer)){
				this.frozenList.add(this.grid[newX][newY]);
				ArrayList<Pawn>toSet=this.grid[newX][newY].getPawns();
				for(Pawn p : toSet){
					p.setFrozen(true);
				}
			}
			moved=true;
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
	//TODO : set pawns to eaten and eating when needed
	private boolean checkNextMove(int oldX,int oldY,int newX, int newY, boolean release,Player thePlayer){
		boolean ret=false;
		//First we wanna check if the pawn on top belongs to the player
		if(this.isMine(oldX,oldY,thePlayer)){
			//Then we wanna check if the pawn isn't frozen
			if(!(this.isFrozen(oldX,oldY))){
				//We wanna check if the new position exists on the grid
				if(newX>=0 && newX<height && newY>=0 && newY<width){
					//We wanna check if the new position is right next to the the current one
					if(this.isNextTo(oldX,oldY,newX,newY)){
						//We wanna check if there is a pawn on the new square
						if(this.grid[newX][newY].getPawns().size()!=0){
							//We wanna check if we are relasing the pawns or if there isn't any pawns beneath.
							//If not, the move can't be done
							if(release || !(this.grid[oldX][oldY].getPawn((this.grid[oldX][oldY].getNbPawns())-1).getEating())){
								//We wanna check if the new pawn is eatable
								if(this.isEatable(oldX,oldY,newX,newY,thePlayer)){
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
		}
		return ret;
	}
	/**
	* Checks whether or not a pawn with given coordinates is frozen.
	* @param x the x coordinate
	* @param y the y coordinate
	* @return true if it's frozen, false otherwise
	*/
	private boolean isFrozen(int x,int y){
		boolean ret=false;
		int i=0;
		for(Square s : this.frozenList){
			if(s.getX()==x && s.getY()==y){
				ret=true;
			}
		}
		return ret;
	}
	/**
	* Checks wether or not the pawn on top of the square with given
	* coordinates belongs to the current player.
	* @param x the x coordinate
	* @param y the y coordinate
	* @return true if it belongs to the player, false otherwise
	*/
	private boolean isMine(int x,int y,Player thePlayer){
		boolean ret=false;
		ArrayList<Pawn> pawn=thePlayer.getPawnList();
		Pawn onTop=this.grid[x][y].getPawn((this.grid[x][y].getNbPawns())-1);
		for(Pawn p : pawn){
			if(p.equals(onTop)){
				ret=true;
			}
		}
		return ret;
	}
	/**
	* Checks whether or not the new coordinates are right next to the old one.
	* @param oldX the current X position of the pawn
	* @param oldY the current Y position of the pawn
	* @param newX the new X position of the pawn
	* @param posY the new Y position of the pawn
	* @return true if they're right next to one another, false otherwise
	*/
	private boolean isNextTo(int oldX,int oldY,int newX, int newY){
		boolean ret=false;
		if(newX==oldX+1 || newX==oldX-1 || newX==oldX){
			if(newY==oldY+1 || newY==oldY-1 || newY==oldY){
				ret=true;
			}
		}
		return ret;
	}
	/**
	* Checks whether or not pawn A can eat pawn B.
	* We assume pawn A belongs to player A.
	* @param aX X coordinate of pawn A
	* @param aY Y coordinate of pawn A
	* @param bX X coordinate of pawn B
	* @param bY Y coordinate of pawn B
	*/
	private boolean isEatable(int aX,int aY,int bX, int bY,Player playerA){
		boolean ret=false;
		boolean bBelongsToA=false;
		Pawn a=this.grid[aX][aY].getPawn((this.grid[aX][aY].getNbPawns())-1);
		Pawn b=this.grid[bX][bY].getPawn((this.grid[bX][bY].getNbPawns())-1);
		ArrayList<Pawn> pawnList=playerA.getPawnList();
		for(Pawn p : pawnList){
			if(p.getPosX()==bX && p.getPosY()==bY){
				bBelongsToA=true;
			}
		}
		if(!bBelongsToA){
			if(!b.getFrozen()){
				if(a instanceof PawnS1 && b instanceof PawnS2){
					ret=true;
				}
				if(a instanceof PawnS2 && b instanceof PawnS3){
					ret=true;
				}
				if(a instanceof PawnS3 && b instanceof PawnS4){
					ret=true;
				}
			}

		}
		return ret;
	}
	/**
	* This method checks whether or not the pawn with given coordinates should be frozen
	* @param x the X coordinate
	* @param y the Y coordinate
	* @param player the player
	* @return true if it should be frozen,false otherwise
	*/
	private boolean toFreeze(int x,int y,Player player){
		boolean ret=false;
		if(player.getTop()){
			for(int j=0;j<this.width;j++){
				if(x==this.height-1 && y==j){
					ret=true;
				}
			}
		}
		else{
			for(int j=0;j<this.width;j++){
				if(x==0 && y==j){
					ret=true;
				}
			}
		}
		return ret;
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
	public int getPoints(Color color){
		int ret=0;
		for(Square s : this.frozenList){
			Pawn p=s.getPawn((s.getNbPawns())-1);
			if(p.getColor()==color){
				if (p instanceof PawnS1) {
					ret+=1;
				}
				else if (p instanceof PawnS2) {
					ret+=2;
				}
				else if (p instanceof PawnS3) {
					ret+=3;
				}
				else if (p instanceof PawnS4) {
					ret+=4;
				}
			}
		}
		return ret;
	}


	/**
	* Display the board with the pawns, columns, score, and players differenciated by colors
	* @return The String with the display
	*/
	public String toString() {
		//i = vertical j = horizontal
		String rep = "";
		for (int i = 0; i < this.height ; i++) {
			for (int j = 0; j < this.width; j++) {
				if(!(this.grid[i][j].isEmpty())){
					Pawn p=this.grid[i][j].getPawn((this.grid[i][j].getNbPawns())-1);
					if(p.getColor()==Color.RED){
						rep = rep + "|"+ ANSI_RED+grid[i][j]+ANSI_RESET;
					}
					else{
						rep = rep + "|"+ ANSI_GREEN+grid[i][j]+ANSI_RESET;
					}
				}
				else{
					rep = rep + "| ";
				}
			}
			rep = rep + "|\n";
		}
		return rep;
	}

	/**
	* This method returns the board's grid
	* @return the board's grid
	*/
	public Square[][] getGrid(){
		return this.grid;
	}


}
