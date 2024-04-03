/**
Duncan Starkenburg
CS 2100, Week 11 HW
*/

public class Taxi extends Automobile
{
   // Declare private members
   private Person driver;
   private String id;
   
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
   * @param driver driver object for the vehicle
   * @oaram id vehicle drive's id
   */
   public Taxi(Person owner, String make, String model,
               int year, int mileage, int numPassengers,
               boolean isSUV, Person driver, String id)
   {
      super(owner, make, model, year, mileage, numPassengers, isSUV);
      this.driver = driver;
      this.id = id;
   }
   
   /**
   * Mutator function for the driver object
   * @param new driver Person to set
   */
   public void setDriver(Person driver)
   {
      this.driver = driver;
   }
   
   /**
   * Mutator function for the id member
   * @param new id string to set
   */
   public void setId(String id)
   {
      this.id = id;
   }
   
   /**
   * Accessor function for the driver member
   * @return driver member of vehicle
   */
   public Person getDriver()
   {
      return this.driver;
   }
   
   /**
   * Accessor function for the ID member
   * @return ID member of vehicle
   */
   public String getId()
   {
      return this.id;
   }
   
   /**
   * The toString method
   * @return A String object containing the owner, make,
   * model, year, mileage, driver and ID of a vehicle
   */
   @Override
   public String toString()
   {
      return super.toString() + String.format(",\nDriver: %s ID#%s", driver, id);
   }
   
   /**
   * The equals method
   * @return True if all members are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Taxi taxi2 = (Taxi)obj2;
      return super.equals(taxi2) &&
             this.driver.equals(taxi2.driver) &&
             this.id.equals(taxi2.id);
   }
}