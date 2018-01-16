package lists;
//Defined by Application programmer

public class Lists {

    public static void main(String[] args) {
        ListADT theList;
        ElementType anItem;

        theList = new ListADT(1000, true);
        anItem = new ElementType();
        for (int cnt = 5; cnt > 0; cnt--) {

            anItem.SetName("MoneyName" + cnt);
            anItem.SetConversion(cnt + 0.1, "Date:" + cnt);
            theList.Add(anItem);
            //anItem.SetName("You smell (with your nose");
        }

        ShowAll(theList);
        
        if(theList.Search("MoneyName2"))
            System.out.println(theList.Retrieve().GetName() + " " +
                theList.Retrieve().GetRate());
        else
            System.out.println("Not found.");
        
        if(theList.Delete("MoneyName2"))
            System.out.println("Item DELETED");
        else
            System.out.println("Item NOT deleted - Not found.");
        
        ShowAll(theList);

        theList.Destroy();
    }

    public static void ShowAll(ListADT theList) {
        ElementType rItem;
        System.out.println("Original...");
       /* theList.Reset();
        while (!theList.AtEnd()) {
            rItem = theList.Retrieve();
            System.out.println(rItem.GetName() + "\t"
                    + rItem.GetDate() + "\t"
                    + rItem.GetRate() + "\t");
            rItem.SetName("Once again, you smell...");
            theList.GetNext();
        }
        System.out.println("Second pass...");*/
        theList.Reset();
        while (!theList.AtEnd()) {
            rItem = theList.Retrieve();
            System.out.println(rItem.GetName() + "\t"
                    + rItem.GetDate() + "\t"
                    + rItem.GetRate() + "\t");
            theList.GetNext();
        }
    }
}
