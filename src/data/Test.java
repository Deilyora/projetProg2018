package data;
public class Test {


	public static void main(String args[]) {
		Board board = new Board(7,8);
		Player b = 
		
		
		Square a = new Square(0,0);
		for (int i = 0; i < 7 ; i++) {
			for (int j = 0; j < 8; j++) {
				board.grid[i][j] = a;
			}
			
		}
		System.out.println(board);
	}
	
}