/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg250lab01ck;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class Application01 {
    static final double SALES_TAX = .08;
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner kbd = new Scanner(System.in);
        Cup aCup = new Cup();
        int choice;
        choice = 0;
        
        while (choice != 6) {            
            DisplayMenu(aCup);
            choice = GetUserChoice(kbd);
            PerfromUserChoice(aCup, choice, kbd);
        }
        
        
        
    }
    
    public static void DisplayMenu(Cup aCup){
        System.out.println("\n\n                  Pink Frog YO Hey Hey Johnny Ice Cream");
        System.out.printf("Current Container: %s , priced at %2.2f\n", aCup.getCupType(), aCup.getCupPrice());
        System.out.printf("Current Weight: %d\n", aCup.getWeight());
        System.out.printf("SubTotal: %f\n", aCup.getCupAndFillingPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Options");
        System.out.println("1:Change Cup");
        System.out.println("2:Add Ice Cream");
        System.out.println("3:Add Hot Topping");
        System.out.println("4:Add Candy Topping");
        System.out.println("5:Check Out");
        System.out.println("6:Exit");
        
        
    }
    
    public static int GetUserChoice(Scanner kbdScanner){
        int input;
        //validate input
        do {            
            input = kbdScanner.nextInt();
        } while (input > 6 || input < 1);
        
        return input;
    }
    
    public static void PerfromUserChoice(
            Cup aCup, int choice, Scanner kbdScanner) throws IOException{
        switch(choice){
            case(1):
                ChangeCupType(aCup, kbdScanner);
                break;
            case(2):
                AddIceCream(aCup, kbdScanner);
                break;
            case(3):
                AddHotTopping(aCup, kbdScanner);
                break;
            case(4):
                AddCandyTopping(aCup, kbdScanner);
                break;
            case(5):
                CheckOut(aCup);
                break;
            default:
                break;
        }
        
    }
    
    
    public static void ChangeCupType(Cup aCup, Scanner kbdScanner){
        String input;
                
               
                
                if (aCup.isEmpty()) {
                    System.out.println("Change to Bowl, Cone, or Waffle?");
                    do {  
                        System.out.print(">");
                        input = kbdScanner.nextLine();
                    } while (!input.toLowerCase().contains("bowl")
                        && !input.toLowerCase().contains("cone") 
                        && !input.toLowerCase().contains("waffle"));
                    //incase they type in anything other than 
                            //just the word. ex: I want a waffle goes to waffle
                    if (input.toLowerCase().contains("bowl")) {
                        input = "bowl";
                    }
                    if (input.toLowerCase().contains("cone")) {
                        input = "cone";
                    }
                    if (input.toLowerCase().contains("waffle")) {
                        input = "waffle";
                    }
                    
                    aCup.ChangeCupType(input);
                    System.out.printf("Cup type changed to %s\n", aCup.getCupType());
                } else
                    System.out.println("Cant Change Cups Now!");
                
    }

    public static void AddIceCream(Cup aCup, Scanner kbdScanner){
        int time;
        System.out.println("How many seconds would you "
                + "like to hold the Ice Cream lever? (0 - 25)");
        do {            
            time = kbdScanner.nextInt();
        } while (time  < 0 || time > 25);
        
        if (!aCup.AddIceCream(time)) {
            System.out.println("Cant over Flow the container");
        }
    }
    
    public static void AddHotTopping(Cup aCup, Scanner kbdScanner){
        int time;
        System.out.println("How many seconds would you "
                + "like to hold the Hot Topping lever? (0 - 27)");
        do {            
            time = kbdScanner.nextInt();
        } while (time  < 0 || time > 27);
        
        if (!aCup.AddHotTopping(time)) {
            System.out.println("Cant over Flow the container");
        }
    }
    
    public static void AddCandyTopping(Cup aCup, Scanner kbdScanner){
        int time;
        System.out.println("How many seconds would you "
                + "like to hold the Candy lever? (0 - 25)");
        do {            
            time = kbdScanner.nextInt();
        } while (time  < 0 || time > 25);
        
        if (!aCup.AddCandy(time)) {
            System.out.println("Cant over Flow the container");
        }
    }
    
    public static void CheckOut(Cup aCup) throws IOException{
        double salesTaxAmount;
        //calculate total
        System.out.printf("Cup Price:    %-10.2f\n", aCup.getCupPrice());
        System.out.printf("Filling Price:%-10.2f\n", 
                aCup.getCupAndFillingPrice() - aCup.getCupPrice());
        System.out.printf("Sub Total:    %-10.2f\n", aCup.getCupAndFillingPrice());
        salesTaxAmount = aCup.getCupAndFillingPrice() * SALES_TAX;
        System.out.printf("Sales Tax:    %-10.2f\n", salesTaxAmount);
        System.out.printf("Total:        %-10.2f\n", aCup.getCupAndFillingPrice()
                + salesTaxAmount);
        //reset the cup
        aCup.reset();
    }
}
