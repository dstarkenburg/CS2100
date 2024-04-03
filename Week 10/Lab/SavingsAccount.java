/**
Duncan Starkenburg
CS 2100, Week 10 Lab
*/

public class SavingsAccount extends BankAccount
{
   private double rate;
   private int savingsNumber = 0;
   
   public SavingsAccount(String name, double amount)
   {
      super(name, amount);
      rate = 0.05;
      super.setAccountNumber(super.getAccountNumber() + "_" + savingsNumber);
   }
   
   public SavingsAccount(SavingsAccount toCopy, double amount)
   {
      super(toCopy, amount);
      rate = 0.05;
      savingsNumber = savingsNumber + 1;
      super.setAccountNumber(super.getAccountNumber() + "_" + savingsNumber);
   }
   
   public void postInterest()
   {
      double interest = (rate / 12) * getBalance();
      setBalance(getBalance() + interest);
   }
}