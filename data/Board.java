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
	
	private boolean movePawn(int posX, int posY) {
		
	}
	
	private boolean checkNextMove(int posX, int posY) {
		
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