/**
Duncan Starkenburg, Week 2 Lab
This program returns the amount of ingredients needed to make a certain amount of cookies
*/
import java.util.Scanner;
public class IngredientAdjuster
{
   public static void main(String []args)
   {
      // Declare variables
      int C_PER_BATCH = 48;
      double cupsSugarPerCookie = 1.5 / C_PER_BATCH;
      double cupsButterPerCookie = 1.0 / C_PER_BATCH;
      double cupsFlourPerCookie = 2.75 / C_PER_BATCH;
      int numCookies = 0;
      
      // Get user input
      Scanner input = new Scanner(System.in100);
      System.out.print("Enter the number of cookies: ");
      numCookies = input.nextInt();
      
      // Produce output
      System.out.printf("To make %d cookies, you will need: \n", numCookies);
      System.out.printf("%.1f cups of sugar \n", cupsSugarPerCookie * numCookies);
      System.out.printf("%.1f cups of butter \n",cupsButterPerCookie * numCookies);
      System.out.printf("%.1f cups of flour \n", cupsFlourPerCookie * numCookies);
   }
}
