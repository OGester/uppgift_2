package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class ExpenseStorage {
    private Map<String, Expense> allExpenses;
    //Sträng som representerar platsen/filen jag vill använda
    private String fileName = "src/main/expense.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // skapa metod lägg till inkomst
    public void addExpense(Expense expense) {
        allExpenses.put(expense.getId(), expense);
        System.out.println("You added -> " + expense + " <- to your Expenses.");
    }


    // Spara till Json fil
    public void saveExpense() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(allExpenses, fw);
        fw.close();
        System.out.println("--Changes has been saved--\n");
    }


    //Läs in från Json
    public void readExpenseFile() throws IOException {
        Type type = new TypeToken<Map<String, Expense>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        allExpenses = gson.fromJson(reader, type);

        System.out.println("Expense list is retreived.\n");
    }


    //skapa metod för att ta bort inkomst
    public void removeExpense(String id) {
        allExpenses.remove(id);
    }


    // skapa metod lista alla inkomster
    public void printExpenses() {
        System.out.println("Expense list: ");
        for (Expense expense : allExpenses.values()) {
            System.out.println(expense);
        }
    }
    //tar user input för att kunna lista utgifter månadsvis, loopar igenom Mappen och söker efter angivet datum
    public void printMonthlyExpenses(String monthlyExpSearh){
        System.out.println("Your expenses for " + monthlyExpSearh + ":");
        for (Expense expense : allExpenses.values()) {
            if (monthlyExpSearh.equals(expense.getDate())) {
                System.out.println(expense); }
        }
    }


    //metod som loopar igenom alla amounts i allExpenses och kollar efter expenses
    //som matchar input baserat på datum och räknar ihop dem.
    public double calcTotalExpenses(String calcDate) {
        double expSum = 0;
        for (Expense expense : allExpenses.values()) {
            if (calcDate.equals(expense.getDate())) {
                expSum += expense.getAmount();
            }
        }
        return expSum;
    }
    //sökmetod för att hitta specifik utgift
    //overDate (OverviewDate) = user input för sökdatum
    public void searchExpense (String overDate, EExpenseCategory category) {
        for (Expense expense : allExpenses.values()) {
            if (overDate.equals(expense.getDate()) && category.equals(expense.getCategory())) {
                System.out.println(category + " was Found:\n" + expense);
            } else {
                System.out.println("Sorry no match was found!");
            }
        }
    }

    //metoder för att ändra inkomst
    public void changeExpenseAmount(String id, double amount) {
        Expense expense = allExpenses.get(id);
        expense.setAmount(amount);
        System.out.println("Expense amount changed!");

    }

    public void changeExpenseDate(String dateKey, String date) {
        Expense expense = allExpenses.get(dateKey);
        expense.setDate(date);
        System.out.println("Expense date changed");
    }

    public void changeExpenseCategory(String catKey, EExpenseCategory category) {
        Expense expense = allExpenses.get(catKey);
        expense.setCategory(category);
        System.out.println("Expense category changed");
    }

    public Map<String, Expense> getAllExpenses() {
        return allExpenses;
    }

    public void setAllIncomes(Map<String, Expense> allIncomes) {
        this.allExpenses = allExpenses;
    }
}


