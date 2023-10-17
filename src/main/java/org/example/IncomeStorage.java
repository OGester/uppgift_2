package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class IncomeStorage {
    private Map<String, Income> allIncomes;
    //Sträng som representerar platsen/filen jag vill använda
    private String fileName = "src/main/income.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // skapa metod lägg till inkomst
    public void addIncome(Income income) {
        try {
            if (allIncomes != null) {
                allIncomes.put(income.getId(), income);
                System.out.println("Income added");
            }
        } catch (Exception e) {
            System.out.println("null...");
        }
    }


    // Spara till Json fil
    public void saveIncome() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(allIncomes, fw);
        fw.close();
        System.out.println("Saved!");
    }


    //Läs in från Json
    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        allIncomes = gson.fromJson(reader, type);

        System.out.println("Income list: ");
        for (String id : allIncomes.keySet()) {
            System.out.println("Key: " + id);
        }
    }


    //skapa metod för att ta bort inkomst
    public void removeIncome(String id) {
        allIncomes.remove(id);
    }


    // skapa metod lista alla inkomster
    public void printIncomes() {
        System.out.println(" income list: ");
        for (Income income : allIncomes.values()) {
            System.out.println("Income: " + income);
        }
    }


    //metod som loopar igenom alla amounts i allIncomes och räknar ihop dem.
    public double totalIncomes() {
        double sum1 = 0;
        for (Income income : allIncomes.values()) {
            sum1 += income.getAmount();
        }
        //System.out.println(sum1);
        return sum1;
    }

    //skapa metod för att ändra inkomst
    public void changeIncome(Income income) {
        allIncomes.replace(income.getId(), income);
        System.out.println("Income: " + income + " changed");
    }

}






    /*
    public void allIncomes() throws IOException {
        System.out.println("This is all of your incomes:");
        for (int i = 0; i < totalIncomes.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + ": " + totalIncomes.get(i));
        }
    }
 /*
    Den här klassen ska ansvara för att spara till fil,
    läsa in fil, lista alla inkomster, lägga till, uppdatera och ta bort en inkomst
     */
