/**
Duncan Starkenburg
CS2100, Week 4 HW [Coin Object]
This class constructs the coin object
*/
import java.util.Random;

public class Coin
{
   // Declare private variables
   private boolean heads;
   private int value;
   
   // Create a global random number generator
   private Random generator = new Random();
   
   // Constructor
   public Coin(int userVal)
   {
      value = userVal;
      heads = generator.nextInt(2) == 0 ? true : false;
   }
   
   /**
   * The toss method is a mutator function that randomly
   * assigns a Coin object's heads value to true or false
   * and returns nothing.
   */
   public void toss()
   {
      heads = generator.nextInt(2) == 0 ? true : false;
   }
   
   /**
   * The isHeads() method is a accessor function that 
   * returns the value of the Coin object's head variable
   * @return The value of the heads boolean.
   */
   public boolean isHeads()
   {
      return heads;
   }
   
   /**
   * The getValue() method is a accessor function that 
   * returns the value of the Coin object's value variable
   * @return The value of the value int.
   */
   public int getValue()
   {
      return value;
   }

}