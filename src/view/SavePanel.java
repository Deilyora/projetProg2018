package view;
import javax.swing.*;
import java.awt.*;
/**
 * This class creates the SavePanel, the one that allows you to save and quit a game
 */
public class SavePanel extends JPanel{

   private JLabel save;
   private JTextField saveName;
   private JButton saved;
   private JButton back;
   /**
	 * The constructor of the panel containing all the elements to display
	 */
   public SavePanel(){
      setLayout(new GridLayout(4,1));
      save=new JLabel("Name of the save :");
      saveName=new JTextField();
      saved=new JButton("SAVE AND QUIT");
      back=new JButton("BACK");
      add(save);
      add(saveName);
      add(saved);
      add(back);
   }
   /**
   * Returns the given name of the save
   * @return the name of the save
   */
   public String getSaveName(){
      return this.saveName.getText();
   }
   /**
   * Returns the saved button
   * @return the saved button
   */
   public JButton getSavedButton(){
      return this.saved;
   }
   /**
   * Returns the back button
   * @return the back button
   */
   public JButton getBackButton(){
      return this.back;
   }
}
