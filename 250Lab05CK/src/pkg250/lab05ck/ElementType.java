package pkg250.lab05ck;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ElementType {
    //Customer 
    private String startTimeInLine;
    private String endTimeInLine;
    private String endTimeInStore;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 


    public ElementType() {
        /*
        DESCRIPTION
            Sets the first value when instanciated
        PRECONDITIONS
            N/A
        POSTCONDITIONS
            The First Value will equal the current time
        */
        setStartTimeInLine();
    }
    
    private void Set(String startTimeInLine, String endTimeInLine, 
            String endTimeInStore) {
        /*
        DESCRIPTION
            the attributes of this object will equal the passed values
        PRECONDITIONS
            the passed values must be valid
        POSTCONDITIONS
            the attributes are equal to the passed values
        */
        this.endTimeInLine = endTimeInLine;
        this.startTimeInLine = startTimeInLine;
        this.endTimeInStore = endTimeInStore;
    }
    
    public ElementType Clone( ) {
        /*
        DESCRIPTION
            Returns a copy of the object
        PRECONDITIONS
            The object must hold valid data
            The object must be instanciated
        POSTCONDITIONS
            A copy is returned
        */
        ElementType anElement = new ElementType( );
        anElement.Set(this.startTimeInLine, this.endTimeInLine, 
                this.endTimeInStore);
        return anElement;
    }

    private void setStartTimeInLine() {
        /*
        DESCRIPTION
            Sets the attribute to the current Time
        PRECONDITIONS
            The passed value must be valid
        POSTCONDITIONS
            The attribute will equal the current Time
        */
        long time = System.currentTimeMillis();
        startTimeInLine = sdf.format(new Date(time));
        
    }

    public void setEndTimeInLine() {
        /*
        DESCRIPTION
            Sets the attribute to the current Time
        PRECONDITIONS
            The passed value must be valid
        POSTCONDITIONS
            The attribute will equal the current Time
        */
        long time = System.currentTimeMillis();
        endTimeInLine = sdf.format(new Date(time));
    }

    public void setEndTimeInStore() {
        /*
        DESCRIPTION
            Sets the attribute to the current Time
        PRECONDITIONS
            The passed value must be valid
        POSTCONDITIONS
            The attribute will equal the current Time
        */
        long time = System.currentTimeMillis();
        endTimeInStore = sdf.format(new Date(time));
        
    }

    public String getStartTimeInLine() { 
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return startTimeInLine;
    }

    public String getEndTimeInLine() {
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return endTimeInLine;
    }

    public String getEndTimeInStore() {
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return endTimeInStore;
    }
    
   
}
