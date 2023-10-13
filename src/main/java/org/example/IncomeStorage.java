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


    public void addIncome(Income income) {
       try {
                     if (allIncomes != null) {
                         allIncomes.put(income.getName(), income);
                         System.out.println("Income added");
                     }
       } catch (Exception e) {
           System.out.println("null...");
       }
    }
    // skapa metod lägg till inkomst
    public void saveIncome() throws IOException {
        //allIncomes.put(income.getName(), income);
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(allIncomes, fw);
        fw.close();
        System.out.println("Saved!");

    }
    //Läs in från Json
    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, Income>>(){}.getType();
        Reader reader = new FileReader(new File(fileName));
        allIncomes = gson.fromJson(reader, type);

        System.out.println("Income list: ");
        for(String name : allIncomes.keySet()) {
            System.out.println("Key: " + name);
        }

    }

    // Spara till Json fil
    //public void saveIncome (Income)




    // skapa metod lista alla inkomster


    //skapa metod för att uppdatera inkomst


    //skapa metod för att ta bort inkomst







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
