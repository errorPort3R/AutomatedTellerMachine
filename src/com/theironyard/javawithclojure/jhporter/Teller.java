package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/18/16.
 */
public class Teller
{
    Account customer;

    public String getIdentity()
    {
        String name;
        System.out.println("Please Enter Your Name: ");
        name = Main.input.nextLine();
        return name;
    }

    public int displayMainMenu(Account customer) throws Exception
    {
        //declare variables
        String choice;
        int menuItem=0;
        double balance = 100.0;
        this.customer = customer;

        while(menuItem < 1 || menuItem > 3)
        {
            System.out.printf("\n%s, how may I help you today?(please pick and option from the list below)", customer.getName());
            System.out.printf("\n 1.Check Balance\n 2.Withdraw Funds\n 3.Cancel\n");
            choice = Main.input.nextLine();
            menuItem = Integer.valueOf(choice);
            if (menuItem < 1 || menuItem > 3)
            {
                throw new Exception("Not a valid choice!!!! Try again!!!");
            }
        }
        return menuItem;
    }

    public void checkBalance()
    {
        System.out.printf("\n%s, your current balance is $%.2f.", customer.getName(), customer.getBalance());
    }

    public void withdraw() throws Exception
    {
        String amount;
        double amountToWithdraw = 0;
        System.out.println("How much would you like to withdraw?");
        amount = Main.input.nextLine();
        amountToWithdraw = Double.valueOf(amount);
        //amountToWithdraw = Main.input.nextDouble();
        if (amountToWithdraw>customer.getBalance())
        {
            throw new Exception("Insufficient Funds!!!!");
        }
        else if (amountToWithdraw <= customer.getBalance())
        {
            customer.setBalance(customer.getBalance() - amountToWithdraw);
            System.out.printf("\n%s, Amount Withdrawn: $%.2f\nRemaining Balance: $%.2f.", customer.getName(), amountToWithdraw, customer.getBalance());
        }
        else
        {
            throw new Exception("Not an amount.  Try again");
        }

    }

    public void cancel()
    {
        System.out.println("Thank you for and please come again!");
    }

}
