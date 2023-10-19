package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTrackerMenu {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        User logIn = new User();
        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();

        iStorage.readIncomeFile();
        eStorage.readExpenseFile();
        boolean isRunning = true;

        System.out.println(" Welcome to Budget Tracker!\n----------------------------\n" +
                "-Please enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("- enter your last name: ");
        String lastName = scan.nextLine();
        String hiUser = firstName + " " + lastName;
        //Sparar user i en array för eventuellt framtida utveckling för flera users.
        User user = new User(firstName, lastName);
        logIn.addUserToArray(user);


        System.out.println("Hi " + hiUser + "\nWhat task would you like to do?");

        while (isRunning)

            try {

                System.out.println("--MAIN MENU--\n" +
                        "-------------------------\n" +
                        "[1] Add income\n" +
                        "[2] Remove income\n" +
                        "[3] Change income\n" +
                        "[4] List all incomes\n" +
                        "[5] Add expense\n" +
                        "[6] Remove expense\n" +
                        "[7] Change expense\n" +
                        "[8] List all expenses\n" +
                        "[9] Budget overview Income vs. Expenses");

                int userChoice = scan.nextInt();

                switch (userChoice) {
                    case 1:
                        addIncome();


                }
            } catch (Exception e) {
                System.out.println("Something went wrong!");

            }

    }

    public static void addIncome() {
        System.out.println("Set Income id number: ");
        scan.nextLine();
        String incomeId = scan.nextLine();
        System.out.println("Please add amount: ");
        double incomeAmount = scan.nextDouble();
        System.out.println("Please add date (MM/DD//YY): ");
        scan.nextLine();
        String incomeDate = scan.nextLine();
        System.out.println("Choose type of income (Salary, Csn or Sales): ");
        EIncomeCategory incomeValue = EIncomeCategory.valueOf(scan.next().toUpperCase());
        Income newIncome = new Income(incomeAmount, incomeDate, incomeValue, incomeId);
        iStorage.addIncome(newIncome);
        iStorage.saveIncome();

    }
}
















/*




                /*
                System.out.println("Select income to change");
                iStorage.allIncomes();
                int change = input.nextInt();
                System.out.println("You choose " + iStorage.totalIncomes.get(change - 1));
                System.out.println("State your changes below.\nNew amount: ");
                double newAmount = input.nextDouble();
                System.out.println("New date (D/M/Y):");
                input.nextLine();
                String newDate = input.nextLine();
                System.out.println("New type of income:");
                //String newValue = input.nextLine();
                EIncomeCategory newValue = EIncomeCategory.valueOf(input.next().toUpperCase());
                Income income = new Income(newAmount, newDate, newValue);

                iStorage.updateIncome(change, income);



                 System.out.println("Please add amount: ");
                double amount = input.nextDouble();
                System.out.println("Please add date: ");
                input.nextLine();
                String date = input.nextLine();
                System.out.println("Choose type of income: ");
                EIncomeCategory value = EIncomeCategory.valueOf(input.next().toUpperCase());
                Income newIncome = new Income(amount, date, value);
                iStorage.addIncomeToArray(newIncome);
                gson.toJson(iStorage.totalIncomes, fw);
                fw.close();
                System.out.println("Incomes :");
                for (Income income : incomes) {
                    System.out.println(income.toString());
 */





/*
Income incomeTest = new Income(1800, "juni-2023", EIncomeCategory.SALARY, "12345");
        Expense expenseTest = new Expense(500,"juni-2023", EExpenseCategory.INSURANCE, "432" );

        iStorage.addIncome(incomeTest);
        iStorage.saveIncome();
        iStorage.printIncomes();
        iStorage.removeIncome("123");
        iStorage.saveIncome();
        iStorage.printIncomes();
        iStorage.calcTotalIncomes();

        eStorage.addExpense(expenseTest);
        eStorage.saveExpense();
        eStorage.printExpenses();




        iStorage.saveIncome();
        iStorage.printIncomes();


     //iStorage.readFile();

       // Income income1 = new Income(200, "2/4/23", EIncomeCategory.CSN);
        //Income income2 = new Income(300, "4/4/23", EIncomeCategory.SALARY);

        //TestIncome income = new TestIncome();
       // income.setTypeOfIncome("Test");
        // income.setAmount(200);



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

