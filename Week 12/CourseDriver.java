/**
Duncan Starkenburg
CS 2100, Week 12 HW
*/
import java.io.*;
import java.util.Scanner;

public class CourseDriver
{
   /**
   * Method to sort (in place) a partially or fully filled array
   * @param array  the array of Course objects to sort
   * @param length the number of indecies with data
   */
   public static void selectSort(Course[] array, int length)
   {
      int startScan, index, minIndex, minValue;

      for (startScan = 0; startScan <= (length - 1); startScan++)
      {
         minIndex = startScan;
         minValue = array[startScan].getCrn();
         for(index = startScan + 1; index <= (length - 1); index++)
         {
            if (array[index].compareTo(array[minIndex]) == -1)
            {
               minValue = array[index].getCrn();
               minIndex = index;
            }
         }
         Course c = array[minIndex];
         array[minIndex] = array[startScan];
         array[startScan] = c;
      }
   }
   
   /**
   * Function that uses binary recursive search to search an
   * array of Course objects
   * @param array  the array of courses to search
   * @param first  index value of first search
   * @param last   index value of last search
   * @param value  crn value to search for
   */
   public static Course crnSearch(Course[] array, int first,
                                int last, int value)
   {
      Course target = new Course("", 0, "", value, "", "");
      int middle;

      middle = (first + last) / 2;
      
      if (first > last)
         return null;
          
      if (array[middle].compareTo(target) == 0)
         return array[middle];
      else if (array[middle].compareTo(target) == -1)
         return crnSearch(array, middle + 1,
                          last, value);
      else
         return crnSearch(array, first,
                          middle - 1, value);
   }
   
   // Main function
   public static void main(String[] args)
   {
      // Declare and initialize Course array
      Course[] array = new Course[6000];
      
      // Declare file scanner and try to open file
      Scanner input;
      try
      {
         input = new Scanner(new File("curr_enroll_spring.csv"));
         System.out.println("File successfully opened\n");
      }
      catch (FileNotFoundException e)
      {
         System.out.print("File was not found, exiting");
         return;
      }
      
      System.out.println("****************************************\n");
      
      // Populate array with CSV data read from file
      input.nextLine(); // throw out headers
      int arrayCount = 0;
      while(input.hasNext())
      {
         String s = input.nextLine();
         String[] sArray = s.split(",");
         array[arrayCount] = new Course(sArray[0], Integer.parseInt(sArray[1]),
                                        sArray[2], Integer.parseInt(sArray[3]),
                                        sArray[4], sArray[5].replace("\"", ""));
         arrayCount++;
      }
      
      // display number of courses in array
      System.out.println(String.format("%d courses loaded into array\n", arrayCount));
      System.out.println("****************************************\n");
      
      // sort the array by crn
      selectSort(array, arrayCount);
      System.out.println("Array successfully sorted\n");
      
      // lowest crn at index 0
      System.out.println("The course with the lowest CRN is:");
      System.out.println(String.format("%s\n", array[0]));
      // highest crn at index arrayCount - 1
      System.out.println("The course with the highest CRN is:");
      System.out.println(String.format("%s\n", array[arrayCount - 1]));
      System.out.println("****************************************\n");
      
      // declare and initialize keyboard scanner
      Scanner keyboard = new Scanner(System.in);
      // prompt user for crn to find    
      System.out.print("Which crn would you like to find? ");
      int crn = Integer.parseInt(keyboard.nextLine());
      
      // search for crn if it exists and print it
      Course userCourse = crnSearch(array, 0, arrayCount - 1, crn);
      if (userCourse == null)
      {
         System.out.println(String.format("%d crn does not match any course", crn));
      }
      else
      {
         System.out.println("Found:");
         System.out.println(String.format("%s", userCourse));
      }  
      
      // close the file!
      input.close();
   }
}