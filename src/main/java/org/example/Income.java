package org.example;

public class Income extends Transaction {


    private EIncomeCategory category;

    public Income(double amount, String date, EIncomeCategory category) {
        super(amount, date);
        this.category = category;

    }
    public EIncomeCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Income - " + category + " -" + super.toString();
    }





    /*
    Denna klass skall ärva Transaction och skall minst ha följande fält:
    * category- ska vara ett Enum med kategorier för inkomster. = EIncomeCategory

     */
}
