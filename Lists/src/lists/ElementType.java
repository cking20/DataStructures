package lists;
//Created by 

public class ElementType {

    private String currencyName;
    private double conversion;  //to $US
    private String dateOfUpdate;

    public String GetKey( ) {
        return currencyName;
    }
    
    public ElementType Clone() {
        ElementType clonedItem = new ElementType();
        clonedItem.SetName(currencyName);
        clonedItem.SetConversion(conversion, dateOfUpdate);
        return clonedItem;
    }

    public void SetName(String newCurrencyName) {
        currencyName = newCurrencyName;
    }

    public void SetConversion(double newRate, String newDateOfUpdate) {
        conversion = newRate;
        dateOfUpdate = newDateOfUpdate;
    }

    public double GetRate() {
        return conversion;
    }

    public String GetDate() {
        return dateOfUpdate;
    }

    public String GetName() {
        return currencyName;
    }
}
