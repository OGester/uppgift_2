package org.example;

public class Income extends Transaction {


    private EIncomeCategory category;
    private String id;

    public Income() {
    }

    public Income(double amount, String date, EIncomeCategory category, String id) {
        super(amount, date);
        this.category = category;
        this.id = id;
    }

    public EIncomeCategory getCategory() {
        return category;
    }


    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public void setCategory(EIncomeCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction - ID: " + id +
                " -Type: " + category + "- " + super.toString();
    }





    /*
    Denna klass skall ärva Transaction och skall minst ha följande fält:
    * category- ska vara ett Enum med kategorier för inkomster. = EIncomeCategory

     */
}
