package com.theironyard.javawithclojure.jhporter;

import java.util.Scanner;

public class Main
{
    public static Scanner input = new Scanner(System.in);

    public boolean isValidCustomer(String name)
    {
        return !name.equals(" ");
    }

    public static void main(String[] args) throws Exception
    {
        //declare variables
        int menuSelection = 0;
        String customerName;
        Teller teller = new Teller();
        Account customer;


        //run teller console
        System.out.println("Welcome to the First National Bank If The Iron Yard!");
        System.out.println("Please Enter Your Name: ");
        customerName = input.nextLine();
        if (customerName.equals(""))
        {
            throw new Exception("Not a valid name!");
        }
        customer = new Account(customerName);


        while (menuSelection != 3)
        {
            menuSelection = teller.displayMainMenu(customer);
            switch(menuSelection)
            {
                case 1:
                    teller.checkBalance(customer);
                    break;
                case 2:
                    teller.withdraw(customer);
                    break;
                case 3:
                    teller.cancel();
                    break;
            }
        }
    }
}
