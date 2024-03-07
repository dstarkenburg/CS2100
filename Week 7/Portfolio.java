/**
Duncan Starkenburg
CS 2100, Week 7 Homework
*/
import java.util.ArrayList;

public class Portfolio
{
   // Declare private members
   private String owner;
   private ArrayList<Holding> holdings;

   /**
   * Constructor that creates a portfolio under given name
   * @param name the name of the owner
   */
   public Portfolio(String name)
   {
      owner = name;
      holdings = new ArrayList<>();
   }

   /**
   * Accessor function that returns the owner of the porfolio
   * @return returns the owner of the portfolio as a string
   */
   public String getOwner()
   {
      return this.owner;
   }

   /**
   * Accessor function that returns the amount of holdings 
   * @return returns the amount of holdings
   */
   public int getNumHoldings()
   {
      return this.holdings.size();
   }
   
   /**
   * Mutator function that adds a holding to the holding 
   * array
   * @param h the Holding object to add to array
   */
   public void addHolding(Holding h)
   {
      holdings.add(h);
   }
   
   /**
   * Accessor function that returns a holding with 
   * a certain symbol
   * @param symbol the symbol of the holding to be returned
   * @return returns the holding with the symbol provided
   */
   public Holding getHolding(String symbol)
   {
      for (Holding current : holdings)
      {
         if (current.getStock().getSymbol().equals(symbol))
         {
            return new Holding(current);
         }   
      }
      return null;
   }
   
   /**
   * Mutator function that takes the amount of shares
   * you wish to sell and 'sells' them of a certain stock
   * @param num the number of shares to sell
   * @param symbol the symbol of the share to sell
   * @return returns the price of sold shares
   */
   public double sellShares(String symbol, int num)
   {
      Holding hol2;
      for (Holding current : holdings)
      {
         if (current.getStock().getSymbol().equals(symbol))
         {
            hol2 = current;
            return hol2.sellShares(num);
         }   
      }
      return 0.0;
   }
}