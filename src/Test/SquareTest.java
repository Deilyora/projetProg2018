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
      myPawn=new PawnS1(0,0,false,false);
      myPawn2=new PawnS1(0,0,false,false);
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
      this.mySquare.addPawn(this.myPawn);
      ArrayList<Pawn>pawns=this.mySquare.getPawns();
      ArrayList<Pawn>compare=new ArrayList<Pawn>();
      compare.add(this.myPawn);
      assertTrue(pawns.equals(compare));
   }

   @Test()
   //Checks if the last pawn added is properly removed
   //It should only remove the last one added
   public void testRemovePawn(){
      this.mySquare.addPawn(this.myPawn);
      this.mySquare.addPawn(this.myPawn2);
<<<<<<< HEAD
      this.mySquare.removePawn();
=======
      this.pawns.removePawn();
>>>>>>> 9740fd62058a23cb69aa0c7f093609bc19741b45
      ArrayList<Pawn>pawns=this.mySquare.getPawns();
      ArrayList<Pawn>compare=new ArrayList<Pawn>();
      compare.add(this.myPawn);

      assertTrue(pawns.equals(compare));
   }

   @Test()
   //This should remove all the pawns.
   public void removeAll(){
      this.mySquare.addPawn(this.myPawn);
      this.mySquare.addPawn(this.myPawn2);
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
