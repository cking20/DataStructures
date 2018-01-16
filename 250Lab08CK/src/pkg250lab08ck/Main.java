
package pkg250lab08ck;

import java.io.*;
import java.util.Scanner;
/*@author Christopher
 *This program loads up so many numbers, the text file crached 
 *  my dying hard drive(no joke). It then stores the values in a Tree 
 *  Structur and allows the user to find a number in it, 
 *  and displays how many levels
 *  down it went to find it. This continues until the user wants to quit.
 * 
 */
public class Main {

    
    public static void main(String[] args) {
        TreeADT tree = new TreeADT();
        int userChoice = 0;
        long numberToFind;
        
        loadTree(tree);
        
        do{
            numberToFind = PromptForNum();
            FindNum(numberToFind, tree);
            userChoice = PromptForCont();
        }while(userChoice != 0);
        
        
    }
    
    public static void loadTree(TreeADT tree){
        File inFile;
        Scanner inFScn;
        ElementType temp;
        
        temp = new ElementType();
        inFile = new File("numbers.txt");
        try{
            inFScn = new Scanner(inFile);
        }catch(Exception e){
            inFScn = null;
            System.exit(0);
        }
        
        
        while(inFScn.hasNext()){
            long tempNum = inFScn.nextLong();
            temp.setNumber(tempNum);
            System.out.println("Adding value : " + temp.GetID());
            tree.Add(temp);
        }
        inFScn.close();
    }
    
    public static void FindNum(long numberToFind, TreeADT tree){
        ElementType foundElement;
        foundElement = tree.Retrieve(numberToFind);
        if(foundElement != null)
            System.out.println("Found value " + foundElement.GetID() + ", " 
                    + foundElement.GetLevelCounter() + " levels in.");
        if(foundElement == null)
            System.out.println("Did not find the value you entered");
    }
     public static long PromptForNum(){
        long num;
        Scanner input = new Scanner(System.in);
        
         do{
            System.out.print("Enter a number to find: ");
            try{
                num = input.nextLong();
            }catch(Exception e){
                num = -1;
                input.nextLine();
            }
        }while(num < 0);
         return num;
    }
     
     public static int PromptForCont(){
         int input;
         Scanner choice = new Scanner(System.in);
         
             System.out.println("Enter 0 to quit, any other number "
                     + "will continue");
             try{
                 input = choice.nextInt();
             }catch(Exception e){
                 input = 700;
                 choice.next();
             }
         return input;
         
     }
}
