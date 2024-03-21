/**
Duncan Starkenburg
CS 2100, in class assingment
*/

import java.util.Date;
public class EmployeeDriver
{
   public static void main(String[] args)
   {
      HourlyEmployee hEmploy = new HourlyEmployee("Duncan", "Starkenburg", new Date(), 30.50, 35.5);
      System.out.println(hEmploy);
   }
}