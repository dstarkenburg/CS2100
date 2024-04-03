/**
Duncan Starkenburg
CS 2100, Week 11 HW
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class VehicleDriver 
{
   public static void main(String[] args) throws IOException
   {
      // Setup file scanner
      Scanner input = new Scanner(new File("vehicles.txt"));
      
      // Create and populate arrayList
      ArrayList<Vehicle> fleet = new ArrayList<Vehicle>(); // initialize arraylist
      
      while(input.hasNext())
      {
         String type = input.nextLine(); // check vehicle type
         
         if(type.equals("Truck")) // truck object creation
         {
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String make = input.nextLine();
            String model = input.nextLine();
            int year = Integer.parseInt(input.nextLine());
            int mileage = Integer.parseInt(input.nextLine());
            int capacity = Integer.parseInt(input.nextLine());
            int axles = Integer.parseInt(input.nextLine());
            
            Vehicle truck = new Truck(new Person(name, address, phone), make, model,
                                      year, mileage, capacity, axles);
                                      
            fleet.add(truck); // add truck object to array
            
         }
         else if (type.equals("Taxi")) // taxi object creation
         {
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String make = input.nextLine();
            String model = input.nextLine();
            int year = Integer.parseInt(input.nextLine());
            int mileage = Integer.parseInt(input.nextLine());
            int passengers = Integer.parseInt(input.nextLine());
            boolean isSUV = Boolean.parseBoolean(input.nextLine());
            String dName = input.nextLine();
            String dAddress = input.nextLine();
            String dPhone = input.nextLine();
            String id = input.nextLine();
            
            Vehicle taxi = new Taxi(new Person(name, address, phone), make, model,
                                      year, mileage, passengers, isSUV, new Person(dName, dAddress, dPhone), id);
                                      
            fleet.add(taxi); // add taxi object to array
         }
         else // automobile object creation (only remaining case)
         {
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String make = input.nextLine();
            String model = input.nextLine();
            int year = Integer.parseInt(input.nextLine());
            int mileage = Integer.parseInt(input.nextLine());
            int passengers = Integer.parseInt(input.nextLine());
            boolean isSUV = Boolean.parseBoolean(input.nextLine());
            
            Vehicle automobile = new Automobile(new Person(name, address, phone), make, model,
                                      year, mileage, passengers, isSUV);
                                      
            fleet.add(automobile); // add automobile object to array
         }
      }
      
      // Create very large oldest number for comparison
      int oldest = 9999;
      
      // Find earliest year (oldest car)
      for (int i = 0; i < fleet.size(); i++)
      {
            if (fleet.get(i).getYear() < oldest)
            {
               oldest = fleet.get(i).getYear();
            }
      }
         
      // Print vehicles to be sold
      System.out.println("Vehicles to be sold:");
      
      // Cycle through oldest cars and print them
      for (int j = 0; j < fleet.size(); j++)
      {
         if (fleet.get(j).getYear() == oldest)
         { 
            if (fleet.get(j) instanceof Truck)
               System.out.print("TRUCK: ");
            else if (fleet.get(j) instanceof Taxi)
               System.out.print("TAXI: ");
            else
               System.out.print("AUTOMOBILE: ");
            System.out.println(fleet.get(j));
            System.out.println();
         }
      }
     
     // Close file
     input.close();
   }  
}