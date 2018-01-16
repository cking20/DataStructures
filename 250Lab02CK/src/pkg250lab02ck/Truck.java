
package pkg250lab02ck;

/**
 *
 * @author Christopher
 */
public class Truck {
    private Package[] inventory;
    private int numItems;
    private static final int MAX = 2;
    
public Truck(){
    numItems = 0;
    inventory = new Package[MAX];
}
    public void addPackage(Package packageToAdd){
        if(numItems < MAX){
            inventory[numItems] = packageToAdd;
            numItems++;
        } else
            System.err.println("Can Not Add, Truck Is Full");
    }
    
    public double calcValue(){
        double runningTotal = 0;
        for(int i = 0; i < numItems;i++){
            runningTotal += inventory[i].getValue();
        }
        return runningTotal;
    }
    
     public double calcMass(){
        double runningTotal = 0;
        for(int i = 0; i < numItems;i++){
            runningTotal += inventory[i].getMass();
        }
        return runningTotal;
    }
    
      public void Display(){
        for(int i = 0; i < numItems;i++){
            System.out.println("Package" + inventory[i].getIDNum());
            System.out.println('\t' + "Value:" + inventory[i].getValue());
            System.out.println('\t' + "Mass:" + inventory[i].getMass());  
        }
        
    }
    
}
