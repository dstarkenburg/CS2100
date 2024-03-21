/**
Duncan Starkenburg
CS 2100 A, in class assignment
*/
import java.util.Date;

public class SalariedEmployee extends Employee
{
   private double salary;
   
   public SalariedEmployee(String firstName,String lastName,
              Date theDate, double salary)
   {
      super(firstName,lastName,theDate);
      this.salary = salary ;     
   }
   
   public SalariedEmployee(SalariedEmployee other)
   {
      super(other);
      this.salary = other.salary;
   }
   
   public void setSalary(double salary)
   {
      this.salary = salary;
   }
   
   public double getSalary()
   {
      return salary;
   }
   
   @Override
   public String toString()
   {
      return String.format("%s, salary of $%.2f", super.toString(), salary);
   }
   
   @Override
   public boolean equals(Object obj2)
   {
      SalariedEmployee se2 = (SalariedEmployee)obj2;
      if (obj2 == null)
         return false;
      return (super.equals(se2) && this.salary == se2.salary);
   }
}