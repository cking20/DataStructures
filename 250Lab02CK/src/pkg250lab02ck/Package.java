
package pkg250lab02ck;
/**
 * @author Christopher
 */
public class Package {
    private static int IDCounter = 0;
    private double mass;
    private double value;
    private int IDNum;
   

    public Package(){
        IDNum = setIDNum();
    }
    
    private static int setIDNum(){
        IDCounter++;
        return IDCounter;
    }
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getIDNum() {
        return IDNum;
    }   
}
