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
        System.out.println("Expenses Saved!");
    }


    //Läs in från Json
    public void readExpenseFile() throws IOException {
        Type type = new TypeToken<Map<String, Expense>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        allExpenses = gson.fromJson(reader, type);

        System.out.println("Expense list is retreived.\n");
        //for (String id : allExpenses.keySet()) {
            //System.out.println("Key: " + id);
        //}
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


    //metod som loopar igenom alla amounts i allIncomes och räknar ihop dem.
    public double calcTotalExpenses() {
        double sum1 = 0;
        for (Expense expense : allExpenses.values()) {
            sum1 += expense.getAmount();
        }
        //System.out.println(sum1);
        return sum1;
    }

    //skapa metod för att ändra inkomst
    public void changeExpense(String id, double amount) {
        Expense expense = allExpenses.get(id);
        expense.setAmount(amount);
        System.out.println("Expense changed!");

    }

    public Map<String, Expense> getAllExpenses() {
        return allExpenses;
    }

    public void setAllIncomes(Map<String, Expense> allIncomes) {
        this.allExpenses = allExpenses;
    }
}


