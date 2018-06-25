package view;
import javax.swing.*;

/**
* This class represents a button on the board.
* It adds x and y coordinates to a button so we can know it's position on the board.
*/
public class GridButton extends JButton{

   public int x;
   public int y;

   public GridButton(ImageIcon image,int x,int y){
      super(image);
      this.x=x;
      this.y=y;
   }
}
