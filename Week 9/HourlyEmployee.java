/**
Duncan Starkenburg
CS 2100 A, in class assignment
*/
import java.util.Date;

public class HourlyEmployee extends Employee
{
   private double wageRate;
   private double hours;
   
   public HourlyEmployee(String firstName,String lastName,
              Date theDate, double theWageRate, double theHours)
   {
      super(firstName,lastName,theDate);
      wageRate = theWageRate;
      hours = theHours;           
   }
   
   public HourlyEmployee(HourlyEmployee other)
   {
      super(other);
      this.wageRate = other.wageRate;
      this.hours = other.hours;
   }
   
   public void setWageRate(double wRate)
   {
      wageRate = wRate;
   }
   
   public void setHours(double wHours)
   {
      hours = wHours;
   }
   
   public double getWageRate()
   {
      return wageRate;
   }
   
   public double getHours()
   {
      return hours;
   }
   
   @Override
   public String toString()
   {
      return String.format("%s, %.1f hours at $%.1f/hr", super.toString(), hours, wageRate);
   }
   
   @Override
   public boolean equals(Object obj2)
   {
      HourlyEmployee he2 = (HourlyEmployee)obj2;
      if (obj2 == null)
         return false;
      return (super.equals(he2) && this.hours == he2.hours 
               && this.wageRate == he2.wageRate);
   }
}