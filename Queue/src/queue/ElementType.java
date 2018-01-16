package queue;

public class ElementType {
    private String name;
    private int age;
    private int iQ;
    
    public void Set(String nName, int nAge, int nIQ) {
        name = nName;
        age = nAge;
        iQ = nIQ;
    }
    
    public ElementType Clone( ) {
        ElementType anElement = new ElementType( );
        anElement.Set(name, age, iQ);
        return anElement;
    }
    
    public String GetName() {
        return name;
    }
    
    public int GetAge() {
        return age;
    }
    
    public int GetIQ() {
        return iQ;
    }
}
