import org.junit.*;
import static org.junit.Assert.*;
import data.*;
import java.util.ArrayList;
public class SquareTest{

   private Square mySquare;
   private Pawn myPawn;
   private Pawn myPawn2;

   @Before()
   protected void setUp(){
      mySquare=new Square();
      myPawn=new Pawn(0,0,false,false);
      myPawn2=new Pawn(0,0,false,false);
   }
   @Test()
   //Checks if the ArrayList is properly initialized
   public void testPawns(){
      ArrayList<Pawn> pawns=this.mySquare.getPawns();
      assertFalse(pawns==null);
   }

   @Test()
   //Checks if a pawn is properly added to the ArrayList
   public void testAddPawn(){
      this.mySquare.add(this.myPawn);
      ArrayList<Pawn>pawns=this.mySquare.getPawns();
      ArrayList<Pawn>compare=new ArrayList<Pawn>();
      compare.add(this.mySquare);
      assertTrue(pawns.equals(compare));
   }

   @Test()
   //Checks if the last pawn added is properly removed
   //It should only remove the last one added
   public void testRemovePawn(){
      this.mySquare.add(this.myPawn);
      this.mySquare.add(this.myPawn2);
      ArrayList<Pawn>pawns=this.mySquare.getPawns();
      ArrayList<Pawn>compare=new ArrayList<Pawn>();
      compare.add(this.mySquare);
      this.pawns.removePawn();
      assertTrue(pawns.equals(compare));
   }

   @Test()
   //This should remove all the pawns.
   public void removeAll(){
      this.mySquare.add(this.myPawn);
      this.mySquare.add(this.myPawn2);
      ArrayList<Pawn>pawns=this.mySquare.getPawns();
      ArrayList<Pawn>compare=new ArrayList<Pawn>();
      assertTrue(pawns.equals(compare));
   }


   @After()
   protected void tearDown(){
      mySquare=null;
      myPawn=null;
      myPawn2=null;
   }

}
