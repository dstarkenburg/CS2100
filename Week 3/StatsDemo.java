/**
Duncan Starkenburg
CS2100, Week 3 Lab
This class reads numbers from a file, calculates the
mean and standard deviation, and writes the results
to a file.
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class StatsDemo
{
   public static void main(String[] args) throws IOException
   {
      double sum = 0; // The sum of the numbers
      int count = 0; // The number of numbers added
      double mean = 0; // The average of the numbers
      double stdDev = 0; // The standard deviation
      double difference; // The value and mean difference
      double variance; /** The variance bewtween sum of square 
      difference and counter */
      
      // Create an object of type Scanner
      Scanner keyboard = new Scanner (System.in);
      String filename; // The user input file name
      
      // Prompt the user and read in the file name
      System.out.println("This program calculates " +
      "statistics on a file " +
      "containing a series of numbers");
      System.out.print("Enter the file name: ");
      filename = keyboard.nextLine();
      
      // Create a File object passing it the filename
      Scanner input = new Scanner(new File(filename));
      // Loop until you are at the end of the file
      while(input.hasNextLine())
      {
         double curNum = input.nextDouble();
         sum += curNum;
         count++;
      }
      mean = sum / count;
      sum = 0;
      count = 0;
      // Close files!
      input.close();
      
      // Create new input file scanner
      Scanner input2 = new Scanner(new File(filename));
      // Loop until you are at the end of the file
      while(input2.hasNextLine())
      {
         double curNum = input2.nextDouble();
         difference = curNum - mean;
         sum += Math.pow(difference, 2);
         count++;
      }
      
      variance = sum / count;
      stdDev = Math.sqrt(variance);
      sum = 0;
      count = 0;
      
      // Close files!
      input.close();

      // Open printwriter file and write output
      PrintWriter output = new PrintWriter("results.txt");
      output.printf("Mean: %.3f\n", mean);
      output.printf("Std Deviation: %.3f\n", stdDev);
      
      // Close the output file
      output.close();
   }
}