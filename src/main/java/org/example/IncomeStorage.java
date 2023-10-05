package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncomeStorage {
    Gson gson = new Gson();

    FileWriter fw = new FileWriter ("src/main/income.json");

    private List<Transaction> allIncomes;

    public IncomeStorage() throws IOException {
        allIncomes = new ArrayList<>();
    }
    // skapa metod lägg till inkomst i en array
    public void addIncomeToArray(Transaction transaction) {
        allIncomes.add(transaction);
        System.out.println("Succesfully added new income: "
        + transaction.getDescription() + " " + transaction.getAmount() + ":-");
    }

    // skapa metod lista alla inkomster
    public void allIncomes() {
        System.out.println("This is all of your incomes:");
        for (Transaction transaction : allIncomes) {
            System.out.println(transaction.toString());
        }
    }

    //skapa metod för att uppdatera inkomst

    //skapa metod för att ta bort inkomst
    public void removeIncome(int index){
        allIncomes.remove(index -1);
        System.out.println("you removed: "); // lägg till info om borttagen inkomst
    }

    // läs in till fil




}
 /*
    Den här klassen ska ansvara för att spara till fil,
    läsa in fil, lista alla inkomster, lägga till, uppdatera och ta bort en inkomst
     */
