/**
Duncan Starkenburg
CS 2100, Final Project
*/

public class Game
{
   //Declare private board members
   private ComputerBoard computer;
   private UserBoard player;
   
   /**
   * Constructor of Game that takes in difficulty setting
   * and runs the game.
   * @param difficulty integer value 0-5 to represent
   *                   difficulty of AI. 0 is off.
   */
   public Game(int difficulty)
   {
      if (difficulty != 0)
      {   
         this.player = switch(difficulty)
         {
            case 1 -> new AIUserBoard("userFleet.txt", 1);
            case 2 -> new AIUserBoard("userFleet.txt", 2);
            case 3 -> new AIUserBoard("userFleet.txt", 3);
            case 4 -> new AIUserBoard("userFleet.txt", 4);
            case 5 -> new AIUserBoard("userFleet.txt", 5);
            default -> null;
         };
         if (this.player == null)
         {
            System.out.println("Invalid difficulty entered.");
            System.exit(0);
         }
      }
      else
      {
         this.player = new UserBoard("userFleet.txt");
      }
      this.computer = new ComputerBoard("compFleet.txt");  
   }
   
   /**
   * Calls a method on the player board which makes a move against that board.
   * @return returns an array of two Strings: computer's move and sunk or null string.
   */
   public String[] makeComputerMove()
   {
      return player.makeComputerMove();
   }
   
   /**
   * Calls a method on the computer board which makes a move against that board.
   * @return returns either null or the sunk string of the ship hit.
   */
   public String makePlayerMove(String s)
   {
      Move move = new Move(s);
      if (computer.moveAvailable(move))
      {
         return computer.makePlayerMove(move);
      }
      else
      {
         System.out.println("Duplicate move! No action taken.");
         return null;
      }
         
   }
   
   /**
   * Method to check to see if the player has been defeated.
   * @return returns true if player's entire fleet sunk, false otherwise
   */
   public boolean userDefeated()
   {
      return player.gameOver();
   }
   
   /**
   * Method to check to see if the computer has been defeated.
   * @return returns true if computer's entire fleet sunk, false otherwise
   */
   public boolean computerDefeated()
   {
      return computer.gameOver();
   }
   
   /**
   * Method to return string representation of the game
   * @return returns a string of the two board members labeled
   */
   @Override
   public String toString()
   {
      String output;
      output = String.format("Computer's Board:\n%s\nYour board:\n%s\n", computer, player);
      return output;
   }
   
   
}