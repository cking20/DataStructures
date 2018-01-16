package lists;
//Defined by UTILITY programmer

public class ListADT {
    /*App programmer must define an ElementType class.
     App programmer must include a String-based key attribute 
        with the ElementType.
     App programmer must provide a method to get the key from an 
        element (named GetKey).
    
     */

    //attributes
    private NodeType start, current, prev;
    private boolean ordered;

    //methods
    public boolean Search(String searchVal) {
        //Description:
        //  Sets the current indicator to the location of the specified element 
        //      IF it exists in the list.
        //Preconditions:
        //  The list must logically exist.
        //  The searchval must be properly loaded.
        //
        boolean result;
        Reset( );
        if(ordered == false) {//UNORDERED SEARCH
            while(!AtEnd( ) && searchVal.compareTo(current.GetData( ).GetKey()) != 0)
                GetNext( );

            if(AtEnd( ))
                result = false;
            else
                result = true;
        } else {//ORDERED SEARCH
            while(!AtEnd( ) && searchVal.compareTo(current.GetData( ).GetKey()) > 0)
                GetNext( );

            if(AtEnd( ) || searchVal.compareTo(current.GetData( ).GetKey()) < 0)
                result = false;
            else
                result = true;
        }
        return result;
    }

    //Observers
    //IsFull
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
        if (temp == null) {
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
        result = (start == null);

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

        result = (current == null);

        return result;
    }

    //Modifiers/Manipulators
    //Add
    
    //Add
    public boolean Add(ElementType anItem) {
        //Description:
        //  This method places a given element into the next available spot
        //      in the list provided the key does not exist already.
        //Preconditions:
        //  The list must logically exist.
        //  The list must not be full.
        //  The amount of RAM available should be sufficient for a 
        //      new ElementType.
        //Postconditions:
        //  An formerly available slot shall contain a COPY of the 
        //      passed Element.
        //  The number of items is incremented.
        //  When the key exists already
        //      returns false
        //  otherwise
        //      returns true
        boolean result = !Search(anItem.GetKey());
        if(result == true && ordered ==  false) 
            Append(anItem);
        else if(result == true && ordered == true)
            Insert(anItem);
        return result;
    }
    
    private void Insert(ElementType anItem) {
        //locate insertion point
        NodeType temp;
        
        Search(anItem.GetKey());
        
        temp = new NodeType( );
        temp.SetData(anItem);
        temp.SetNext(current);
        if(prev != null)
            prev.SetNext(temp);
        else
            start = temp;
        current = temp;
        temp = null;
    }
    
    private void Append(ElementType anItem) {
        //Description:
        //  This method places a given element into the next available spot
        //      in the list provided the key does not exist already.
        //Preconditions:
        //  The list must logically exist.
        //  The list must not be full.
        //  The amount of RAM available should be sufficient for a 
        //      new ElementType.
        //Postconditions:
        //  An formerly available slot shall contain a COPY of the 
        //      passed Element.
        //  The number of items is incremented.
        NodeType temp;
        
        temp = new NodeType( );
        temp.SetData(anItem.Clone( ));
        temp.SetNext(start);
        start = temp;
        temp = null;
    }
        //Delete
    public boolean Delete(String searchValue) {
        //Description:
        //  Deletes the item that matches the searchValue.
        //Preconditions:
        //  The list must logically exist.
        //  The searchValue must be properly loaded.
        //Postconditions:
        //  When the searchValue is found
        //      the element will be removed (logically).
        //      returns a value of true
        //  When the searchValue is not found
        //      the list shall remain unchanged.
        //      returns a value of false
        boolean result;
        
        if(Search(searchValue) == true) {
            //delete it!
            if(!ordered)
                UnorderedDelete( );
            else
                OrderedDelete( );
            
            //disposing of the contents of "deleted" mode
            current.SetData(null);
            current.SetNext(null);
            Reset( );
            result = true;
        }
        else {
            //don't delete it.
            result = false;
        }
        return result;
    }
    
    private void OrderedDelete( ) {
        if(current == start)
            start = start.GetNext( );
        else
            prev.SetNext(current.GetNext( ));
    }
    
    private void UnorderedDelete( ) {
        OrderedDelete( );
    }

    //Iterators
    //Reset
    public void Reset() {
        //Description:
        //  Resets the current item to be the first item.
        //Preconditions:
        //  List must logically exist.
        //  --->List must not be empty.
        //Postconditions:
        //  Current item will be at the first location.
        //  Contents of the list shall remain unchanged.
        prev = null;
        current = start;
    }

    //GetNext
    public void GetNext() {
        //Description:
        //  Moves the current item to the next item in the list.
        //Preconditions:
        //  List must logically exist.
        //  Current item must not be the last item.
        //  The list cannot be empty.
        //Postconditions:
        //  Current item will indicate the "next" item.
        //  The list contents shall remain unchanged.
        prev = current;
        current = current.GetNext( );
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

        return current.GetData( ).Clone();
    }

    //Construct/Destruct
    public ListADT() {
        //Description:  default constructor
        //  -sets up empty, unordered list with a default 100 elements
        //Preconditions:
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be in an empty state
        //  List will have capacity of 100 Elements

            //items = new ElementType[100];
        //numItems = 0;
        Create(100, false);
    }

    public ListADT(int listSize, boolean isOrdered) {
        //Description:  parameterized constructor
        //  -sets up empty list with specified size
        //  -sets the list as ordered or unordered
        //Preconditions:
        //  listSize must be set and must be positive
        //  must specify if ordered or not
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be empty
        //  List will have capacity specified by the listSize
        //  List will be ordered if that was required
        Create(listSize, isOrdered);
    }

    //Create
    public void Create(int listSize, boolean isOrdered) {
        //Description:
        //  -sets up empty list with specified size
        //  -sets the list as ordered or unordered
        //Preconditions:
        //  listSize must be set and must be positive
        //  must specify if ordered or not
        //  Space in RAM would need to be available
        //Postconditions:
        //  List will logically exist
        //  List will be empty
        //  List will have capacity specified by the listSize
        //  List will be ordered if that was required
        current = null;
        prev = null;
        start = current;
        ordered = isOrdered;
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
        Reset( );
        while(!AtEnd( )) {
            GetNext( );
            prev.SetData(null);
            prev.SetNext(null);
            prev = null;
        }
        
        start = null;
        System.gc();
    }
}
