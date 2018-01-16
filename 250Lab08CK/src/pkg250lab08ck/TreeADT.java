package pkg250lab08ck;

public class TreeADT {
    private NodeType theRoot;
    
    
    //METHODS
    /*
    Create  (constructors)
    Destroy
    Add
    Delete
    IsFull
    IsEmpty
    Retrieve
    NO search - why????  Will be integrated recursively when needed
    Traversals
    */
    
    public void Create( ) {
        /*
        DESCRIPTION:  creates a tree that is in an empty, but usable 
            state.
        Preconditions:  must be space in memory.
        Postconditions:  tree will be logically created
        */
        
        theRoot = null;
    }
    
    public TreeADT( ) {
        /*
        DESCRIPTION:  creates a tree that is in an empty, but usable 
            state.
        Preconditions:  must be space in memory.
        Postconditions:  tree will be logically created
        */
        
        Create( );
    }
    
    public boolean Delete(long sValue) {
        boolean result;
        NodeType nodeToRemove;
        
        nodeToRemove = FindNode(sValue, theRoot);
        if(nodeToRemove != null) {
            result = true;
            //System.out.println(nodeToRemove.GetData().GetName());
            PerformDeletion(nodeToRemove);        
        }
        else {
            result = false;
        }
        return result;
    }
    
    private void PerformDeletion(NodeType nodeToDelete) {
        if(nodeToDelete.GetLeft( ) == null)
            nodeToDelete = nodeToDelete.GetRight( );
    }
    
    private NodeType FindNode(long sValue, NodeType aRoot) {
        NodeType result;
        NodeType parent;
        
        if(aRoot == null)
            result = null;
        else
            if(aRoot.GetData( ).GetID( ) == sValue)
                result = aRoot;
            else
                if(aRoot.GetData( ).GetID( ) < sValue)
                    result = FindNode(sValue, aRoot.GetRight( ));
                else
                    result = FindNode(sValue, aRoot.GetLeft( ));
        return result;
    }
    
    public void Add(ElementType newItem) {
        NodeType temp;
        if(theRoot == null) {
            //Add a node!
            temp = new NodeType( );
            temp.SetData(newItem.Clone( ));
            temp.SetLeft(null);
            temp.SetRight(null);
            theRoot = temp;
            temp = null;
        } else if(theRoot.GetData( ).GetID( ) < newItem.GetID( ))
            theRoot.SetRight(AddNode(theRoot.GetRight( ), newItem));
        else
            theRoot.SetLeft(AddNode(theRoot.GetLeft( ), newItem));
    }
    
    private NodeType AddNode(NodeType aRoot, ElementType newItem) {
        NodeType temp;
        if(aRoot == null) {
            //Add a node!
            temp = new NodeType( );
            temp.SetData(newItem.Clone( ));
            temp.SetLeft(null);
            temp.SetRight(null);
            aRoot = temp;
            temp = null;
        } else if(aRoot.GetData( ).GetID( ) < newItem.GetID( ))
            aRoot.SetRight(AddNode(aRoot.GetRight( ), newItem));
        else
            aRoot.SetLeft(AddNode(aRoot.GetLeft( ), newItem));
        
        return aRoot;
    }
    
    public ElementType Retrieve(long sValue) {
        ElementType result;
        
        if(theRoot == null)
            result = null;
        else if(theRoot.GetData( ).GetID( ) == sValue)
                result = theRoot.GetData( ).Clone( );
        else if(theRoot.GetData( ).GetID( ) > sValue)
                result = RetrieveNode(sValue, theRoot.GetLeft( ));
        else
                result = RetrieveNode(sValue, theRoot.GetRight( ));
        
        return result;
    }
 //CHANGED CODE HERE///////////////////////////////////////////////////////   
    private ElementType RetrieveNode(long sValue, NodeType aRoot) {
        ElementType result;
        if(aRoot == null)
            result = null;
        else if(aRoot.GetData( ).GetID( ) == sValue)
                result = aRoot.GetData( ).Clone( );
        else if(aRoot.GetData( ).GetID( ) > sValue)
                result = RetrieveNode(sValue, aRoot.GetLeft( ));
        else
                result = RetrieveNode(sValue, aRoot.GetRight( ));
        //will need to add 1 level counter to the element type as it passes up
        if(result != null)
            result.incLevelCounter();
        return result;
    }
    
    public void Destroy( ) {
        /*
        DESCRIPTION:  removes all elements of the tree and sets it empty.
        Preconditions:  must exist.
        Postconditions:  tree will be logically empty
        */
        
        if(theRoot != null) {
            //get rid of left
            DestroySubTree(theRoot.GetLeft( ));
            //get rid of right
            DestroySubTree(theRoot.GetRight( ));
            //get rid of theRoot
            theRoot.SetData(null);
            theRoot.SetLeft(null);
            theRoot.SetRight(null);
            theRoot = null;
        }
    }
    
    private void DestroySubTree(NodeType aRoot) {
        if(aRoot != null) {
            //get rid of left
            DestroySubTree(aRoot.GetLeft( ));
            //get rid of right
            DestroySubTree(aRoot.GetRight( ));
            //get rid of theRoot
            aRoot.SetData(null);
            aRoot.SetLeft(null);
            aRoot.SetRight(null);
            aRoot = null;
        }
    }
    
    public boolean IsEmpty( ) {
        //DESCR/PRE/POST
        boolean result;
        
        result = (theRoot == null);
        
        return result;
    }
}
