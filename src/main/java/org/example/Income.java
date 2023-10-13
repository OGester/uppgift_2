package org.example;

public class Income extends Transaction {


    private EIncomeCategory category;
    private String name;

    public Income() {

    }

    public Income(double amount, String date, EIncomeCategory category) {
        super(amount, date);
        this.category = category;

    }

    public EIncomeCategory getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "Income - " + " -" + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(EIncomeCategory category) {
        this.category = category;
    }





    /*
    Denna klass skall ärva Transaction och skall minst ha följande fält:
    * category- ska vara ett Enum med kategorier för inkomster. = EIncomeCategory

     */
}
