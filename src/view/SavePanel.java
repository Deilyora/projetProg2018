package view;
import javax.swing.*;
import java.awt.*;
public class SavePanel extends JPanel{

   private JLabel save;
   private JTextField saveName;
   private JButton saved;

   public SavePanel(){
      setLayout(new GridLayout(3,1));
      save=new JLabel("Name of the save :");
      saveName=new JTextField();
      saved=new JButton("save");
      add(save);
      add(saveName);
      add(saved);
   }
   public String getSaveName(){
      return this.saveName.getText();
   }
   public JButton getSavedButton(){
      return this.saved;
   }
}
