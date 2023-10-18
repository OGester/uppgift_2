package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTrackerMenu {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();

        //iStorage.readFile();

       // Income income1 = new Income(200, "2/4/23", EIncomeCategory.CSN);
        //Income income2 = new Income(300, "4/4/23", EIncomeCategory.SALARY);

        //TestIncome income = new TestIncome();
       // income.setTypeOfIncome("Test");
        // income.setAmount(200);
        iStorage.readIncomeFile();
        eStorage.readExpenseFile();



        Income incomeTest = new Income(1800, "juni-2023", EIncomeCategory.SALARY, "12345");
        Expense expenseTest = new Expense(500,"juni-2023", EExpenseCategory.INSURANCE, "432" );

        //iStorage.addIncome(incomeTest);
        //iStorage.saveIncome();
        //iStorage.printIncomes();
        //iStorage.removeIncome("123");
        //iStorage.printIncomes();
        //iStorage.calcTotalIncomes();

        eStorage.addExpense(expenseTest);
        //eStorage.saveExpense();
        eStorage.printExpenses();



        //iStorage.changeIncome("123", 100);
        //iStorage.changeIncome("123", incomeTest);
        //iStorage.saveIncome();
        //iStorage.printIncomes();







    }

}












                /*
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Gson gson2 = new Gson();
        //FileWriter fw = new FileWriter("src/main/income.json");
        Income[] incomes = null;


        Scanner input = new Scanner(System.in);
        IncomeStorage iStorage = new IncomeStorage();
        User logIn = new User();
        boolean isRunning = true;

        try {
            FileReader fr = new FileReader("src/main/income.json");
            incomes = gson2.fromJson(fr, Income[].class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        FileWriter fw = new FileWriter("src/main/income.json");




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

        System.out.println("[1] Incomes\n[2] Expences");
        int incomOrExpence = input.nextInt();

        switch (incomOrExpence) {
            case 1:

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

                 */





        /*
        public void saveIncomeToFile(){
            gson.toJson(iStorage.totalIncomes, fw);
            fw.close();
        }

         */
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

