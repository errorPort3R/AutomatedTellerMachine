package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/18/16.
 */
public class Account
{
    //declare variables
    private String name;
    private double balance;

    //constructor
    public Account(String name)
    {
        this.name = name;
        balance = 100;
    }

    //methods
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
