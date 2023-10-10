package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncomeStorage {
    Gson gson = new Gson();

    FileWriter fw = new FileWriter ("src/main/income.json");

    private List<Transaction> totalIncomes;

    public IncomeStorage() throws IOException {
        totalIncomes = new ArrayList<>();
    }
    // skapa metod lägg till inkomst i en array
    public void addIncomeToArray(Income income) {
        totalIncomes.add(income);
        System.out.println(income);

    }


    // skapa metod lista alla inkomster
    public void allIncomes() throws IOException {
        System.out.println("This is all of your incomes:");
            for (int i = 0; i < totalIncomes.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + ": " + totalIncomes.get(i));

        }

    }

    //skapa metod för att uppdatera inkomst
    public void updateIncome(int input) {

    }

    //skapa metod för att ta bort inkomst
    public void removeIncome(int input){
        totalIncomes.remove(input -1);
        System.out.println("you removed: " + totalIncomes.get(input -1));
    }

    // läs in till fil
    public void saveIncomeToFile() throws IOException {
        gson.toJson(totalIncomes, fw);
        fw.close();
    }




}
 /*
    Den här klassen ska ansvara för att spara till fil,
    läsa in fil, lista alla inkomster, lägga till, uppdatera och ta bort en inkomst
     */
