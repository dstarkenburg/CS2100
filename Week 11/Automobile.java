/**
Duncan Starkenburg
CS 2100, Week 11 HW
*/

public class Automobile extends Vehicle
{
   // Declare private members
   private int numPassengers;
   private boolean isSUV;
   
   /**
   * Constructor function that takes all 
   * parameters
   * @param owner owner object of vehicle
   * @param make make of the vehicle
   * @param model model of the vehicle
   * @param year year of the vehicle
   * @param mileage mileage on the vehicle
   * @param numPassengers number of passengers
   * for this vehicle
   * @param isSUV a boolean for if this is an SUV
   */
   public Automobile(Person owner, String make, String model,
                  int year, int mileage, int numPassengers, boolean isSUV)
   {
      super(owner, make, model, year, mileage);
      this.numPassengers = numPassengers;
      this.isSUV = isSUV;
   }
   
   /**
   * Mutator function for the numPassengers integer
   * @param new passenger count to set
   */
   public void setNumPassengers(int numPassengers)
   { 
      this.numPassengers = numPassengers;
   }
   
   /**
   * Mutator function for the isSUV boolean
   * @param truth value for SUV
   */
   public void setIsSUV(boolean isSUV)
   {
      this.isSUV = isSUV;
   }
   
   /**
   * Accessor function for the numPassengers member
   * @return numPassengers member of vehicle
   */
   public int getNumPassengers()
   {
      return this.numPassengers;
   }
   
   /**
   * Accessor function for the isSUV member
   * @return isSUV member of vehicle
   */
   public boolean isSUV()
   {
      return this.isSUV;
   }
   
   /**
   * The toString method
   * @return A String object containing the owner, make,
   * model, year, mileage, passenger count of a vehicle
   */
   @Override
   public String toString()
   {
      String suvString = "";
      if (isSUV)
      {
         suvString = " SUV";
      }
      return super.toString() + String.format(" %d passengers%s", numPassengers, suvString);
   }
   
   /**
   * The equals method
   * @return True if all members are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Automobile auto2 = (Automobile)obj2;
      return super.equals(auto2) &&
             this.numPassengers == auto2.numPassengers &&
             this.isSUV == isSUV;
   }
}