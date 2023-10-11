package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTracker {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        IncomeStorage iStorage = new IncomeStorage();
        User logIn = new User();
        boolean isRunning = true;

        System.out.println(" Welcome to Budget Tracker!\n----------------------------\n" +
                "-Please enter your first name: ");
        String firstName = input.nextLine();
        System.out.println("- enter your last name: ");
        String lastName = input.nextLine();
        String hiUser = firstName + " " + lastName;
        //Sparar user i en array för eventuellt framtida utveckling för flera users.
        User user = new User(firstName, lastName);
        logIn.addUserToArray(user);

        System.out.println("Hi " + hiUser + "\nWhat task would you like to do?");





    }




}






  /*
    System.out.println("Please add amount: ");
    double amount = input.nextDouble();
    System.out.println("Please add date: ");
    input.nextLine();
    String date = input.nextLine();
    System.out.println("Choose type of income: ");
    EIncomeCategory value = EIncomeCategory.valueOf(input.next().toUpperCase());
    Income newIncome = new Income(amount, date, value);
    iStorage.addIncomeToArray(newIncome);
    //iStorage.saveIncomeToFile();
     */