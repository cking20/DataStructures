package lists;

public class NodeType {
    private ElementType data;
    private NodeType next;
    
    public void SetData(ElementType newItem) {
        if(newItem == null)
            data = null;
        else
            data = newItem.Clone( );
    }
    
    public void SetNext(NodeType newNext) {
        next = newNext;
    }
    
    public ElementType GetData( ) {
        return data;
    }
    
    public NodeType GetNext( ) {
        return next;
    }
}
