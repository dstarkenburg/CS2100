/**
Duncan Starkenburg
CS 2100, Week 6 Lab
THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
*/

public class CarDriver
{
   public static void main(String [] args)
   {
      Car c1 = new Car("Toyota","Corolla",new FuelGauge(10),
      new Odometer(100), 24);
      
      System.out.println(c1);
      Car c2 = new Car("Honda","CRV", 28);
      Car c3 = new Car("Honda","CRV", 28);
      
      Car c4 = c1;
      
      System.out.println("\n****************");
      System.out.println(c1 == c2);
      System.out.println(c2 == c3);
      System.out.println(c1 == c4);
      
      System.out.println(c1.equals(c2));
      System.out.println(c2.equals(c3));
      System.out.println(c1.equals(c4));
      System.out.println("\n****************");
      
      c1.drive(100);
      System.out.println(c1);
      System.out.println("\n****************");
      
      c1.fillTank();
      System.out.println(c1);
   }
}