/**
Duncan Starkenburg
CS2100, Week 4 HW 
This is the main class
*/
public class DollarGame
{
   public static void main(String []args)
   {
      // Create each player's three coins
      Coin p1coin5 = new Coin(5);
      Coin p1coin10 = new Coin(10);
      Coin p1coin25 = new Coin(25);
      Coin p2coin5 = new Coin(5);
      Coin p2coin10 = new Coin(10);
      Coin p2coin25 = new Coin(25);
      
      // Create scoreboard values
      int p1sum = 0;
      int p2sum = 0;
      int round = 1;
      
      // Play the game
      while (p1sum != 100 || p2sum != 100)
      {
         // Toss the coins and add them up
         p1sum = p1sum + processOneCoin(p1coin5) + processOneCoin(p1coin10) + processOneCoin(p1coin25);
         p2sum = p2sum + processOneCoin(p2coin5) + processOneCoin(p2coin10) + processOneCoin(p2coin25);
         
         // Output outcome
         System.out.printf("Round %d: Player 1: %d. Player 2: %d \n", round, p1sum, p2sum);
         
         // Reset player if they get past 100
         if (p1sum > 100)
         {
            System.out.println("Resetting player 1 to 0");
            p1sum = 0;
         }
         if (p2sum > 100)
         {
            System.out.println("Resetting player 2 to 0");
            p2sum = 0;
         }
         
         // Iterate round
         round++;
      }
      
      // Declare winner
      String winner;
      if (p1sum == 100 && p2sum == 100)
      {
         winner = "Its a tie!";
      }
      else if (p2sum == 100)
      {
         winner = "Player 2 wins!";
      }
      else
      {
         winner = "Player 1 wins!";
      }
      System.out.println(winner);
   }
   
   /**
   *  processOneCoin tosses the Coin and returns the Coin value 
   *  *if* it is heads up.  Otherwise, 0 is returned
   *  @param c the Coin object to be tossed
   *  @return the value of the coin if heads is up, 0 otherwise
   */
   public static int processOneCoin(Coin c)
   {
      c.toss();
      int val = c.isHeads() ? c.getValue() : 0;
      return val;
   }
}