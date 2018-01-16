
package pkg250.lab05ck;


public class Store {
    private boolean open;
    private int numCustomers;
    
    public Store(){
        /*
        DESCRIPTION
            Instanciates the object to not open with 0 customers
        PRECONDITIONS
            N/A
        POSTCONDITIONS
            the object is not open with 0 customers
        */
        open = false;
        numCustomers = 0;
    }

    public boolean isOpen() {
        /*
        DESCRIPTION
            Returns if the store is open
        PRECONDITIONS
            N/A
        POSTCONDITIONS
            returns true if the store is open and false if not
        */
        return open;
    }

    public void toggleOpen() {
        /*
        DESCRIPTION
            Toggles the open attribute
        PRECONDITIONS
            open must be defined
        POSTCONDITIONS
            if not open, the store will not be open. 
                if open, the store is now closed 
        */
        this.open = !this.open;
    }

    public int getNumCustomers() {
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        /*
        DESCRIPTION
            Sets the attribute to the passed value
        PRECONDITIONS
            The passed value must be valid
        POSTCONDITIONS
            The attribute will equal the passed value
        */
        this.numCustomers = numCustomers;
    }
    
}
