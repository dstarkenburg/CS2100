/*
Duncan Starkenburg
CS2100, HW 1
This program asks a user for their first, middle, and last name, and returns their initials
*/

import java.util.Scanner; // Import scanner class

public class Initials
{
   public static void main(String []args)
   {
      // Declare name variables
      String FirstName;
      String MiddleName;
      String LastName;
      
      // Ask user for names and store in variables
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter your first name: ");
      FirstName = keyboard.next();
      System.out.print("Enter your middle name: ");
      MiddleName = keyboard.next();
      System.out.print("Enter your last name: ");
      LastName = keyboard.next();
      
      // Capitalize the names so that the first character will
      // be read in capitals
      FirstName = FirstName.toUpperCase();
      MiddleName = MiddleName.toUpperCase();
      LastName = LastName.toUpperCase();
      
      // Declare and get initals from names
      char FirstInit = FirstName.charAt(0);
      char SecondInit = MiddleName.charAt(0);
      char ThirdInit = LastName.charAt(0);
      
      // Concatenate char to string and print to console
      String output = "Your initals are " + FirstInit + SecondInit + ThirdInit;
      System.out.println(output);      
   }
}
