
package pkg250lab06ck;

/**Christopher King
 * This lab allows the user to enter 2 positive integer values then computes 
 * the first number in the base of the second. It utilizes note types to 
 * create a linked structure, which is what holds the data.
 *
 * 
 */
import java.util.Scanner;
public class Lab08CK {

    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        char choice = ' ';
        String choiceString;
        while(choice !='q'){
            PerformConversion();
            System.out.println("Enter q to quit. Enter any other character to "
                    + "Continue");
            try {
                choiceString = kbd.nextLine();
                choice = choiceString.charAt(0);
            } catch (Exception e) {
                choice = 'n';
            }
            
        }
            
        
    }
    public static void PerformConversion(){
        int num, base;
        num = GetNum();
        base = GetBase();
        System.out.print("The number " + num + " in base " + base + " is " );
        RecursiveConvert(num,base);
        System.out.println();
    }
    
    public static int GetNum(){
        Scanner kbd = new Scanner(System.in);
        int num;
        
       
        do {  
            try {
                System.out.println("Enter the Number you want to convert");
                num = kbd.nextInt();
                
            } catch (Exception e) {
                num = -1;
                kbd.next();
            }
        } while (num < 0);
        
        return num;
    }
    
    public static int GetBase(){
        Scanner kbd = new Scanner(System.in);
        int base;
        
        System.out.println("Enter the Base you wish to convert to");
        do { 
            try {
                base = kbd.nextInt();
            } catch (Exception e) {
                base = -1;
                kbd.next();
            }
            
        } while (base < 2 || base > 16);
        
        return base;
    }
    
    public static void Convert(int num, int base){
        //StackADT stack = new StackADT(20);
        NodeType top = new NodeType();
        NodeType temp;
        ElementType remainder;
        //String numInBase = "";
        String tempRem = "";
        int tempInt;
        int numNodes = 0;
        
        System.out.print("The number " + num + " in base " + base + " is " );
        while (num > 0) {  
            tempInt = (num % base);
            tempRem = "" + tempInt;    
            
            if (tempInt > 9) {
                switch(tempInt){
                    case (10):
                        tempRem = "A";
                        break;
                    case (11):
                        tempRem = "B";
                        break;
                    case (12):
                        tempRem = "C";
                        break;
                    case (13):
                        tempRem = "D";
                        break;
                    case (14):
                        tempRem = "E";
                        break;
                    case (15):
                        tempRem = "F";
                        break;
                    default:
                        tempRem = "!";
                }
                
            }
            
            remainder = new ElementType();
            remainder.setRemainder(tempRem);
            //incrament num nodes
            numNodes++;
            //create a new node type
            //add data to node type
            //change the last nodes pointer to point to this ne wone
            temp = new NodeType();
            temp.SetData(remainder.Clone());
            temp.SetNext(top.GetNext());
            top = new NodeType();
            top.SetNext(temp);
            
            num = num / base;
        }
        
        do {
            
            tempRem = top.GetNext().GetData().getRemainder();
            System.out.print(tempRem);
            top = top.GetNext();
            
            numNodes--;
     
        } while (numNodes > 0);
        System.out.println("");
        
        
        
    }
    public static void RecursiveConvert(int num, int base){
        int tempInt;
        String tempRem;
        
        
        if (num > 0) {  
            tempInt = (num % base);
            tempRem = "" + tempInt;    
            
            if (tempInt > 9) {
                switch(tempInt){
                    case (10):
                        tempRem = "A";
                        break;
                    case (11):
                        tempRem = "B";
                        break;
                    case (12):
                        tempRem = "C";
                        break;
                    case (13):
                        tempRem = "D";
                        break;
                    case (14):
                        tempRem = "E";
                        break;
                    case (15):
                        tempRem = "F";
                        break;
                    default:
                        tempRem = "!";
                }
            }
            RecursiveConvert((num / base), base);
            System.out.print(tempRem);
            
        }
    }
}
    
