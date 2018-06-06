import org.junit.*;
import static org.junit.Assert.*;
import data.*;
public class PlayerTest{
   private AIPlayer ai;
   private HumanPlayer human;
   private PawnS1 pawnAI;
   private PawnS1 pawnHuman;
   private Pawn[] pawnsAI;
   private Pawn[] pawnsHuman;

   @Before()
   protected void setUp(){
      pawnAI=new PawnS1(0,0,false,false);
      pawnsAI=new Pawn[1];
      pawnsAI[0]=pawnAI;
      ai=new AIPlayer(pawnsAI);

      pawnHuman=new PawnS1(1,1,false,false);
      pawnsHuman=new Pawn[1];
      pawnsHuman[0]=pawnHuman;
      human=new HumanPlayer("Allan",pawnsHuman);
   }
   @Test()
   // Here we want to check if a pawn has correctly been moved.
   // We only create one pawn for simplicity
   public void testAIPlay(){
      int oldPosX=ai.getPawnList()[0].getPosX();
      int oldPosY=ai.getPawnList()[0].getPosY();
      ai.play();
      int newPosX=ai.getPawnList()[0].getPosX();
      int newPosY=ai.getPawnList()[0].getPosY();
      assertTrue(oldPosX!=newPosX && oldPosY!=newPosY);
   }
   @Test()
   // Here we want to check if a pawn has correctly been moved.
   // We only create one pawn for simplicity
   public void testHumanPlayer(){
      int oldPosX=human.getPawnList()[0].getPosX();
      int oldPosY=human.getPawnList()[0].getPosY();
      human.play();
      int newPosX=human.getPawnList()[0].getPosX();
      int newPosY=human.getPawnList()[0].getPosY();
      assertTrue(oldPosX!=newPosX && oldPosY!=newPosY);
   }
   @After()
   protected void tearDown(){
      pawnAI=null;
      pawnsAI=null;
      ai=null;

      pawnHuman=null;
      pawnsHuman=null;
      human=null;
   }

}
