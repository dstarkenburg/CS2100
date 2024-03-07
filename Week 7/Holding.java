/**
Duncan Starkenburg
CS 2100, Week 7 Homework
*/

public class Holding
{
   // Declare private memebers
   private Stock stock;
   private int numShares;
   private double purchasePrice;
   private double currentPrice;
   
   /**
   * Constructor that takes in a Stock object, a
   * int of the number of shares, a double of purchase
   * price, and a double of current price
   * @param stock   the name of the stock as a string
   * @param numShares the symbol of the stock as a string
   * @param purchasePrice the purchase price of the stock
   * @param currentPrice the current sell price of the stock
   */
   public Holding(Stock st, int num, double pp, double cp)
   {
      stock = st;
      numShares = num;
      purchasePrice = pp;
      currentPrice = cp;
   }
   
   /**
   * Copy constructor that creates a shallow copy of a
   * holding object
   * @param h a holding object to create a shallow copy of
   */
   public Holding(Holding h)
   {
      stock = h.stock;
      numShares = h.numShares;
      purchasePrice = h.purchasePrice;
      currentPrice = h.currentPrice;
   }
   
   /**
   * Accessor function that returns the Stock of the holding
   * @return returns the stock as a Stock object
   */
   public Stock getStock()
   {
      return this.stock;
   }
   
   /**
   * Accessor function that returns the number of shares
   * @return returns the number of shares as an int
   */
   public int getNumShares()
   {
      return this.numShares;
   }
   
   /**
   * Mutator function that takes the amount of shares
   * you wish to sell and 'sells' them
   * @param num the number of shares to sell
   * @return returns the price of sold shares
   */
   public double sellShares(int num)
   {
      numShares = numShares - num;
      return (num * currentPrice);
   }
   
   /**
   * Accessor function that returns the current price 
   * @return returns the current price as a double
   */
   public double getCurrentPrice()
   {
      return this.currentPrice;
   }
   
   /**
   * Accessor function that returns the purchase price
   * @return returns the purchase price as an double
   */
   public double getPurchasePrice()
   {
      return this.purchasePrice;
   }
   
   /**
   * Mutator function that takes and sets the current price
   * @param price the current price as a double
   */
   public void setCurrentPrice(double price)
   {
      currentPrice = price;
   }

   /**
   * Function to override the equals method so that
   * it returns true if they have the same instance
   * variables
   * @return the truth value if two Holdings are equal
   */
   @Override
   public boolean equals(Object obj2)
   {
      Holding hol2 = (Holding)obj2;
      return (hol2.stock.equals(this.stock)
             && hol2.numShares == this.numShares
             && hol2.purchasePrice == this.purchasePrice
             && hol2.currentPrice == this.currentPrice);
   }
   
   /**
   * Function to override the toString method so that
   * it returns a formated string of the Stock object
   * @return the members of the object in a string
   */
   @Override
   public String toString()
   {
      return String.format("%\n% shares\nPurchase price: $%.2f\nCurrent price: $%.2f",
                           stock, numShares, purchasePrice, currentPrice);
   }
   
}