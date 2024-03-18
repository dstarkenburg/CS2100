/**
Duncan Starkenburg
CS 2100, Week 7 Homework
*/
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

public class PortfolioDriver
{
   public static void main(String[] args) throws FileNotFoundException, IOException
   {
      // Declare portfolio
      Portfolio userPortfolio;
      
      // Setup file and keyboard scanner
      File file = new File("holdings.txt");
      Scanner input = new Scanner(file);
      Scanner keyboard = new Scanner(System.in);
      
      // Read in portfolio owner
      userPortfolio = new Portfolio(input.nextLine());
      
      // Populate portfolio
      boolean truthValue = true;
      while(truthValue)
      {
         String stockName = input.nextLine();
         String symbol = input.nextLine();
         int shares = input.nextInt();
         double pPrice = input.nextDouble();
         double cPrice = input.nextDouble();
         if (input.hasNextLine())
         {
           input.nextLine();
         }
         Holding currHolding = new Holding(new Stock(stockName, symbol), 
                               shares, pPrice, cPrice);
         userPortfolio.addHolding(currHolding);
         truthValue = input.hasNextLine();
      }
      
      
      // Prompt user for stock to sell
      String curStock;
      do
      {
         System.out.print("Enter a stock to sell: ");
         curStock = keyboard.next();
         if (userPortfolio.getHolding(curStock) == null)
         {
            System.out.println("That stock does not exist!");
         }
         
      }
      while (userPortfolio.getHolding(curStock) == null);
      Holding userHolding = userPortfolio.getHolding(curStock);
     
      // Prompt user for number of shares to sell
      int sharesToSell;
      int numShares;
      do
      {
         numShares = userHolding.getNumShares();
         System.out.print("You have " + numShares + " shares. Enter number of shares to sell: ");
         sharesToSell = keyboard.nextInt();
         if (numShares < sharesToSell || sharesToSell < 0)
         {
            System.out.println("You cannot sell that many shares!");
         }
      }
      while(numShares < sharesToSell || sharesToSell < 0);
      
      // Sell shares
      double profit = userPortfolio.sellShares(curStock, sharesToSell);
      System.out.println("The sale earned you $" + String.format("%.2f", profit));
      System.out.println("");
      System.out.print(String.format("Your updated portfolio:%n%s%n", userPortfolio));

      
      // Write new portfolio to file
      FileWriter output = new FileWriter("PorfolioSummary.txt");
      String outString = "";
      String highSymbol = "";
      double highValue = 0.0;
      double totalValue = 0.0;
      for (Holding curr : userPortfolio.getHoldings())
      {
         if ((curr.getCurrentPrice() * curr.getNumShares()) > highValue)
         {
            highSymbol = curr.getStock().getSymbol();
            highValue = curr.getCurrentPrice() * curr.getNumShares();
         }
         totalValue = totalValue + (curr.getCurrentPrice() * curr.getNumShares());
      }
      outString = String.format("%s's Portfolio as of %s%n%nHighest value holding is %s with a value of $%,.2f%n" +
                  "Total value of portfolio is $%,.2f%n%nCurrent holdings:%n%s", userPortfolio.getOwner(),
                  LocalDate.now(), highSymbol, highValue, totalValue, userPortfolio);
      output.write(outString);
      System.out.print("\nYour portfolio summary has been written to PortfolioSummary.txt");
      
      // Close file reader/writer
      output.close();
      input.close();
   }
}