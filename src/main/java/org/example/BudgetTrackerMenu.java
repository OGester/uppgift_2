package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTrackerMenu {


        private Scanner scan = new Scanner(System.in);
        User logIn = new User();
        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();
        private boolean isRunning = true;

    public BudgetTrackerMenu() throws IOException {
        mainMenu();
    }

    public void mainMenu() throws IOException {
        iStorage.readIncomeFile();
        eStorage.readExpenseFile();

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
                        System.out.println("ADD INCOME\n" +
                                    "--------------------");
                        addIncome();
                        break;

                    case 2:
                        System.out.println("REMOVE INCOME\n" +
                                    "--------------------");
                        removeIncome();
                        break;

                    case 3:
                        System.out.println("CHANGE INCOME\n" +
                                    "--------------------");
                        changeIncome();
                        break;

                    case 4:
                        System.out.println("INCOME LIST\n" +
                                    "-------------------");
                        iStorage.printIncomes();
                        break;

                    case 5:
                        System.out.println("ADD EXPENSE\n" +
                                "--------------------");
                        addExpense();
                        break;

                    case 6:
                        System.out.println("REMOVE EXPENSE\n" +
                                "--------------------");
                        removeExpense();
                        break;

                    case 7:
                        //Skriv om change income till expense och lägg in här
                        System.out.println("CHANGE EXPENSE\n" +
                                "--------------------");
                        changeExpense();

                        break;

                    case 8:
                        System.out.println("EXPENSE LIST\n" +
                                "-------------------");
                        eStorage.printExpenses();
                        break;

                    case 9:
                        //skapa metod för räkna ihop expenses och räkna ut income kontra expense
                        System.out.println("state month and date (month-YYYY):");
                        scan.nextLine();
                        String calcDate = scan.nextLine();
                        // incPerMonth och expPerMonth håller resultatet av metoden för att
                        //kunna använda dem och räkna ut saldo per månad.
                        double incPerMonth = iStorage.calcTotalIncomes(calcDate);
                        double expPerMonth = eStorage.calcTotalExpenses(calcDate);
                        System.out.println("Total incomes for " + calcDate + " is: " + incPerMonth);
                        System.out.println("\nTotal expenses for " + calcDate + " is: " + expPerMonth);
                        System.out.println("\nMoney left in " + calcDate + " after expenses is paid: "
                                            + (incPerMonth - expPerMonth));
                        break;

                    default:
                        System.out.println("Default!");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong!");

            }

    }
    //identiska metoder som lägger till samt sparar income/expense till vardera json fil
    public void addIncome() throws IOException {
        System.out.println("Set Income id number: ");
        scan.nextLine();
        String incomeId = scan.nextLine();
        System.out.println("Please add amount: ");
        double incomeAmount = scan.nextDouble();
        //user ombeds ange datum på specifikt sätt
        // för att lättare kunna söka på inkomster senare.
        System.out.println("Please add date (month-YYYY): ");
        scan.nextLine();
        String incomeDate = scan.nextLine();
        System.out.println("Choose type of income (Salary, Csn or Sales): ");
        EIncomeCategory incomeValue = EIncomeCategory.valueOf(scan.next().toUpperCase());
        Income newIncome = new Income(incomeAmount, incomeDate, incomeValue, incomeId);
        iStorage.addIncome(newIncome);
        iStorage.saveIncome();

    }
    public void addExpense() throws IOException {
        System.out.println("Set Expense id number: ");
        scan.nextLine();
        String expenseId = scan.nextLine();
        System.out.println("Please add amount: ");
        double expenseAmount = scan.nextDouble();
        //user ombeds ange datum på specifikt sätt
        // för att lättare kunna söka på inkomster senare.
        System.out.println("Please add date (month-YYYY): ");
        scan.nextLine();
        String expenseDate = scan.nextLine();
        System.out.println("Choose type of Expense\n " +
                "(Rent, Elecricalbill, Phone, Internet, Food, Insurance, Loan, Misc): ");
        EExpenseCategory expenseValue = EExpenseCategory.valueOf(scan.next().toUpperCase());
        Expense newExpense = new Expense(expenseAmount, expenseDate, expenseValue, expenseId);
        eStorage.addExpense(newExpense);
        eStorage.saveExpense();
    }
    //metoder som låter usern ta bort inkomst/expense genom att ange id på det som skall
    // tas bort. med hjälp av metoder hämtade från Inc- ExpenseStorage klasserna.
    public void removeIncome() throws IOException {
        iStorage.printIncomes();
        System.out.println("Remove income by selecting Key: ");
        scan.nextLine();
        String removeKey = scan.nextLine();
        iStorage.removeIncome(removeKey);
        iStorage.saveIncome();
    }

    public void removeExpense() throws IOException {
        eStorage.printExpenses();
        System.out.println("Remove Expense by selecting Key: ");
        scan.nextLine();
        String removeKey = scan.nextLine();
        eStorage.removeExpense(removeKey);
        eStorage.saveExpense();
    }
