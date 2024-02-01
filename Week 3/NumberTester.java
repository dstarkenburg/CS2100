/**
Duncan Starkenburg
CS2100, HW 3
This program takes a .txt file input, identifies the numbers in 
the file as prime, has repeating digits, and even and outputs it 
formated into another .txt file
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class NumberTester
{
   public static void main(String []args) throws IOException
   {
      Scanner input = new Scanner(System.in);
      
      // Get filename from user
      System.out.print("Enter a filename: ");
      String filename = input.nextLine();
      
      // Open both the input file and output file
      Scanner inFile = new Scanner(new File(filename));
      PrintWriter outFile = new PrintWriter("numberSummary.txt");
      
      // Write headers to output file
      outFile.printf("%13s\n","Repeat");
      outFile.printf("%-7s%-9s%-6s%5s\n", "Number","Digits","Even","Prime");
      
      // While there are still lines to read: [1] Read in each line as an int; 
      // [2] get its truth values; [3] and write output
      while(inFile.hasNextLine())
      {
         // [1]
         int curNum = inFile.nextInt();
         
         // [2]
         String curIsPrime = isPrime(curNum) ? "+" : "-";
         String curIsRepeatedDigits = isRepeatedDigits(curNum) ? "+" : "-";
         String curIsEven = isEven(curNum) ? "+" : "-";
         
         // [3]
         outFile.printf("%4d%7s%7s%7s\n", curNum, curIsRepeatedDigits,
         curIsEven, curIsPrime);
      }
      
      // Close files!
      outFile.close();
      inFile.close();
   }
   
   /**
   * isPrime function takes an int and returns true or false  
   * depending on if it is prime or not
   * @param   num   The integer that will be evaluated as prime or not prime
   * @return        Returns true or false depending on evaluation
   */
   public static boolean isPrime(int num)
   {
      int d = num + 1;
      int divisors = 0;
      while (d >= 2)
      {
         if (num % (d - 1) == 0)
         {
            divisors += 1;
         }
         d = d - 1;
      }
      if (divisors == 2)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
   * isRepeatedDigits function takes an int and returns true or false depending on if it
   * contains adjacent duplicate digits or not
   * @param  num  The integer that will be evaluated as having repeating digits or not
   * @return      Returns true or false depending on evaluation
   */
   public static boolean isRepeatedDigits(int num)
   {
      String numString = Integer.toString(num);
      for(int i = 0; i < numString.length() - 1; i++){
         if (numString.charAt(i) == numString.charAt(i+ 1))
         {
            return true;
         }
      }
      return false;
   }
   
   /**
   * isEven function takes an int and returns true or false depending on
   * if it is even or not.
   * @param  num  The integer that will be evaluated as even or odd
   * @return      true or false depending on evaluation
   */
   public static boolean isEven(int num)
   {
      if (num % 2 == 0)
      {
         return true;
      }
      else{
         return false;
      }
   } 
}