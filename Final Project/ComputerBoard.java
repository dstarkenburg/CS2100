/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.Random;
import java.util.ArrayList;

public class ComputerBoard extends Board
{
   public ComputerBoard(String s)
   {
      super(s);
   }
   
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
         sunk = "You sunk my " + shipString;
      }
      
      return sunk;
   }
   
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