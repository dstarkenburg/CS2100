/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

public class BattleshipDriver
{
   /**
   * Main function, run this file to run the game.
   * Change DIFFICULTY below to activate AI.
   */
   public static void main(String[] args)
   {
      ///*****************///
      int DIFFICULTY = 0; /// 0: No AI, 1: Easy AI, 2: Normal AI, 3: Medium AI, 4: Hard AI, 5: Expert AI
      ///*****************///
      
      // Initiate the game, keyboard input, and valid moves
      Game game = new Game(DIFFICULTY); 
      Scanner keyboard = new Scanner(System.in);
      String[] alpha = {"A","B","C","D","E","F","G","H","I","J"};
      String[] number = {"1","2","3","4","5","6","7","8","9", "10"};
      
      // Pick who starts and show inital board
      Random rand = new Random();
      if (rand.nextInt(2) == 0)
      {
         String[] compPlay = game.makeComputerMove();
         System.out.print(game);
         System.out.println("Computer won the coin toss!");
         System.out.println("Computer's move: " + compPlay[0]);
      }
      else
      {
         System.out.print(game);
         System.out.println("You won the coin toss!");
      }
      
      // Run game
      while(!game.userDefeated() && !game.computerDefeated())
      {  
         // Validate move input
         boolean flag = true;
         String move = "";
         while (flag)
         {
            System.out.print("Your move: ");
            move = keyboard.nextLine();
            String firstString = move.substring(0, 1);
            String secondString = move.substring(1);
            if (Arrays.asList(alpha).contains(firstString.toUpperCase()) && Arrays.asList(number).contains(secondString))
            {
               flag = false;
            }
            else
            {
               System.out.print(game);
               System.out.println("Invalid move! A-J, 1-10; i.e. E10");           
            }
         }
         
         // Make both user and computer move
         String userPlay = game.makePlayerMove(move.toUpperCase());
         String[] compPlay = game.makeComputerMove();
         
         // Display updated board and any events that happened this turn
         System.out.print(game);
         System.out.println("Computer's move: " + compPlay[0]);
         if (userPlay != null)
         {
            System.out.println(userPlay);
         }
         else if (compPlay[1] != null)
         {
            System.out.println(compPlay[1]);
         }
         System.out.println("");
      }
      // Check if game is over
      if(game.userDefeated())
      {
         System.out.println("Computer wins!");
      }
      else
      {
         System.out.println("Player wins!");
      }
   }
}