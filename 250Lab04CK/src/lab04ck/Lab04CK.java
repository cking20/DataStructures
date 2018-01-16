
package lab04ck;

/**
 *
 * @author Christopher
 */
import java.util.Scanner;
public class Lab04CK {

    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        char choice = ' ';
        String choiceString;
        while(choice !='q'){
            PerformConversion();
            System.out.println("Enter q to quit. Enter any other character to Continue");
            choiceString = kbd.nextLine();
            choice = choiceString.charAt(0);
        }
            
        
    }
    public static void PerformConversion(){
        int num, base;
        num = GetNum();
        base = GetBase();
        Convert(num,base);
    }
    
    public static int GetNum(){
        Scanner kbd = new Scanner(System.in);
        int num;
        
        System.out.println("Enter the Number you want to convert");
        do {            
            num = kbd.nextInt();
        } while (num < 0);
        
        return num;
    }
    
    public static int GetBase(){
        Scanner kbd = new Scanner(System.in);
        int base;
        
        System.out.println("Enter the Base you wish to convert to");
        do {            
            base = kbd.nextInt();
        } while (base < 2 || base > 16);
        
        return base;
    }
    
    public static void Convert(int num, int base){
        StackADT stack = new StackADT(20);
        ElementType remainder = new ElementType();
        //String numInBase = "";
        String tempRem = "";
        int tempInt;
        
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
            //push the remainder onto the stack
            remainder.setRemainder(tempRem);
            stack.Push(remainder);
            num = num / base;
        }
        
        do {
            tempRem = stack.Pop().getRemainder();
            System.out.print(tempRem);
            
     
        } while (!stack.IsEmpty());
        System.out.println("");
        
        
        
    }
}
