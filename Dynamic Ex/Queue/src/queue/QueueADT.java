package queue;

public class QueueADT {
    private NodeType front, back;
    private boolean isCreated;
    
    //Methods
    //  IsFull
    //  IsEmpty
    //  Enqueue
    //  Dequeue
    //  Create
    //  Destroy
    
    public void Create(int numItems) {
        //Description:
        //  Sets the queue to an initial size 
        //      and empty state.
        //Preconditions:
        //  numItems must be properly set (positive).
        //Postconditions:
        //  Queue will exist in an empty state with
        //      the specified capacity.
        front = back = null;
        isCreated = true;
    }
    
    public QueueADT( ) {
        //Description:
        //  Sets the queue to an default size 
        //      and empty state.
        //Preconditions:
        //  None.
        //Postconditions:
        //  Queue will exist in an empty state with
        //      a capacity of 1,000.
        Create(1000);//Create adds the extra slot
    }
    
    public QueueADT(int numItems) {
        //Description:
        //  Sets the queue to an initial size 
        //      and empty state.
        //Preconditions:
        //  numItems must be properly set (positive).
        //Postconditions:
        //  Queue will exist in an empty state with
        //      the specified capacity.
        Create(numItems);//Create adds the extra slot
    }
    
    public void Destroy( ) {
        //Description:
        //  Eliminates all data in the queue and sets it to an unusable state.
        //Preconditions:
        //  Queue must logically exist.
        //Postconditions:
        //  The queue will not logically exist and will be in an unusable state.
        if(isCreated) {
            while(!IsEmpty( ))
                Dequeue( );
            
            isCreated = false;
            
            back = front = null;
        }
    }
    
    public boolean IsEmpty() {
        //Description:
        //  Tests to see if the queue is logically empty.
        //Precondition:
        //  List must logically exist.
        //Postconditions:
        //  When empty, returns true.
        //  When not empty, returns false.
        boolean result;
        
        result = (front == null);
        
        return result;
    }
    
    public boolean IsFull() {
        //Description:
        //  Tests to see if the queue is logically full.
        //Precondition:
        //  List must logically exist.
        //Postconditions:
        //  When full, returns true.
        //  When not full, returns false.
        boolean result;
        ElementType etTemp = new ElementType( );
        NodeType ntTemp = new NodeType( );
        
        result = (etTemp == null || ntTemp == null);
        
        etTemp = null;
        ntTemp = null;
        
        return result;
    }
    
    public boolean Enqueue(ElementType anItem) {
        //Description:
        //  Adds the given item to the back of the queue.
        //Preconditions:
        //  Queue must logically exist.
        //  Queue must not be full.
        //  Provided item must be properly loaded.
        //Postconditions:
        //  Assuming queue was created and not full,
        //      Element will be added to back of queue
        //      Will return true
        //      back will be adjusted
        //  Otherwise
        //      Queue will remain unchanged
        //      Will return false
        boolean result;
        NodeType temp;
        
        result = (!IsFull( ) && isCreated);
        
        if(result == true) {
            temp = new NodeType( );
            temp.SetNext(null);
            temp.SetData(anItem.Clone( ));
            if(!IsEmpty())
                back.SetNext(temp);
            else
                front = temp;
            back = temp;
            temp = null;
        }
        
        return result;
    }
    
    public ElementType Dequeue( ) {
        //Description:
        //  Removes/returns the front element.
        //Preconditions:
        //  The queue must logically exist;
        //  The queue must not be empty.
        //Postconditions:
        //  Assuming the queue exists and is not empty,
        //      returns the front element.
        //      front will be adjusted.
        //  Otherwise
        //      returns null.
        ElementType result;
        NodeType temp;
        
        if(!isCreated || IsEmpty( ))
            result = null;
        else
        {
            temp = new NodeType( );
            result = front.GetData( );
            front = front.GetNext( );
            temp.SetData(null);
            temp.SetNext(null);
            temp = null;
            if(front == null)
                back = null;
        }
        return result;
    }
}
