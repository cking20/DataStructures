package stacks;

public class ElementType {
    //specified by app programmer
    private String bodyName;
    
    public void SetName(String newName) {
        bodyName = newName;
    }
    
    public String GetName( ) {
        return bodyName;
    }
    
    public ElementType Clone( ) {
        ElementType aCopy = new ElementType();
        
        aCopy.SetName(bodyName);
        
        return aCopy;
    }
}
