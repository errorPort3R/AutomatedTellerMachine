package com.theironyard.javawithclojure.jhporter;

import java.util.HashMap;

/**
 * Created by jeffryporter on 5/19/16.
 */
public class Accounts
{
    //declare variables
    public static Accounts theAccounts;
    private HashMap<String, Double> account = new HashMap<String, Double>();

    //constructor
    private Accounts()
    {
    }

    //methods
    public static Accounts getTheAccounts()
    {
        if (theAccounts == null)
        {
            theAccounts = new Accounts();
        }
        return theAccounts;
    }

    public boolean validateAccount(String name)
    {
        return account.containsKey(name);
    }

    public void createAccount(String name, Double openingDeposit)
    {
        account.put(name, openingDeposit);
    }

    public double removeAccount(String name)
    {
        double balanceRemaining = account.get(name);
        account.remove(name);
        return balanceRemaining;
    }

    public void deposit(String name, double amountToDeposit)
    {
        double balance =  account.get(name)+amountToDeposit;
        account.replace(name, balance);
    }

    public double getBalance(String name)
    {
        return account.get(name);
    }

    public void withdraw(String name, double amountToWithdraw)
    {
        deposit(name, (amountToWithdraw * -1));
    }
}
