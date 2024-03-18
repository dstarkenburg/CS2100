/**
Duncan Starkenburg
CS 2100, Week 8 Lab
*/
import java.util.Scanner;

public class Average
{
   private int[] data;
   private double mean;
   public static final int NUM_SCORES = 5;
   
   public Average()
   {
      data = new int[NUM_SCORES];
   }
   
   public void getUserData()
   {
      Scanner in = new Scanner(System.in);
      for (int i = 0; i < NUM_SCORES; i++)
      {
         System.out.print("Enter number " + (i + 1) + ": ");
         data[i] = in.nextInt();
      }
   }
   
   public void calculateMean()
   {
      int sum = 0;
      for (int cur : data)
      {
         sum = sum + cur;
      }
      mean = sum / data.length;
   }
   
   @Override
   public String toString()
   {
      return String.format("[%d, %d, %d, %d, %d]\nMean: %.2f", data[0], data[1], data[2], data[3], data[4], mean);
   }
}