import org.junit.*;
import static org.junit.Assert.*;
import data.*;
public class PawnTest{
   private PawnS1 p1;

   @Before()
   protected void setUp(){
      p1=new PawnS1(0,0,false,false);
   }
   @Test()
   //This test checks if the pawn has moved to the correct location
   public void testMovePawn(){
      int expectedPosX=1;
      int expectedPosY=1;
      boolean bool=p1.movePawn(1,1,false);
      assertTrue(bool==true);
      assertTrue(p1.getPosX()==expectedPosX && p1.getPosY()==expectedPosY);
   }
   @After
   protected void tearDown(){
      p1=null;
   }
}
