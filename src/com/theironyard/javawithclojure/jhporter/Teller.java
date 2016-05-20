package com.theironyard.javawithclojure.jhporter;



/**
 * Created by jeffryporter on 5/18/16.
 */
public class Teller
{
    Accounts theAccounts = Accounts.getTheAccounts();

    public String getIdentity()
    {
        String customerName;
        boolean validAmount = false;
        double amount=0.0;
        System.out.printf("\nPlease Enter Your Name(type %s to exit): ", Main.EXIT_STRING);
        customerName = Main.input.nextLine();

        if(customerName.equalsIgnoreCase(Main.EXIT_STRING))
        {
            return customerName;
        }
        else if (theAccounts.validateAccount(customerName))
        {
            System.out.printf("\nWelcome back %s.", customerName);
            //System.out.println(!theAccounts.validateAccount(customerName));
        }
        else if (!theAccounts.validateAccount(customerName))
        {
            while(!validAmount) {
                System.out.printf("\nYou don't seem to have an account.");
                System.out.printf("\nHow much would you like to deposit initially?");
                String temp = Main.input.nextLine();
                if (!temp.isEmpty() && validateDeposit(temp)) {
                    amount = Double.valueOf(temp);
                    theAccounts.createAccount(customerName, amount);
                    validAmount = true;
                } else {
                    System.out.printf("\nNot a valid amount!");
                }
            }
        }
        return customerName;
    }

    public int displayMainMenu(String name)
    {
        //declare variables
        String choice;
        int menuItem=0;
        double balance = 100.0;

        while(menuItem < 1 || menuItem > 4)
        {
            System.out.printf("\n%s, how may I help you today?(please pick and option from the list below)", name);
            System.out.printf("\n 1.Check Balance\n 2.Withdraw Funds\n 3.Close Account\n 4.Cancel\n");
            choice = Main.input.nextLine();
            if (choice.matches("[0-9]+"))
            {
                menuItem = Integer.valueOf(choice);

                if (menuItem < 1 || menuItem > 4)
                {
                    System.out.printf("\nNot a valid choice!!!! Try again!!!");
                }
            }
            else
            {
                System.out.printf("\nNot a valid choice!!!! Try again!!!");
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
        double amountToWithdraw = 1.0;

        while(amountToWithdraw >=0 && amountToWithdraw < theAccounts.getBalance(name))
        {
            System.out.printf("\nHow much would you like to withdraw?");
            amount = Main.input.nextLine();
            amountToWithdraw = Double.valueOf(amount);

            if (amountToWithdraw > theAccounts.getBalance(name))
            {
                System.out.printf("\nInsufficient Funds!!!!");
            }
            else if (amountToWithdraw <= theAccounts.getBalance(name))
            {
                theAccounts.withdraw(name, amountToWithdraw);
                System.out.printf("\n%s, Amount Withdrawn: $%.2f\nRemaining Balance: $%.2f.\n", name, amountToWithdraw, theAccounts.getBalance(name));
                amountToWithdraw = -1.0;
            }
            else
            {
                System.out.printf("\nNot an amount. Try again!");
            }
        }
    }

    public void closeAccount(String name)
    {
        double closingBalance = theAccounts.removeAccount(name);
        System.out.printf("\nSorry to lose your business.");
        System.out.printf("\nHere's the closing balance of $%.2f.", closingBalance);
    }

    public void cancel()
    {
        System.out.printf("\nThank you and please come again!");
    }

    public boolean validateDeposit(String amount)
    {
        boolean isValid = false;
        if (amount.matches("[0-9.]+"))
        {
            isValid = true;
        }
        return isValid;
    }


}
