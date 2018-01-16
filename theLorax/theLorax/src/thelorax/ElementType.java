package thelorax;

public class ElementType {
    private int laborerID;
    private String laborerName;
    
    public void Set(int nID, String nName) {
        laborerID = nID;
        laborerName = nName;
    }
    
    public int GetID( ) {
        return laborerID;
    }
    
    public String GetName( ) {
        return laborerName;
    }
    
    public ElementType Clone( ) {
        ElementType temp;
        temp = new ElementType( );
        temp.Set(laborerID, laborerName);
        return temp;
    }
}