//metod med inkluderad switch för user att välja vilka
//ändringar man vill göra på sparde inkomster/ utgifter.
    public void changeIncome() throws IOException {

        System.out.println("What would you like to change?\n" +
                        "[1] Amount\n" +
                        "[2] Date\n" +
                        "[3] Source of income\n");

        int incChange = scan.nextInt();

        switch(incChange){
            case 1:
                iStorage.printIncomes();
                System.out.println("CHANGE AMOUNT-\n" +
                                "Choose Key of income to change:");
                scan.nextLine();
                //har valt att använda key för att specificera vilken inkomst som skall ändras
                //alla tre cases fungerar på samma vis
                String amountKey = scan.nextLine();
                System.out.println("State new amount");
                double amountChange = scan.nextDouble();
                iStorage.changeIncomeAmount(amountKey, amountChange);
                iStorage.saveIncome();
                break;

            case 2:
                iStorage.printIncomes();
                System.out.println("CHANGE DATE-\n" +
                        "Choose Key of income to change");
                scan.nextLine();
                String dateId = scan.nextLine();
                //user ombeds ange datum på specifikt sätt
                // för att lättare kunna söka på inkomster senare.
                System.out.println("State new date (month-YYYY):");
                String changeDate = scan.nextLine();
                iStorage.changeIncomeDate(dateId, changeDate);
                iStorage.saveIncome();
                break;


            case 3:
                iStorage.printIncomes();
                System.out.println("CHANGE CATEGORY-\n" +
                        "Choose Key of income to change");
                scan.nextLine();
                String catId = scan.nextLine();
                System.out.println("State new category - Salary, Csn or Sales:");
                //scanner så att sträng uppfattas som enum genom toUpperCase
                EIncomeCategory catValue = EIncomeCategory.valueOf(scan.next().toUpperCase());
                iStorage.changeIncomeCategory(catId, catValue);
                iStorage.saveIncome();
                break;

            default:
                System.out.println("Default");



        }
    }

    public void changeExpense() throws IOException {

        System.out.println("What would you like to change?\n" +
                "[1] Amount\n" +
                "[2] Date\n" +
                "[3] Expense source\n");

        int expChange = scan.nextInt();

        switch(expChange){
            case 1:
                eStorage.printExpenses();
                System.out.println("CHANGE AMOUNT-\n" +
                        "Choose Key of expense to change:");
                scan.nextLine();
                //har valt att använda key för att specificera vilken expense som skall ändras
                //alla tre cases fungerar på samma vis
                String amountKey = scan.nextLine();
                System.out.println("State new amount");
                double amountChange = scan.nextDouble();
                eStorage.changeExpenseAmount(amountKey, amountChange);
                eStorage.saveExpense();
                break;

            case 2:
                iStorage.printIncomes();
                System.out.println("CHANGE DATE-\n" +
                        "Choose Key of expense to change");
                scan.nextLine();
                String dateId = scan.nextLine();
                //user ombeds ange datum på specifikt sätt
                // för att lättare kunna söka på inkomster senare.
                System.out.println("State new date (month-YYYY):");
                String changeDate = scan.nextLine();
                eStorage.changeExpenseDate(dateId, changeDate);
                eStorage.saveExpense();
                break;

            case 3:
                iStorage.printIncomes();
                System.out.println("CHANGE CATEGORY-\n" +
                        "Choose Key of expense to change");
                scan.nextLine();
                String catId = scan.nextLine();
                System.out.println("State new category - Salary, Csn or Sales:");
                //scanner så att sträng uppfattas som enum genom toUpperCase
                EExpenseCategory catValue = EExpenseCategory.valueOf(scan.next().toUpperCase());
                eStorage.changeExpenseCategory(catId, catValue);
                eStorage.saveExpense();
                break;

            default:
                System.out.println("Default");



        }
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

