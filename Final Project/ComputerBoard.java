/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.Random;
import java.util.ArrayList;

public class ComputerBoard extends Board
{
   /**
   * ComputerBoard constructor that passes filename
   * to the Board constructor.
   * @param s filename to pass on
   */
   public ComputerBoard(String s)
   {
      super(s);
   }
   
   /**
   * Takes a move and makes it AGAINST this board. Takes in move to be applied.
   * Returns either null, or, if the move sank a ship, a String.
   * @param m move to make against this board
   * @return  returns null unless a ship is sunk, then returns sunk string
   */
   public String makePlayerMove(Move m)
   {
      String output;
      CellStatus statusType = applyMoveToLayout(m);
      
      String sunk = null;
      
      String shipString = switch(statusType)
      {
         case SUB_SUNK -> "Sub";
         case BATTLESHIP_SUNK -> "Battleship";
         case AIRCRAFT_CARRIER_SUNK -> "Aircraft Carrier";
         case CRUISER_SUNK -> "Cruiser";
         case DESTROYER_SUNK -> "Destroyer";
         default -> null;
      };
      
      if (shipString != null)
      {
         sunk = "You sunk computer's " + shipString;
      }
      
      return sunk;
   }
   
   /**
   * Returns a String representation of the ComputerBoard, displaying the first character
   * of the String returned by the toString method overridden in CellStatus
   * @return returns this object in string form
   */
   @Override
   public String toString()
   {
      String output;
      String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
      output = "    1  2  3  4  5  6  7  8  9  10 \n";
      for(int i = 0; i < 10; i++)
      {
         output = output + String.format(" %s ", letters[i]);
         for(int j = 0; j < 10; j++)
         {
            output = output + String.format(" %s ", getLayout().get(i).get(j).toString().substring(0,1));
         }
         output = output + "\n";  
      }
      return output;
   }
}