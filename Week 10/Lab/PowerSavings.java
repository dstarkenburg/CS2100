/**
Duncan Starkenburg
CS 2100, Week 10 Lab
*/

public class PowerSavings extends SavingsAccount
{
   public static final double PENALTY = 0.025;
   private double rate;
   private int accountAge = 0;
   private int accountMinimumMonths;
   
   public PowerSavings(String name, double amount, int accountMinimumMonths)
   {
      super(name, amount);
      rate = 0.025;
      this.accountMinimumMonths = accountMinimumMonths;
   }
   
   public void addAMonth()
   {
      postInterest();
      accountAge = accountAge + 1;
   }
   
   @Override
   public boolean withdraw(double amount)
   {
      if (accountAge < accountMinimumMonths)
      {
         return super.withdraw(amount + (amount * PENALTY));
      }
      else
      {
         return super.withdraw(amount);
      }
   }
   
   public void setAccountAge(int accountAge)
   {
      this.accountAge = accountAge;
   }
   
   public void setAccountMinimumMonths(int accountMinimumMonths)
   {
      this.accountMinimumMonths = accountMinimumMonths;
   }
   
   public int getAccountAge()
   {
      return this.accountAge;
   }
   
   public int getAccountMinimumMonths()
   {
      return this.accountMinimumMonths;
   }
   
   @Override
   public String toString()
   {
      return String.format("%s, #%s, $%.2f: %d months elapsed : %d months required", super.getOwner(), this.getAccountNumber(),
                           getBalance(), this.accountAge, this.accountMinimumMonths);
   }
}