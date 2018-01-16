package pkg250lab08ck;

public class NodeType {
    private ElementType data;
    private NodeType left, right;
    
    public void SetData(ElementType nData) {
        if(nData != null)
            data = nData.Clone( );
        else
            data = null;
    }
    
    public ElementType GetData( ) {
        return data.Clone( );
    }
    
    public void SetLeft(NodeType nLeft) {
        left = nLeft;
    }
    
    public void SetRight(NodeType nRight) {
        right = nRight;
    }
    
    public NodeType GetLeft( ) {
        return left;
    }
    
    public NodeType GetRight( ) {
        return right;
    }
}
