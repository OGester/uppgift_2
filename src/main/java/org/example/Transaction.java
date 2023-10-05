package org.example;

public class Transaction {
    private String description;
    private double amount;
    private String date;

    public Transaction(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "income: " + description +
                ", " + amount +
                ":-, added: " + date;
    }



    /*
    Den här klassen skall Income och Expense ärva ifrån. Klassen transaction ska innehålla minst följande fält
    * amount - double eller float, skall representera summa för inkomst/utgift
    *date - ska representera datum som inkomsten eller utgiften görs
    */
}
