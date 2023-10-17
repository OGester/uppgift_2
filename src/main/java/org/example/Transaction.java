package org.example;

public class Transaction {

    private double amount;
    private String date;

    public Transaction(double amount, String date) {

        this.amount = amount;
        this.date = date;
    }

    public Transaction() {
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

    @Override
    public String toString() {
        return "amount: "
                + amount +
                ":- , date: " + date;
    }





    /*
    Den här klassen skall Income och Expense ärva ifrån. Klassen transaction ska innehålla minst följande fält
    * amount - double eller float, skall representera summa för inkomst/utgift
    *date - ska representera datum som inkomsten eller utgiften görs
    */
}
