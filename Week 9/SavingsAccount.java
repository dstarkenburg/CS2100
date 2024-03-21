/**
Duncan Starkenburg
CS 2100, Week 9 Lab
*/

public class SavingsAccount extends BankAccount
{
   private double rate = 0.025;
   private int savingsNumber = 0;
   private String accountNumber;
   
   public SavingsAccount(String name, double amount)
   {
      super(name, amount);
      this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
   }
   
   public SavingsAccount(SavingsAccount toCopy, double amount)
   {
      super(toCopy, amount);
      this.savingsNumber = this.savingsNumber + 1;
      this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
   }
   
   public void postInterest()
   {
      double interest = (rate / 12) * super.getBalance();
      super.setBalance(super.getBalance() + interest);
   }
}