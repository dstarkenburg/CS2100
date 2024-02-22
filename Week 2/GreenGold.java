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
         int startVal;
         int endVal;
         final int GREEN = 5;
         final int GOLD = 2;
         
         // Validate values as user inputs
         Scanner input = new Scanner(System.in);
         System.out.print("Enter the starting value: ");
         startVal = input.nextInt();
         System.out.print("Enter the ending value: ");
         endVal = input.nextInt();
         
         while(!((startVal > 0) && (startVal < endVal)))
         {
            System.out.println("A low of " + startVal + " and a high of " + endVal + " is not a valid choice");
            System.out.print("Enter the starting value: ");
            startVal = input.nextInt();
            System.out.print("Enter the ending value: ");
            endVal = input.nextInt();
            
         }
                 
         // Execute the GreenGold game itself
         for (int count = startVal; count <= endVal; count++)
         {
            if ((count % GREEN == 0) && (count % GOLD == 0))
            {
               System.out.println("CATAMOUNT");
            }
            else if (count % GREEN == 0)
            {
               System.out.println("GREEN");
            }
            else if (count % GOLD == 0)
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
