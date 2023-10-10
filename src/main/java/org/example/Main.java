package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IncomeStorage inc = new IncomeStorage();
        Transaction transactionOne = new Transaction(15000, "25/1");
        Transaction transactionTwo = new Transaction( 12673, "23/1");

        inc.addIncomeToArray(transactionOne);
        inc.addIncomeToArray(transactionTwo);
        inc.allIncomes();


    }
}