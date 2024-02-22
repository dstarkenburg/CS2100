/**
Duncan Starkenburg
CS 2100, Week 6 Lab
*/

public class Odometer
{
   // Declare private members
   private static final int MAX_MILEAGE = 999999;
   private int mileage;
   
   // Declare private setter utility method
   private void setMileage(int m)
   {
      this.mileage = Math.abs(m) % MAX_MILEAGE;
   }
   
   // Declare constructor
   public Odometer(int m)
   {
      setMileage(m);
   }
   
   // Mileage accessor function
   public int getMileage()
   {
      return this.mileage;
   }
   
   // Mutator function for mileage
   public void addMileage(int m)
   {
      setMileage(this.mileage + m);
   }
   
   // Override the toString method
   @Override
   public String toString()
   {
      return String.format("Mileage: %d miles", this.mileage);
   }
}