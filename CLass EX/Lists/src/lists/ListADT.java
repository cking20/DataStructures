package lists;
//Defined by UTILITY programmer

import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;
import java.awt.event.ItemEvent;


public class ListADT {
    /*App programmer must define an ElementType class.
     App programmer must include a String-based key attribute 
     within the ElementType.
     App programmer must provide a method to get the key from an 
     called GetKey().
    
     */

    //attributes
    private ElementType[] items;
    private int numItems;
    private int current;

    public void LoadIt() {
        numItems = 0;
        items = new ElementType[2146000000];
        while (!IsFull() && numItems < 2146000000) {
            items[numItems] = new ElementType();
            numItems++;
        }
    }

    public boolean Search(String searchVal){
        Reset();
        while (!AtEnd() && searchVal.compareTo(items[current].GetKey()) != 0)
            GetNext();
        if(AtEnd())
            return false;
        else
            return true;
    }
    
    public boolean IsFull() {
            //Description:
        //  checks to see if list is physically or 
        //      logically full
        //Preconditions:
        //  List must logically exist
        //Postconditions
        //  When list is deemed not full
        //      returns false
        //      identifies there is a slot for an element
        //      identifes there is enough RAM for an element
        //  When list is deemed full
        //      returns true
        //      identifies there is no way to add element 
        //          (slot or RAM would be insufficient)
        //  Contents of the list shall remain unchanged
        boolean result;
        ElementType temp = null;

        try {
            temp = new ElementType();
        } catch (Exception e) {
            result = true;
        }
        if (numItems == items.length || temp == null) {
            result = true;
        } else {
            result = false;
            temp = null;
        }
        System.gc();
        return result;
    }

    //IsEmpty
    public boolean IsEmpty() {
            //Description:
        //  Tests to see if the list is empty (i.e. contains no 
        //      useable data)
        //Preconditions:
        //  The list must logically exist
        //Postcondition:
        //  When the list is deemed empty, returns true
        //  When the list is deemed not empty, returns false
        //  Contents of the list shall remain unchanged
        boolean result;

        /*if(numItems == 0)
         result = true;
         else
         result = false;*/
        result = (numItems == 0);

        return result;
    }

    //AtEnd
    public boolean AtEnd() {
            //Desciption:
        //  Determines if the "current" item is the last 
        //      logical item.
        //Preconditions:
        //  The list must logically exist
        //Postconditions:
        //  When the "current" slot is the final slot, returns true
        //  When the "current" slot is not the final slot, returns false
        //  The list remains unchanged.
        boolean result;

        result = (numItems == current);

        return result;
    }

    //Modifiers/Manipulators
    //Add
    public boolean Add(ElementType anItem) {
        boolean result = !Search(anItem.GetKey());
        
        if(result == true){
        items[numItems] = anItem.Clone();
        numItems++;
        }
        return result;
    }
        //Delete

    //Iterators
    //Reset
    public void Reset() {
        current = 0;
    }

    //GetNext
    public void GetNext() {
        current++;
    }

    //Retrieve

    public ElementType Retrieve() {
            //Description:
        //  Returns the current element
        //Preconditions:
        //  The list must logically exist.
        //  The list cannot be empty???
        //  The current item cannot be at end.
        //Postcondition:
        //  The current element will be returned.
        //  The list shall remain unchanged.

        return items[current].Clone();
    }

    //Construct/Destruct
    public ListADT() {
        //Description:  default constructor
        //  -sets up empty list with a default 100 elements
        //Preconditions:
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be in an empty state
        //  List will have capacity of 100 Elements

            //items = new ElementType[100];
        //numItems = 0;
        Create(100);
    }

    public ListADT(int listSize) {
            //Description:  parameterized constructor
        //  -sets up empty list with specified size
        //Preconditions:
        //  listSize must be set and must be positive
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be empty
        //  List will have capacity specified by the listSize
        //items = new ElementType[listSize];
        //numItems = 0;
        Create(listSize);
    }

    //Create
    public void Create(int listSize) {
            //Description:
        //  -sets up empty list with specified size
        //Preconditions:
        //  listSize must be set and must be positive
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be empty
        //  List will have capacity specified by the listSize
        items = new ElementType[listSize];
        numItems = 0;
        current = 0;
    }
    
    //delete
    public boolean Delete(String searchValue){
        //description :delete
        boolean result;
        if(Search(searchValue) == true){
            numItems--;
            items[current] = items[numItems];
            items[numItems] = null;
            result = true;
        } else
            result = false;
        return result;
    }
    //Destroy
    public void Destroy() {
            //Description:
        //  -renders the list to an unusable state
        //Preconditions:
        //  list must logically exist
        //Postconditions:
        //  List will NOT logically exist
        //  List will have NO capacity
        //  List will be unusable until created again
        for (int cnt = 0; cnt < items.length; cnt++) {
            items[cnt] = null;
        }
        items = null;
        numItems = -1;
        current = -1;
        System.gc();
    }
}
