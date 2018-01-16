package queue;

public class NodeType {
    private ElementType data;
    private NodeType next;
    
    public void SetData(ElementType nData) {
        if(nData == null)
            data = null;
        else
            data = nData.Clone( );
    }
    
    public void SetNext(NodeType nNext) {
        next = nNext;
    }
    
    public ElementType GetData( ) {
        return data;
    }
    
    public NodeType GetNext( ) {
        return next;
    }
}
