package org.example;

import java.io.IOException;
import java.util.Scanner;

public class BudgetTrackerMenu {


        private Scanner scan = new Scanner(System.in);
        User logIn = new User();
        //instansierar incomestorage och expensestorage så vi kommer åt metoderna i dem klasserna.
        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();
        private boolean isRunning = true;

    public BudgetTrackerMenu() throws IOException {
        mainMenu();
    }

    public void mainMenu() throws IOException {
        //metoder som läser in Json filerna och pga type token så behöver det ske först annars kastar
        //det fel när man försöker spara till fil.
        iStorage.readIncomeFile();
        eStorage.readExpenseFile();

        System.out.println(" Welcome to Budget Tracker!\n----------------------------\n" +
                "-Please enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("-Enter your last name: ");
        String lastName = scan.nextLine();
        String hiUser = firstName + " " + lastName;
        //Sparar user i en array för eventuellt framtida utveckling för flera users.
        //i dagsläget fyller det ingen funktion då det bara existerar under runtime.
        User user = new User(firstName, lastName);
        logIn.addUserToArray(user);


        System.out.println("Hi " + hiUser + "\nWhat task would you like to do?\n");

        while (isRunning)

            try {

                System.out.println("--MAIN MENU--\n" +
                        "-------------------------\n" +
                        "[1] Add income\n" +
                        "[2] Remove income\n" +
                        "[3] Change income\n" +
                        "[4] Add expense\n" +
                        "[5] Remove expense\n" +
                        "[6] Change expense\n" +
                        "[7] Budget overview\n" +
                        "\nType exit to quit program.");

                String userChoice = scan.nextLine();

                switch (userChoice) {
                    case "1":
                        System.out.println("ADD INCOME\n" +
                                    "--------------------");
                        addIncome();
                        enterToContinue();
                        break;

                    case "2":
                        System.out.println("REMOVE INCOME\n" +
                                    "--------------------");
                        removeIncome();
                        enterToContinue();
                        break;

                    case "3":
                        System.out.println("CHANGE INCOME\n" +
                                    "--------------------");
                        changeIncome();
                        enterToContinue();
                        break;

                    case "4":
                        System.out.println("ADD EXPENSE\n" +
                                "--------------------");
                        addExpense();
                        enterToContinue();
                        break;

                    case "5":
                        System.out.println("REMOVE EXPENSE\n" +
                                "--------------------");
                        removeExpense();
                        enterToContinue();
                        break;

                    case "6":
                        System.out.println("CHANGE EXPENSE\n" +
                                "--------------------");
                        changeExpense();
                        enterToContinue();
                        break;

                    case "7":
                        System.out.println("BUDGET OVERVIEW\n" +
                                "--------------------");
                        budgetOverview();
                        enterToContinue();
                        break;

                    case "exit":
                        System.exit(0);


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
        String incomeId = scan.nextLine();
        System.out.println("Choose type of income (Salary, Csn or Sales): ");
        EIncomeCategory incomeValue = EIncomeCategory.valueOf(scan.next().toUpperCase());
        System.out.println("Please add amount: ");
        double incomeAmount = scan.nextDouble();
        //user ombeds ange datum på specifikt sätt
        // för att lättare kunna söka på inkomster senare.
        System.out.println("Please add date (month-YYYY): ");
        scan.nextLine();
        String incomeDate = scan.nextLine();

        Income newIncome = new Income(incomeAmount, incomeDate, incomeValue, incomeId);
        iStorage.addIncome(newIncome);
        iStorage.saveIncome();

    }
    public void addExpense() throws IOException {
        System.out.println("Set Expense id number: ");
        String expenseId = scan.nextLine();
        System.out.println("Choose type of Expense\n " +
                "(Rent, Electricbill, Phone, Internet, Food, Insurance, Loan, Misc): ");
        EExpenseCategory expenseValue = EExpenseCategory.valueOf(scan.next().toUpperCase());
        System.out.println("Please add amount: ");
        double expenseAmount = scan.nextDouble();
        //user ombeds ange datum på specifikt sätt
        // för att lättare kunna söka på inkomster senare.
        System.out.println("Please add date (month-YYYY): ");
        scan.nextLine();
        String expenseDate = scan.nextLine();

        Expense newExpense = new Expense(expenseAmount, expenseDate, expenseValue, expenseId);
        eStorage.addExpense(newExpense);
        eStorage.saveExpense();
    }
    //metoder som låter usern ta bort inkomst/expense genom att ange id på det som skall
    // tas bort. med hjälp av metoder hämtade från Inc- ExpenseStorage klasserna.
    public void removeIncome() throws IOException {
        iStorage.printIncomes();
        System.out.println("Remove income by selecting Key: ");
        String removeKey = scan.nextLine();
        iStorage.removeIncome(removeKey);
        iStorage.saveIncome();
    }

    public void removeExpense() throws IOException {
        eStorage.printExpenses();
        System.out.println("Remove Expense by selecting Key: ");
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

        String incChange = scan.nextLine();

        switch(incChange){
            case "1":
                iStorage.printIncomes();
                System.out.println("CHANGE AMOUNT-\n" +
                                "Choose Key of income to change:");
                //har valt att använda key för att specificera vilken inkomst som skall ändras
                //alla tre cases fungerar på samma vis
                String amountKey = scan.nextLine();
                System.out.println("State new amount");
                double amountChange = scan.nextDouble();
                scan.nextLine();
                iStorage.changeIncomeAmount(amountKey, amountChange);
                iStorage.saveIncome();
                break;

            case "2":
                iStorage.printIncomes();
                System.out.println("CHANGE DATE-\n" +
                        "Choose Key of income to change");
                String dateId = scan.nextLine();
                //user ombeds ange datum på specifikt sätt
                // för att lättare kunna söka på inkomster senare.
                System.out.println("State new date (month-YYYY):");
                String changeDate = scan.nextLine();
                iStorage.changeIncomeDate(dateId, changeDate);
                iStorage.saveIncome();
                break;


            case "3":
                iStorage.printIncomes();
                System.out.println("CHANGE CATEGORY-\n" +
                        "Choose Key of income to change");
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

        String expChange = scan.nextLine();

        switch(expChange){
            case "1":
                eStorage.printExpenses();
                System.out.println("CHANGE AMOUNT-\n" +
                        "Choose Key of expense to change:");
                //har valt att använda key för att specificera vilken expense som skall ändras
                //alla tre cases fungerar på samma vis
                String amountKey = scan.nextLine();
                System.out.println("State new amount");
                double amountChange = scan.nextDouble();
                scan.nextLine();
                eStorage.changeExpenseAmount(amountKey, amountChange);
                eStorage.saveExpense();
                break;

            case "2":
                eStorage.printExpenses();
                System.out.println("CHANGE DATE-\n" +
                        "Choose Key of expense to change");
                String dateId = scan.nextLine();
                //user ombeds ange datum på specifikt sätt
                // för att lättare kunna söka på inkomster senare.
                System.out.println("State new date (month-YYYY):");
                String changeDate = scan.nextLine();
                eStorage.changeExpenseDate(dateId, changeDate);
                eStorage.saveExpense();
                break;

            case "3":
                eStorage.printExpenses();
                System.out.println("CHANGE CATEGORY-\n" +
                        "Choose Key of expense to change");
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
    public void budgetOverview(){
        System.out.println("Please select task.\n" +
                "[1] List All incomes by month\n" +
                "[2] List All expenses by month\n" +
                "[3] Search income\n" +
                "[4] Search expense\n" +
                "[5] Monthly budget balance\n");

        //budgetoverview choice
        String bOverviewChoice = scan.nextLine();

        switch (bOverviewChoice){
            case "1":
                System.out.println("Enter date (month-YYYY) you want to list: ");
                String monthlyIncSearch = scan.nextLine();
                iStorage.printMonthlyIncomes(monthlyIncSearch);
                break;

            case "2":
                System.out.println("Enter date (month-YYYY) you want to list: ");
                String monthlyExpSearch = scan.nextLine();
                eStorage.printMonthlyExpenses(monthlyExpSearch);
                break;

            case "3":
                System.out.println("Enter date (month-YYYY) you´re searching for: ");
                String overviewIncDate = scan.nextLine();
                System.out.println("What income are you looking for:\n" +
                        "Salary, CSN or Sales");
                EIncomeCategory incValue = EIncomeCategory.valueOf(scan.next().toUpperCase());
                iStorage.searchIncome(overviewIncDate,incValue);
                break;

            case "4":
                System.out.println("Enter date (month-YYYY) you´re searching for: ");
                String overviewExpDate = scan.nextLine();
                System.out.println("What expense are you looking for:\n" +
                        "Rent, Elecricalbil, Phone, Internet, Food, Insurance, Loan, Misc");
                EExpenseCategory expValue = EExpenseCategory.valueOf(scan.next().toUpperCase());
                eStorage.searchExpense(overviewExpDate,expValue);
                break;

            case "5":
                System.out.println("state month and date (month-YYYY):");
                String calcDate = scan.nextLine();
                // incPerMonth och expPerMonth håller resultatet av metoden för att
                //kunna använda dem och räkna ut saldo per månad.
                double incPerMonth = iStorage.calcTotalIncomes(calcDate);
                double expPerMonth = eStorage.calcTotalExpenses(calcDate);
                iStorage.printMonthlyIncomes(calcDate);
                System.out.println("\nTotal incomes for " + calcDate + " is: " + incPerMonth +
                        ":-\n------------------------------");
                eStorage.printMonthlyExpenses(calcDate);
                System.out.println("\nTotal expenses for " + calcDate + " is: " + expPerMonth +
                        ":-\n------------------------------");
                System.out.println("\nMoney left in " + calcDate + " after expenses is paid: "
                        + (incPerMonth - expPerMonth) +":-\n");
                break;

            default:
                System.out.println("Default");

        }
    }
    public void enterToContinue() {
        try {
            System.out.println("Press ENTER to continue");
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}


















