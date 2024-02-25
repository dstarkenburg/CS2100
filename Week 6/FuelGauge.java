/**
Duncan Starkenburg
Cs 2100, Week 6 Lab
*/

public class FuelGauge
{
   // Declare private member variables
   private static final int MAX_GALLONS = 15;
   private int gallons;
   
   // Declare constructors 
   public FuelGauge(int gallons)
   {
      if (Math.abs(gallons) >= 0 && Math.abs(gallons) <= MAX_GALLONS)
      {
         this.gallons = Math.abs(gallons);
      }
      else
      {
         this.gallons = MAX_GALLONS;
      }
   }
   
   public FuelGauge()
   {
      this(MAX_GALLONS);
   }
   
   // Accessor function for current fuel
   public int getGallons()
   {
      return this.gallons;
   }
   
   // Mutator function to increment fuel by a gallon
   public boolean addGallon()
   {
      if (this.gallons < MAX_GALLONS)
      {
         this.gallons = this.gallons + 1;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // Mutator function to decrement fuel by a gallon
   public boolean removeGallon()
   {
      if (this.gallons > 0)
      {
         this.gallons = this.gallons - 1;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // Method to check for empty tank
   public boolean isEmpty()
   {
      return gallons == 0;
   }
   
   // Method to check for full tank
   public boolean isFull()
   {
      return gallons == MAX_GALLONS;
   }
   
   // Override the toString function
   @Override
   public String toString()
   {
      return String.format("Gas: %d gallons", this.gallons);
   }
   
   // Override the equals function
   @Override
   public boolean equals(Object obj2)
   {
      FuelGauge gauge2 = (FuelGauge)obj2;
      return this.gallons == gauge2.gallons;
   }
}