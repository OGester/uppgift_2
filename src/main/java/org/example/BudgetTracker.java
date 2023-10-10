package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTracker {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        IncomeStorage iStorage = new IncomeStorage();
        boolean isRunning = true;

       // while (isRunning) {
            System.out.println("BUDGET TRACKER MENU");
            System.out.println("[1] - Incomes.");
            System.out.println("[2] - Expences");
            try {
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Please add amount: ");
                        double amount = input.nextDouble();
                        System.out.println("Please add date: ");
                        input.nextLine();
                        String date = input.nextLine();
                        System.out.println("Choose type of income: ");
                        EIncomeCategory value = EIncomeCategory.valueOf(input.next().toUpperCase());
                        Income newIncome = new Income(amount, date, value);
                        iStorage.addIncomeToArray(newIncome);
                        iStorage.saveIncomeToFile();
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Invalid input. Try again");
                }
            } catch (Exception e) {
                System.out.println("fel");
            }


       // }
    }




}




//Income inc1 = new Income(15000, "25/4", EIncomeCategory.SALARY);
//Income inc2 = new Income(2354, "23/4", EIncomeCategory.CSN);
//IncomeStorage iStorage = new IncomeStorage();

// iStorage.addIncomeToArray(inc1);
//iStorage.addIncomeToArray(inc2);
//iStorage.saveIncomeToFile();
//iStorage.allIncomes();

  /*
    I klassen budgetTracker ska du ha din main-metod. Det är alltså den här klassen som skall starta din budget app.
    det är oxå här du skall ha din scanner. När du startar din app ska den läsa in eventuella
    filer om det finns några. Varje Expense och Income ska oxå sparas till fil genom sin
    storage klass. se till att detta verkligen görs innan du avslutar ditt program.
     */