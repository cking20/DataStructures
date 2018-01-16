package lab04ck;

public class ElementType {
    //specified by app programmer
    private String remainder;
    
   
    
    public ElementType Clone( ) {
        ElementType aCopy = new ElementType();
        
        aCopy.setRemainder(getRemainder());
        
        return aCopy;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }
}
