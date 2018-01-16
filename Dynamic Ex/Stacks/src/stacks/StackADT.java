package stacks;

public class StackADT {
    //attributes
    private NodeType top;  //start???
    private int maxItems;   //contractual issue
    private int numItems;   //contractual item for Mr. Campbell
    
    //methods
    //IsFull
    //IsEmpty
    //Push
    //Pop
    //Create
    //Destroy
    public StackADT() {
        //Description:  default constructor
        //  -sets up empty stack with a default 
        //      100 elements
        //Preconditions:
        //  Space in RAM would need to be available
        //Postconditions:
        //  Stack will logically exist
        //  Stack will be in an empty state
        //  Stack will have capacity of 100 Elements

        Create(100);
    }

    public StackADT(int stackSize) {
        //Description:  parameterized constructor
        //  -sets up empty stack with specified size
        //Preconditions:
        //  listSize must be set and must be positive
        //  Space in RAM would need to be available
        //Postconditions:
        //  Stack will logically exist
        //  Stack will be empty
        //  Stack will have capacity specified by the listSize
        Create(stackSize);
    }

    //Create
    public void Create(int stackSize) {
        //Description:
        //  -sets up empty stack with specified size
        //Preconditions:
        //  stackSize must be set and must be positive
        //  Space in RAM would need to be available
        //Postconditions:
        //  Stack will logically exist
        //  Stack will be empty
        //  Stack will have capacity specified by the stackSize
        top = null;
        maxItems = stackSize;
        numItems = 0;
    }
    
    public void Destroy( ) {
        //Description:
        //  -Sets the stack to an unusable state
        //Preconditions:
        //  Stack must logically exist
        //Postconditions:
        //  Stack will be unaccessible and unusable
        NodeType temp;
        
        while(top != null) {
            temp = top;
            top = top.GetNext( );
            temp.SetData(null);
            temp.SetNext(null);
            temp = null;
        }
        
        /*
        while(!IsEmpty( )) {
            Pop( );
        }
        */
        maxItems = -1;
        numItems = -2;
        System.gc();
    }
    
    public boolean Push(ElementType anItem) {
        //Description:
        //  Adds a copy of the provided item to the top of the stack when 
        //      possible
        //  Preconditions:
        //      Stack must logically exist.
        //  Postconditions:
        //      When possible to add (i.e. not full) a copy of anItem will
        //          be on the top of the stack and true will be returned
        //      otherwise
        //          the stack shall remain unchanged and false will be returned
        boolean result;
        NodeType temp;
        
        if(!IsFull( )) {
            result = true;
            temp = new NodeType( );
            temp.SetData(anItem.Clone());
            temp.SetNext(top);
            top = temp;
            temp = null;
            numItems++;
        } else
            result = false;
        
        return result;
    }
    
    public boolean IsFull( ) {
        //  Description:  tests to see if there is logical space available on 
        //      the stack
        //  Preconditions:
        //      Stack must logically exist.
        //  Postconditions:
        //      When stack is full, returns true
        //      otherwise returns false
        boolean result;
        ElementType etTemp;
        NodeType ntTemp;
        boolean success;
        
        /*
        if(top == items.length)
            result = true;
        else
            result = false;
        */
        etTemp = new ElementType( );
        ntTemp = new NodeType( );
        success = (etTemp != null && ntTemp != null);
        
        etTemp = null;
        ntTemp = null;
        
        result = (numItems == maxItems || success == false);
        
        return result;
    }
    
    public boolean IsEmpty( ) {
        //  Description:
        //      Tests to see if the stack is empty
        //  Preconditions:
        //      Stack must logically exist.
        //  Postconditions:
        //      When stack is empty, returns true
        //      otherwise returns false;
        boolean result;
        
        result = (top == null);
        
        return result;
    }
    
    public ElementType Pop( ) {
        //  Description:
        //      Gives back the top item from the stack when the stack is 
        //          not empty
        //  Preconditions:
        //      Stack must logically exist
        //  Postconditions:
        //      Returns the top item if the stack was not empty
        //      Returns NULL if the stack is empty
        ElementType result;
        NodeType temp;
        
        if(!IsEmpty()) {
            temp = top;
            top = top.GetNext( );
            result = temp.GetData( );
            temp.SetData(null);
            temp.SetNext(null);
            temp = null;
            numItems--;
        } else
            result = null;
        
        return result;
    }
}
