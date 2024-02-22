/**
Duncan Starkenburg
CS 2100, Week 6 In Class Assignment
PORTIONS OF THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON @ UVM
*/

public class Driver1
{
   public static void main(String [] args)
   {
      Address a1 = new Address("333 Colchester Ave","Burlington", "VT", "05405");
      Address a2 = new Address("67 Oak Circle","Orlando", "FL", "32789");

      Invitation i1 = new Invitation("Bob Barker", "Celebration", "June 1, 2024",
                                      a1, a2);
//     Address a3 = new Address("67 Oak Circle","Orlando", "FL", "32789");
//      Address a4 = a1;
//      
//      System.out.println(a1 == a4);
//      System.out.println(a2 == a3);
//      System.out.println(a1.equals(a4));
//      System.out.println(a2.equals(a3));
//      System.out.print(a1);
   }

}