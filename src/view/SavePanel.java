package view;
import javax.swing.*;
import java.awt.*;
public class SavePanel extends JPanel{

   private JLabel save;
   private JTextField saveName;
   private JButton saved;
   private JButton back;
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
   public String getSaveName(){
      return this.saveName.getText();
   }
   public JButton getSavedButton(){
      return this.saved;
   }
   public JButton getBackButton(){
      return this.back;
   }
}
