/**
Duncan Starkenburg
CS 2100, Final Project
*/

public class Move
{
   // Declare private memebers
   private int row;
   private int col;
   
   /**
   * Main constructor, creates a Move object from a row
   * integer and a collumn integer.
   * @param r integer representing row (0-9)
   * @param c integer representing col (0-9)
   */
   public Move(int r, int c)
   {
      this.row = r;
      this.col = c;
   }
   /**
   * Alternate constructor used to create a move from
   * a String, such as "E10"
   * @param loc string to create Move object from
   */
   public Move(String loc)
   {
      String firstChar = loc.substring(0,1);
      String secondChar = loc.substring(1);
      int row = Integer.parseInt(switch (firstChar)
      {
         case "A" -> "0";        
         case "B" -> "1";
         case "C" -> "2";
         case "D" -> "3";
         case "E" -> "4";
         case "F" -> "5";
         case "G" -> "6";
         case "H" -> "7";
         case "I" -> "8";
         default  -> "9";
      });
      this.row = row;
      this.col = Integer.parseInt(secondChar) - 1;
   }
   
   /**
   * Accessor method for row member
   * @return returns row for this object
   */
   public int row()
   {
      return row;
   }

   /**
   * Accessor method for col member
   * @return returns col for this object
   */ 
   public int col()
   {
      return col;
   }
   
   /**
   * Method to obtain this move in user-readable form
   * @return returns a string of row + col, i.e. "E10"
   */
   @Override
   public String toString()
   {
      String letter = switch(row)
      {
         case 0 -> "A";        
         case 1 -> "B";
         case 2 -> "C";
         case 3 -> "D";
         case 4 -> "E";
         case 5 -> "F";
         case 6 -> "G";
         case 7 -> "H";
         case 8 -> "I";
         default  -> "J";

      };
      return String.format("%s%s", letter, col + 1);
   }
}