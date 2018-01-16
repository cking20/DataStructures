package stacks;

public class StackADT {
    //attributes
    private ElementType[] items;
    private int top;   //numItems;
    
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

        //items = new ElementType[100];
        //numItems = 0;
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
        items = new ElementType[stackSize];
        top = 0;
    }
    
    public void Destroy( ) {
        //Description:
        //  -Sets the stack to an unusable state
        //Preconditions:
        //  Stack must logically exist
        //Postconditions:
        //  Stack will be unaccessible and unusable
        for(int cnt = 0; cnt < items.length; cnt++)
            items[cnt] = null;
        top = -1;
        items = null;
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
        
        if(!IsFull( )) {
            result = true;
            items[top] = anItem.Clone( );
            top++;
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
        
        /*
        if(top == items.length)
            result = true;
        else
            result = false;
        */
        result = (top == items.length);
        
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
        
        result = (top == 0);
        
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
        
        if(!IsEmpty()) {
            top--;
            result = items[top];
            items[top] = null;
        } else
            result = null;
        
        return result;
    }
}
