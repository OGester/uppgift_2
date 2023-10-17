package org.example;

public class Expense extends Transaction {

    private EExpenseCategory category;
    private String id;

    public Expense() {
    }

    public Expense(double amount, String date, EExpenseCategory category, String id) {
        super(amount, date);
        this.category = category;
        this.id = id;
    }

    public EExpenseCategory getCategory() {
        return category;
    }


    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public void setCategory(EExpenseCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction id: " + id +
                ", Type: " + category + "- " + super.toString();
    }


}
