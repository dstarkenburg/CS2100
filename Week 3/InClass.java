/**
Duncan Starkenburg
CS 2100, Inclass Assignment Week 3
*/

public class InClass
{
   public static void main(String []args);
   {
      futureValue(0.0,0.35,6);
   }
   
   /** The futureValue method takes two double parameters, for present value
       and annual interest rate, and an integer # of years and determuns
       future value. Formula requires interest rate as .035 for 3.5%
       futureVal = presentValue * (1 + monthlyInterestRate) ^ (# of months)
         @param presentValue staring value of investment
         @param rate         annual interest rate (e.g., 0.35 for 3.5%)
         @param years        number of years
         @return             future value of investment
   
   */
   public static double futureValue(double presentValue, double rate, int years)
   {
      double monthlyInterestRate = rate / 12;
      int months = years * 12;
      double futureValue = presentValue * Math.pow(1 + monthlyInterestRate, months);
      return futureValue;
   }
}