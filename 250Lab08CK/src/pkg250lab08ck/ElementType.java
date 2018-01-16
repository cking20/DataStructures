package pkg250lab08ck;

public class ElementType {
    //specified by app programmer
    private long value;
    private int levelCounter = 0;
   
    
    public ElementType Clone( ) {
        ElementType aCopy = new ElementType();
        
        aCopy.setNumber(GetID());
        
        return aCopy;
    }

    public long GetID() {
        return value;
    }
    
    public int GetLevelCounter(){
        return levelCounter;
    }

    public void setNumber(long newVal) {
        this.value = newVal;
    }
    
    public void incLevelCounter(){
        levelCounter++;
    }
}
