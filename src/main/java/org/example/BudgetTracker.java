package org.example;

import java.io.IOException;

public class BudgetTracker {
    public static void main(String[] args) throws IOException {

        Income inc1 = new Income(15000, "25/4", EIncomeCategory.SALARY);
        Income inc2 = new Income( 2354, "23/4", EIncomeCategory.CSN);
        IncomeStorage iStorage = new IncomeStorage();

        iStorage.addIncomeToArray(inc1);
        iStorage.addIncomeToArray(inc2);
        iStorage.saveIncomeToFile();
        iStorage.allIncomes();





    }
}
  /*
    I klassen budgetTracker ska du ha din main-metod. Det är alltså den här klassen som skall starta din budget app.
    det är oxå här du skall ha din scanner. När du startar din app ska den läsa in eventuella
    filer om det finns några. Varje Expense och Income ska oxå sparas till fil genom sin
    storage klass. se till att detta verkligen görs innan du avslutar ditt program.
     */