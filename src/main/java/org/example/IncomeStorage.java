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
        allIncomes.put(income.getId(), income);
        System.out.println("You added -> " + income + " <- to your Incomes.");
    }


    // Spara till Json fil
    public void saveIncome() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(allIncomes, fw);
        fw.close();
        System.out.println("Saved!");
    }


    //Läs in från Json
    public void readIncomeFile() throws IOException {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        allIncomes = gson.fromJson(reader, type);

        System.out.println("Income list is retrieved.\n");
        //for (String id : allIncomes.keySet()) {
            //System.out.println("Key: " + id);
        //}
    }


    //skapa metod för att ta bort inkomst
    public void removeIncome(String id) {
        allIncomes.remove(id);
        System.out.println("Income removed");
    }


    // skapa metod lista alla inkomster
    public void printIncomes() {
        System.out.println("Income list: ");
        for (Income income : allIncomes.values()) {
            System.out.println(income);
        }
    }


    //metod som loopar igenom alla amounts i allIncomes och räknar ihop dem.
    public double calcTotalIncomes() {
        double sum1 = 0;
        for (Income income : allIncomes.values()) {
            sum1 += income.getAmount();
        }
        //System.out.println(sum1);
        return sum1;
    }

    //skapa metoder för att ändra inkomst
   public void changeIncomeAmount(String id, double amount) {
       Income income = allIncomes.get(id);
       income.setAmount(amount);
       System.out.println("Income amount changed");
    }

    public void changeIncomeDate(String id, String date) {
        Income income = allIncomes.get(date);
        income.setDate(date);
        System.out.println("Income date changed");
    }

    public void changeIncomeCategory(String id, EIncomeCategory category) {
        Income income = allIncomes.get(category);
        income.setCategory(category);
        System.out.println("Income category changed");
    }

    public void changeIncomeId(String id, String id2) {
        Income income = allIncomes.get(id);
        income.setId(id2);
    }

    public Map<String, Income> getAllIncomes() {
        return allIncomes;
    }

    public void setAllIncomes(Map<String, Income> allIncomes) {
        this.allIncomes = allIncomes;
    }
}








