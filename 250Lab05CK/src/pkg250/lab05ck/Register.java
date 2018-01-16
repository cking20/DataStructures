
package pkg250.lab05ck;

public class Register {
    private ElementType currentCustomer;
    private int State; // 0 = closed 1 = open 2 = busy 
    
    
    public Register(){
        /*
        DESCRIPTION
           Called when the register is instanciated 
        PRECONDITIONS
            N/A
        POSTCONDITIONS
            Register will be instanciated 
            The register will be closed
            
        */
        State = 0;
    }

    public ElementType getCurrentCustomer() {
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return currentCustomer;
    }

    public boolean setCurrentCustomer(ElementType currentCustomer) {
        boolean result;
        if (State == 1) {
            this.currentCustomer = currentCustomer;
            setState(2);
            this.currentCustomer.setEndTimeInLine();
            result = true;    
        }
        else
            result = false;
        return result;
        
        
    }

    public int getState() {
        /*
        DESCRIPTION
            Returns the value the name implies
        PRECONDITIONS
            the value must be instanciated
        POSTCONDITIONS
            the value will be returned
        */
        return State;
    }
    
    public boolean openRegister(){
        /*
        DESCRIPTION
            Opens up the register if its closed
        PRECONDITIONS
            Register is closed
        POSTCONDITIONS
            Register is open
        */
        boolean result;
        if (currentCustomer == null && State == 0) {
            setState(1);
            result = true;
        }
        else
            result = false;
        
        return result;
    }
    
     public boolean closeRegister(){
         /*
        DESCRIPTION
            Closes up the register if its open
        PRECONDITIONS
            Register is open
        POSTCONDITIONS
            Register is closed
        */
        boolean result;
            //State == 1 &&
        if ( currentCustomer == null && State == 1) {
            setState(0);
            result = true;
        }
        else
            result = false;
        
        return result;
    }

    public void setState(int State) {
        /*
        DESCRIPTION
            Sets the attribute to the passed value
        PRECONDITIONS
            The passed value must be valid
        POSTCONDITIONS
            The attribute will equal the passed value
        */
        this.State = State;
    }
}
