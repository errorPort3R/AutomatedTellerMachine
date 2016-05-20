package com.theironyard.javawithclojure.jhporter;

import java.util.Scanner;

public class Main
{
    public static Scanner input = new Scanner(System.in);
    public static final String EXIT_STRING = "quit";

    public static boolean isValidCustomer(String name)
    {
        return !name.equalsIgnoreCase(EXIT_STRING);
    }

    public static void main(String[] args)
    {
        //declare variables
        double amount=0;
        String customerName= "";
        Teller teller = new Teller();

        //run teller console
        System.out.println("Welcome to the First National Bank of The Iron Yard!");

        int menuSelection=0;
        while (isValidCustomer(customerName))
        {
            customerName = teller.getIdentity();
            if (isValidCustomer(customerName))
            {
                while(menuSelection != 3 || menuSelection != 4)
                {
                    menuSelection = 0;
                    menuSelection = teller.displayMainMenu(customerName);
                    switch (menuSelection)
                    {
                        case 1:
                            teller.checkBalance(customerName);
                            break;
                        case 2:
                            teller.withdraw(customerName);
                            break;
                        case 3:
                            teller.closeAccount(customerName);
                            teller.cancel();
                            break;
                        case 4:
                            teller.cancel();
                            break;
                        default:
                            System.err.printf("\nNot a valid selection!");
                            break;
                    }
                }
            }

        }
        System.out.println("Teller shutting down.");
    }
}
