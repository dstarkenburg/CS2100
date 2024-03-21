/**
This class was written by Jackie Horton for 
UVM CS 2100
*/

import java.util.Date;
public class Employee
{
   private String firstname;
   private String lastname;
   private Date hireDate;
   // constructor
   public Employee(String fName, String lName, Date theDate)
   {
      firstname = fName;
      lastname = lName;
      hireDate = new Date(theDate.getTime());
   }
   // copy constructor
   public Employee(Employee originalObject)
   {
      firstname = originalObject.firstname;
      lastname = originalObject.lastname;
      hireDate = new Date(originalObject.hireDate.getTime());
   }
   // getters
   public String getName( )
   {
      return firstname + " " + lastname;
   }
   public Date getHireDate( )
   {
      return new Date(hireDate.getTime());
   }
   // setters
   public void setName(String fName, String lName)
   {
      firstname = fName;
      lastname = lName;
   }
   public void setHireDate(Date newDate)
   {
      hireDate = new Date(newDate.getTime());
   }
   //toString
   @Override
   public String toString( )
   {
      return (firstname + " " + lastname+ " " + hireDate.toString( ));
   }
   // objects are equals if all fields are the same
   @Override
   public boolean equals(Object other)
   {
      Employee otherEmployee = (Employee) other;
      // a bit of protection ... if the other object sent in is null
      // you don't want to attempt to dereference it, the program
      // will crash
      if (otherEmployee == null)
         return false;
      else
      {
         return (firstname.equals(otherEmployee.firstname)
         && lastname.equals(otherEmployee.lastname)
         && hireDate.equals(otherEmployee.hireDate));
      }
   }
}