/**
Duncan Starkenburg
CS 2100, Week 9 Lab
*/

public class CheckingAccount extends BankAccount
{
   private static final double FEE = 0.15;
   
   public CheckingAccount(String name, double amount)
   {
      super(name, amount);
      this.setAccountNumber(this.getAccountNumber() + "-10");
   }
   
   public boolean withdraw(double amount)
   {
      amount = amount + FEE;
      return super.withdraw(amount);
   }
}