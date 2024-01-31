/* 
Duncan Starkenburg
CS 2100, HW 2
This program plays a UVM themed FizzBuzz game.
*/

import java.util.Scanner; // Import scanner class

public class GreenGold
{
   public static void main(String []args)
   {
         System.out.println("Welcome to UVM's edition of FizzBuzz, called GreenGold");
         
         // Declare values
         int StartVal;
         int EndVal;
         
         // Validate values as user inputs
         while(true)
         {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the starting value: ");
            StartVal = input.nextInt();
            System.out.print("Enter the ending value: ");
            EndVal = input.nextInt();
            if (!((StartVal > 0) && (StartVal < EndVal)))
            {
               System.out.println("A low of " + StartVal + " and a high of " + EndVal + " is not a valid choice");
            }
            else
            {
               break;
            }
         }
         
         // Execute the GreenGold game itself
         for (int count = StartVal; count <= EndVal; count++)
         {
            if ((count % 5 == 0) && (count % 2 == 0))
            {
               System.out.println("CATAMOUNT");
            }
            else if (count % 5 == 0)
            {
               System.out.println("GREEN");
            }
            else if (count % 2 == 0)
            {
               System.out.println("GOLD");
            }
            else
            {
               System.out.println(count);
            }
         }
   }
}
