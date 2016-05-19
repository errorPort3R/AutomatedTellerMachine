package com.theironyard.javawithclojure.jhporter;

import java.util.Scanner;

public class Main
{
    public static Scanner input = new Scanner(System.in);

    public boolean isValidCustomer(String name)
    {
        return !name.equals(" ");
    }

    public static void main(String[] args)
    {
        //declare variables
        String EXIT_STRING = "quit";
        double amount=0;
        int menuSelection = 0;
        String customerName= "";
        Teller teller = new Teller();
        Accounts theAccounts = Accounts.getTheAccounts();


        //run teller console
        System.out.println("Welcome to the First National Bank of The Iron Yard!");

        while (!customerName.equalsIgnoreCase("quit"))
        {
            System.out.println("Please Enter Your Name(type quit to exit): ");
            customerName = input.nextLine();

            if (customerName.equalsIgnoreCase("quit"))
            {
                break;
            }
            else if (!theAccounts.validateAccount(customerName));
            {
                System.out.println("How Much would you like to deposit initially?");
                String temp = input.nextLine();
                if (teller.validateDeposit(temp))
                {
                    amount = Integer.valueOf(temp);
                }

                theAccounts.createAccount(customerName, amount);
            }
            while (menuSelection != 3) {
                menuSelection = teller.displayMainMenu(customerName);
                switch (menuSelection) {
                    case 1:
                        teller.checkBalance(customerName);
                        break;
                    case 2:
                        teller.withdraw(customerName);
                        break;
                    case 3:
                        teller.cancel();
                        break;
                    default:
                        System.err.printf("\nNot a valid selection!");
                }
            }
        }

    }
}
