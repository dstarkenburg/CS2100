/**
Duncan Starkenburg
CS 2100, Week 10 Lab Driver
*/

public class LabDriver
{
   public static void main(String[] args)
   {
      PowerSavings ps = new PowerSavings("Jackie Horton",500.00,4);
      System.out.println(ps);
      ps.withdraw(50);
      System.out.println(ps);
      ps.addAMonth();
      System.out.println(ps);
      ps.addAMonth();
      ps.addAMonth();
      ps.addAMonth();
      System.out.println(ps);
      ps.withdraw(100);
      System.out.println(ps);
      
      BankAccount b1 = new CheckingAccount("Duncan Starkenburg", 1000.00);
      BankAccount b2 = new SavingsAccount("Duncan Starkenburg", 1000.00);
      BankAccount b3 = new PowerSavings("Duncan Starkenburg", 1000.00, 4);
      BankAccount[] bArray = new BankAccount[3];
      bArray[0] = b1;
      bArray[1] = b2;
      bArray[2] = b3;
      
      for (int i = 0; i < bArray.length; i++)
      {
         System.out.printf("$%.2f \n", bArray[i].getBalance());
      }

      for (int i = 0; i < bArray.length; i++)
      {
         System.out.println(bArray[i].withdraw(100));
      }
      
      for (int i = 0; i < bArray.length; i++)
      {
         System.out.printf("$%.2f \n", bArray[i].getBalance());
      }      
   }
}