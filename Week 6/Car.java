/**
Duncan Starkenburg
CS 2100, Week 6 Lab
*/

public class Car
{
   // Declare private member functions
   private String make;
   private String model;
   private FuelGauge fuelGauge;
   private Odometer odometer;
   private int milesPerGallon;
   
   // Declare constructors
   public Car(String make, String model, FuelGauge fuelGauge, Odometer odometer, int milesPerGallon)
   {
      this.make = make;
      this.model = model;
      this.fuelGauge = fuelGauge;
      this.odometer = odometer;
      this.milesPerGallon = milesPerGallon;
   }
   
   public Car(String make, String model, int milesPerGallon)
   {
      this(make, model, new FuelGauge(), new Odometer(0), milesPerGallon);
   }
   
   // Drive method
   public void drive(int miles)
   {
      int gallonsUsed = miles / this.milesPerGallon;
      this.odometer.addMileage(miles);
      for (int i = 0; i < gallonsUsed; i++)
      {
         this.fuelGauge.removeGallon();
      }
   }
   
   // Fill tank method
   public void fillTank()
   {
      while (!fuelGauge.isFull())
      {
         this.fuelGauge.addGallon();
      }
   }
   
   // Override the toString method
   @Override
   public String toString()
   {
      return String.format("%s %s\n%s\n%s",this.make, this.model, fuelGauge, odometer);
   }
   
   // Override the equals method
   @Override
   public boolean equals(Object obj2)
   {
      Car car2 = (Car)obj2;
      return this.milesPerGallon == car2.milesPerGallon
             && this.odometer.getMileage() == car2.odometer.getMileage()
             && this.fuelGauge.equals(car2.fuelGauge);
   }
}