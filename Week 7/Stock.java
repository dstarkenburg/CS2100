/**
Duncan Starkenburg
CS 2100, Week 7 Homework
*/

public class Stock
{
   // Declare private members
   private String name;
   private String symbol;
   
   /**
   * Constructor that takes in a string as stock name 
   * and a string for the stock symbol
   * @param name   the name of the stock as a string
   * @param symbol the symbol of the stock as a string
   */
   public Stock(String name, String symbol)
   {
      this.name = name;
      this.symbol = symbol;
   }
   
   /**
   * Accessor function that returns the name of the stock
   * @return returns the name as a String
   */
   public String getName()
   {
      return this.name;
   }
   
   /**
   * Accessor function that returns the symbol of the stock
   * @return returns the symbol as a String
   */
   public String getSymbol()
   {
      return this.symbol;
   }
   
   /**
   * Function to override the equals method so that
   * it returns true if they have the same name and
   * symbol
   * @return the truth value if two Stocks are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Stock sto2 = (Stock)obj2;
      return (sto2.name.equals(this.name)
             && sto2.symbol.equals(this.symbol));
   }
   
   /**
   * Function to override the toString method so that
   * it returns a formated string of the Stock object
   * @return the members of the object in a string
   */
   @Override
   public String toString()
   {
      return String.format("%s:%s", symbol, name);
   }
   
} 