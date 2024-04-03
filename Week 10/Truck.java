/**
Duncan Starkenburg
CS 2100, Week 10 HW
*/

public class Truck extends Vehicle
{
   private int capacity = 1;
   private int axles = 2;
   
   /**
   * Constructor function that takes all 
   * parameters.
   * @param owner object of vehicle
   * @param make of the vehicle
   * @param model of the vehicle
   * @param year of the vehicle
   * @param mileage on the vehicle
   * @param capacity in tons for truck
   * @param axles of the truck
   */
   public Truck(Person owner, String make, String model,
                int year, int mileage, int capacity, int axles)
   {
      super(owner, make, model, year, mileage);
      this.capacity = capacity;
      this.axles = axles;
   }
   
   /**
   * Constructor function that takes person details
   * and uses default truck parameters.
   * @param name of the owner
   * @param address of the owner
   * @param phone number of owner
   * @param make of the vehicle
   * @param model of the vehicle
   * @param year of the vehicle
   * @param mileage on the vehicle
   */
   public Truck(String name, String address, String phone,
                String make, String model, int year, int mileage)
   {
      super(new Person(name, address, phone), make, model, year, mileage);
   }
   
   /**
   * Accessor function for the capacity member
   * @return capacity in tons 
   */
   public int getCapacity()
   {
      return this.capacity;
   }
   
   /**
   * Accessor function for the axles memeber
   * @return number of axles of the truck
   */
   public int getNumAxles()
   {
      return this.axles;
   }
   
   /**
   * Mutator function for the capacity member
   * @param capacity the max number of tons
   */
   public void setCapacity(int capacity)
   {
      this.capacity = capacity;
   }
   
   /**
   * Mutator function for the axles member
   * @param axles new number axles for the truck
   */
   public void setNumAxles(int axles)
   {
      this.axles = axles;
   }
   
   /**
   * The equals method
   * @return True if all members are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Truck tru2 = (Truck)obj2;
      return super.equals(tru2) &&
             this.capacity == tru2.capacity &&
             this.axles == tru2.axles;
   }
   
   /**
   * The toString method
   * @return A String object containing the owner, make,
   * model, year, mileage, capacity, and axles.
   */
   @Override
   public String toString()
   {
      return super.toString() + String.format(" %d ton %d axles", capacity, axles);
   }
}