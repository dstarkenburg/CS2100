/**
Duncan Starkenburg
CS 2100, Week 11 HW
*/

public class Vehicle
{
   // Declare private memebers;
   private Person owner;
   private String make;
   private String model;
   private int year;
   private int mileage;
   
   /**
   * Constructor function that takes all 
   * parameters.
   * @param owner owner object of vehicle
   * @param make make of the vehicle
   * @param model model of the vehicle
   * @param year year of the vehicle
   * @param mileage mileage on the vehicle
   */
   public Vehicle(Person owner, String make, String model,
                  int year, int mileage)
   {
      this.owner = owner;
      this.make = make;
      this.model = model;
      this.year = year;
      this.mileage = mileage;
   }
   
   /**
   * Constructor function that takes all 
   * parameters but mileage, which is now 0
   * @param owner owner object of vehicle
   * @param make make of the vehicle
   * @param model model of the vehicle
   * @param year year of the vehicle
   */
   public Vehicle(Person owner, String make, String model,
                  int year)
   {
      this(owner, make, model, year, 0);
   }
   
   /**
   * Accessor function for the owner member
   * @return owner object of vehicle
   */
   public Person getOwner()
   {
      return this.owner;
   }
   
   /**
   * Accessor function for the make member
   * @return make string of vehicle
   */
   public String getMake()
   {
      return this.make;
   }
   
   /**
   * Accessor function for the model member
   * @return model string of vehicle
   */
   public String getModel()
   {
      return this.model;
   }
   
   /**
   * Accessor function for the year member
   * @return year integer of vehicle
   */
   public int getYear()
   {
      return this.year;
   }
   
   /**
   * Accessor function for the mileage member
   * @return mileage integer of vehicle
   */
   public int getMileage()
   {
      return this.mileage;
   }
   
   /**
   * Mutator function for the owner object
   * @param new owner object to set
   */
   public void setOwner(Person owner)
   {
      this.owner = owner;
   }
   
   /**
   * Mutator function for the make string
   * @param new make string to set
   */
   public void setMake(String make)
   {
      this.make = make;
   }
   
   /**
   * Mutator function for the model string
   * @param new model string to set
   */
   public void setModel(String model)
   {
      this.model = model;
   }
   
   /**
   * Mutator function for the year integer
   * @param new year integer to set
   */
   public void setYear(int year)
   {
      this.year = year;
   }
   
   /**
   * Mutator function for the mileage integer
   * @param new mileage integer to set
   */
   public void setMileage(int mileage)
   {
      this.mileage = mileage;
   }
   
   /**
   * The toString method
   * @return A String object containing the owner, make,
   * model, year, and mileage of a vehicle
   */
   @Override
   public String toString()
   {
      return String.format("%s\n%s %s %d %d miles", owner, make, model,
                           year, mileage);
   }
   
   /**
   * The equals method
   * @return True if all members are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Vehicle veh2 = (Vehicle)obj2;
      return this.owner.equals(veh2.owner) &&
             this.make.equals(veh2.make) &&
             this.model.equals(veh2.model) &&
             this.year == veh2.year &&
             this.mileage == veh2.mileage;
   }
}