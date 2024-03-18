/**
Duncan Starkenburg
CS 2100, Week 8 Lab
*/

public class AverageDriver
{
   public static void main(String[] args)
   {
      Average avg = new Average();
      avg.getUserData();
      avg.calculateMean();
      System.out.print(avg);
   }
}