package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/18/16.
 */
public class Teller
{
    Accounts theAccounts = Accounts.getTheAccounts();

    public String getIdentity()
    {
        String name;
        System.out.println("Please Enter Your Name: ");
        name = Main.input.nextLine();
        return name;
    }

    public int displayMainMenu(String name)
    {
        //declare variables
        String choice;
        int menuItem=0;
        double balance = 100.0;


        while(menuItem < 1 || menuItem > 3)
        {
            System.out.printf("\n%s, how may I help you today?(please pick and option from the list below)", name);
            System.out.printf("\n 1.Check Balance\n 2.Withdraw Funds\n 3.Cancel\n");
            choice = Main.input.nextLine();
            menuItem = Integer.valueOf(choice);
            if (menuItem < 1 || menuItem > 3)
            {
                System.err.printf("\nNot a valid choice!!!! Try again!!!");
            }
        }
        return menuItem;
    }

    public void checkBalance(String name)
    {
        System.out.printf("\n%s, your current balance is $%.2f.", name, theAccounts.getBalance(name));
    }

    public void withdraw(String name)
    {
        //declare variables
        String amount;
        double amountToWithdraw = -1.0;

        while(amountToWithdraw >=0 && amountToWithdraw > theAccounts.getBalance(name))
        System.out.println("How much would you like to withdraw?");
        amount = Main.input.nextLine();
        amountToWithdraw = Double.valueOf(amount);

        if (amountToWithdraw > theAccounts.getBalance(name))
        {
            System.err.printf("\nInsufficient Funds!!!!");
        }
        else if (amountToWithdraw <= theAccounts.getBalance(name))
        {
            theAccounts.withdraw(name, amountToWithdraw);
            System.out.printf("\n%s, Amount Withdrawn: $%.2f\nRemaining Balance: $%.2f.", name, amountToWithdraw, theAccounts.getBalance(name));
        }
        else
        {
            System.err.printf("\nNot an amount.  Try again!");
        }

    }

    public void cancel()
    {
        System.out.println("Thank you and please come again!");
    }

    public boolean validateDeposit(String amount)
    {
        return (Integer.valueOf(amount)>=0);
    }


}
