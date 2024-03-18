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
   * you wish to sell and 'sells' them of a certain stock.
   * If holding has 0 shares, remove it.
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
            double profit = hol2.sellShares(num);
            if (hol2.getNumShares() == 0)
            {
               holdings.remove(hol2);
            }
            return profit;
         }
         
      }
      return 0.0;
   }
   
   /**
   * Accessor function that returns a deep copy of the holdings
   * array
   * @return returns a deep copy of the holding array
   */
   public ArrayList<Holding> getHoldings()
   {
      ArrayList<Holding> outputList = new ArrayList<>();
      for (Holding curr : this.holdings)
      {
         outputList.add(new Holding(curr));
      }
      return outputList;
   }
   
   /**
   * Function to override the toString method so that
   * it returns a formated string of the Portfolio object
   * @return the members of the object in a string
   */
   @Override
   public String toString()
   {
      String output = "";
      output = output + owner + "'s Portfolio\n";
      for (Holding curr : this.holdings)
      {
         output = output + curr + "\n";
      }
      return output;
   }
}