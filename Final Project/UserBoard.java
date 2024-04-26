/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.Random;
import java.util.ArrayList;

public class UserBoard extends Board
{  
   // Declare private members
   private ArrayList<Move> moves;
   private Random rand;
   
   /**
   * Constructor for the UserBoard object. Passes
   * filename to Board class. Initializes members
   * @param s filename to pass to Board class
   */
   public UserBoard(String s)
   {
      super(s);
      this.rand = new Random();
      moves = new ArrayList<Move>(SIZE);
      for(int i = 0; i < 10; i++){
         for(int j = 0; j < 10; j++){
            moves.add(new Move(i,j));
         }
      }
   }
   
   /**
   * Method that selects and makes a move AGAINST 
   * this board. Returns an array of two Strings.
   * @return returns an array of strings: the move
   *         made against this board and the sunk
   *         string or null of the location hit.
   */
   public String[] makeComputerMove()
   {
      String[] output = new String[2];
      Move moveMade = pickRandomMove();
      CellStatus statusType = applyMoveToLayout(moveMade);
      
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
         sunk = "Computer sunk my " + shipString;
      }
      
      output[0] = moveMade.toString();
      output[1] = sunk;
      
      return output;
   }
   
   /**
   * Method that picks a random move from available moves
   * plays that move, and removes it from the list of moves
   * left.
   * @return returns move object at random from moves list
   */
   public Move pickRandomMove()
   {
      int i = rand.nextInt(moves.size());
      Move output = moves.get(i);
      moves.remove(i);
      return output;
   }
   
   /**
   * Returns a String representation of the UserBoard, displaying the second
   * character of the String returned by the toString method overridden in CellStatus
   * @return string representation of this Board
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
            output = output + String.format(" %s ", getLayout().get(i).get(j).toString().substring(1,2));
         }
         output = output + "\n";  
      }
      return output;
   }
}