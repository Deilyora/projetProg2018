package view;
import javax.swing.*;

/**
* This class represents a button on the board.
* It adds x and y coordinates to a button so we can know it's position on the board.
*/
public class GridButton extends JButton{

   public int x;
   public int y;

	/**
	 * The constructor of GridButton : it's like a normal button but with coordinates in the constructor to identify the button on the grid
	 * @param image the image on the button
	 * @param x the coordinate x of the button
	 * @param y the coordinate y of the button
	 */
   public GridButton(ImageIcon image,int x,int y){
      super(image);
      this.x=x;
      this.y=y;
   }
}
