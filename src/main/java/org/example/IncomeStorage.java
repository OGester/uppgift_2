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
        System.out.println("--Changes has been saved--\n");
    }


    //Läs in från Json
    public void readIncomeFile() throws IOException {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        allIncomes = gson.fromJson(reader, type);

        System.out.println("Income list is retrieved.");
        //for (String id : allIncomes.keySet()) {
            //System.out.println("Key: " + id);}

    }


    //skapa metod för att ta bort inkomst
    public void removeIncome(String removeKey) {
        allIncomes.remove(removeKey);
        System.out.println("Income removed");
    }

    // For each loop som listar både Key och värdena knutna till den.
    public void printIncomes() {
        System.out.println("These are all saved incomes: ");
        allIncomes.forEach((key, value) -> System.out.println("Key: " +key + " -> " + value));
        }

    //tar user input för att kunna lista inkomster månadsvis, loopar igenom Mappen och söker efter angivet datum
    public void printMonthlyIncomes(String monthlyIncSearh) {
        boolean found = false;
        System.out.println(monthlyIncSearh + " Incomes:");
        for (Income income : allIncomes.values()) {
            if (monthlyIncSearh.equals(income.getDate())) {
                System.out.println(income);
                found = true;
                }
            //om sökdatum ej hittas printas detta i konsollen
            //lagd utanför loopen för att inte upprepas för varje objekt i Mappen.
            }if (!found) {
            System.out.println("not found");
        }
        }



    //metod som loopar igenom alla amounts i allIncomes och kollar efter incomes
    //som matchar input baserat på datum och räknar ihop dem.
    public double calcTotalIncomes(String calcDate) {
        double incSum = 0;
        boolean found = false;
        for (Income income : allIncomes.values()) {
            if (calcDate.equals(income.getDate())) {
                incSum += income.getAmount();
                found = true;
            }
        }if (!found) {
            System.out.println("No matching incomes found.");
        }
        return incSum;
    }

    //sökmetod för att hitta specifik inkomst
    //overDate = user input för sökdatum
    public void searchIncome (String overDate, EIncomeCategory category) {
        boolean found = false;
        for (Income income : allIncomes.values()) {
            if (overDate.equals(income.getDate()) && category.equals(income.getCategory())) {
                System.out.println(category + " was Found:\n" + income);
            found = true;}
        } if (!found) {
            System.out.println("No matching incomes found.");
        }
    }

    //metoder för att ändra inkomst
   public void changeIncomeAmount(String amountKey, double amount) {
       Income income = allIncomes.get(amountKey);
       income.setAmount(amount);
       System.out.println("Income amount changed");
    }

    public void changeIncomeDate(String dateKey, String date) {
        Income income = allIncomes.get(dateKey);
        income.setDate(date);
        System.out.println("Income date changed");
    }

    public void changeIncomeCategory(String catKey, EIncomeCategory category) {
        Income income = allIncomes.get(catKey);
        income.setCategory(category);
        System.out.println("Income category changed");
    }


    public Map<String, Income> getAllIncomes() {
        return allIncomes;
    }

    public void setAllIncomes(Map<String, Income> allIncomes) {
        this.allIncomes = allIncomes;
    }
}








