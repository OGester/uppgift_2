package org.example;

public class TestIncome {
    private double amount;
    private String typeOfIncome;


    public TestIncome() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTypeOfIncome() {
        return typeOfIncome;
    }

    public void setTypeOfIncome(String typeOfIncome) {
        this.typeOfIncome = typeOfIncome;
    }

    @Override
    public String toString() {
        return "TestIncome{" +
                "amount=" + amount +
                ", typeOfIncome='" + typeOfIncome + '\'' +
                '}';
    }
}
