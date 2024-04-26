/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.Random;
import java.util.ArrayList;

public class AIUserBoard extends UserBoard
{
   // Declare private members
   private ArrayList<Move> educatedMoves;
   private ArrayList<Move> moves;
   private Random rand;
   private static int difficulty;
   
   /**
   * AI helper method that takes in the difficulty
   * and returns true or false. Odds are based on 
   * the difficulty input. 1: 25% true, 2: 33% true, 3: 50% true, 4: 75% true, 5: 100% true
   * @param  difficulty integer 1-5
   * @return boolean true or false with set percent chance
   */
   private boolean chance(int difficulty)
   {
      if (difficulty == 4)
      {
         return rand.nextInt(5) != 0;
      }
      else if (difficulty == 5)
      {
         return true;
      }
      else
      {
         return rand.nextInt(5 - difficulty) == 0;
      }
   }
   
   /** 
   * Picks a move from the pool of educated guess
   * moves where ship is more likely to be than
   * random.
   * @return one of the moves from educatedMoves
   */
   public Move pickEducatedMove()
   {
      int i = rand.nextInt(educatedMoves.size());
      Move output = educatedMoves.get(i);
      educatedMoves.remove(i);
      return output;
   }
   
   /**
   * Constructor for the AIUserBoard object. Passes
   * filename to UserBoard class. Initializes members
   * @param s          filename to pass to UserBoard class
   * @param difficulty integer 1-3 giving AI better odds
   */
   public AIUserBoard(String s, int difficulty)
   {
      super(s);
      this.difficulty = difficulty;
      this.educatedMoves = new ArrayList<Move>(SIZE);
      this.rand = new Random();
      moves = new ArrayList<Move>(SIZE);
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            moves.add(new Move(i,j));
         }
      }
   }
   
   /**
   * Method that picks a random move from available moves
   * plays that move, and removes it from the list of moves
   * left.
   * @return returns move object at random from moves list
   */
   @Override
   public Move pickRandomMove()
   {
      if (moves.size() == 0){
         return pickEducatedMove();
      }
      int i = rand.nextInt(moves.size());
      Move output = moves.get(i);
      moves.remove(i);
      return output;
   }
   
   /**
   * Method that selects and makes a move AGAINST 
   * this board with AI. Returns an array of two Strings.
   * @return returns an array of strings: the move
   *         made against this board and the sunk
   *         string or null of the location hit.
   */
   @Override
   public String[] makeComputerMove()
   {
      Move moveMade;
      String[] output = new String[2];
      
      // Difficulty logic, if we educated moves to play, and the 
      // difficulty randomizer says to play it, play it.
      // Otherwise, pick a random move.
      if (educatedMoves.size() != 0 && chance(difficulty))
      {
         moveMade = pickEducatedMove();
      }
      else
      {
         moveMade = pickRandomMove();
      }
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
      else if (statusType != CellStatus.NOTHING) // Logic for AI
      {
         ArrayList<Move> temp = new ArrayList<Move>(4); 
         // Get the location of the move that just hit a boat
         int col = moveMade.col();
         int row = moveMade.row();
         
         for (Move m : moves) // Iterate through reamining moves
         {
            // Get any move that is one row above or below the hit ship
            if(m.col() == col)
            {
               if(m.row() == row + 1 || m.row() == row - 1)
               {
                  // Add these moves to educated moves
                  educatedMoves.add(m);
                  temp.add(m);
               }
            }
            // Get any move that is one col in front of or behind the hit ship
            else if(m.row() == row)
            {
               if(m.col() == col + 1 || m.col() == col - 1)
               {
                  // Add these moves to educated moves
                  educatedMoves.add(m);
                  temp.add(m);
               }
            }
         }
         // Remove these moves from moves array
         for(int i = 0; i < temp.size(); i++)
         {
            moves.remove(temp.get(i));
         }
      }
      
      output[0] = moveMade.toString();
      output[1] = sunk;
      
      return output;
   }

}