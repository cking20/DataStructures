
package pkg250lab06ck;

/**
 *
 * @author Christopher
 */
public class NodeType {
    ElementType data;
    NodeType next;
    
    public void SetData(ElementType anElement) {
        if(anElement != null)
            data = anElement.Clone();
        else
            data = null;
    }
    
    public ElementType GetData( ) {
        return data;
    }
    
    public void SetNext(NodeType theNewNext) {
        next = theNewNext;
    }
    
    public NodeType GetNext( ) {
        return next;
    }
}


