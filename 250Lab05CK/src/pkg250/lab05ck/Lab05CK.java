package pkg250.lab05ck;

import java.util.Scanner;
import java.io.*;


public class Lab05CK {

    
    public static void main(String[] args) {
        /*
        DESCRIPTION
            This program interacts with the user to help calculate the average 
                wait times for customers in line and at the checkout
        ASSUMPTIONS
            The Store will not be open from 11:59pm to 12:00am. This is due to
                the way the time is stored and the average calculated
        PRECONDITIONS
            There must be some data to work with, weither its live or simulated
        POSTCONDITIONS
            You will have an average wait displayed to the screen 
        */
        
        int choice;
        
        Register[] registers = new Register[2];
        Store store;
        QueueADT line = new QueueADT(30);
        boolean aRegisterOpen;
        //attempt to access the log file, if not create a new one
        try {
            File log;
            Scanner inFileScanner;
            
            log = new File("log.txt");
            inFileScanner = new Scanner(log);
            inFileScanner.close();
        } catch (Exception e) {
            File log;
            FileWriter fw;
            PrintWriter pw;
            
            System.out.println("Creating Log File");
            try {
                log = new File("log.txt");
                fw = new FileWriter(log, true);
                pw = new PrintWriter(fw, true);
                pw.close();
            } catch (Exception s) {
            }
            
            
        }
       
         
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register();
        }
        store = new Store();
        
        do {   
            DisplayMainMenu(registers, store);
            choice = GetUserChoice();
            PerformUserChoice(choice, registers, line, store);
         ///   
            aRegisterOpen = false;
            for (int i = 0; i < registers.length; i++) {
                if (registers[i].getState() == 1 || 
                        registers[i].getState() == 2) {
                    aRegisterOpen = true;
                }
            }
        } while (choice != 5 || store.isOpen() == true || 
                aRegisterOpen == true);
            
        //} while (choice != 5 );
        
        CalculateAverage();
    }
    
    public static int GetUserChoice(){
        /*
        DESCRIPTION
           Gets input from the user on the keyboard 
        PRECONDITIONS
            The user must be prompted for something
        POSTCONDITIONS
            A choice will be gotten from the user and returned
        */
        int choice;
        Scanner kbd = new Scanner(System.in);
        try {
            choice = kbd.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Input");
            choice = -1;
        }
        return choice;
    }
    
    public static void DisplayMainMenu(Register[] registers, Store store){
        /*
        DESCRIPTION
            Displays the top main menu to the user
        PRECONDITIONS
            Registers and a Store have been instanciated
        POSTCONDITIONS
             A Menu will be displayed to the user
        */
        System.out.println("\nRegister Management System");
        
        if(store.isOpen())
            System.out.println("Store:       Open");
        else
            System.out.println("Store:       Closed");
        System.out.println("Customers in Store: " + store.getNumCustomers());
        
        DisplayRegisters(registers);
        System.out.println("MENU (Use Numeric Input)");
        System.out.println("1: Open Store");
        System.out.println("2: Close Store");
        System.out.println("3: Register Options");
        System.out.println("4: Add New Customer");
        System.out.println("5: Close Program");
        
    }
    
    public static void PerformUserChoice(int choice, Register registers[], 
            QueueADT line, Store store){
        /*
        DESCRIPTION
            This function will call a method based on the users input
        PRECONDITIONS
            registers[] must be instantiated and its contents instanciated
            choice must be gotten before calling this function
        POSTCONDITIONS
            the user's choice will be performed
        */
        
        
        switch(choice){
            case 1:
                //open Store
                if (store.isOpen() == false) {
                   store.toggleOpen();
                }
                else
                    System.out.println("Store Is already Open");
                break;
                
            case 2:
                //Close Store
                if (store.isOpen() == true) {
                    store.toggleOpen();
                }
                else
                    System.out.println("Store Is already Closed");
                break;
                
            case 3:
                //register options
                int subChoice, registerNum;
                
                System.out.println("\nRegister Options");
                DisplayRegisters(registers);
                System.out.println("What Register do you want to modify?");
                
                do {   
                    System.out.print("Register: ");
                    try {
                        registerNum = GetUserChoice() - 1; 
                //-1 to access` the correct register 
                    } catch (Exception e) {
                        registerNum = -1;
                    }
                    
                } while (registerNum > registers.length - 1 || registerNum < 0);
                
                System.out.println("\nRegister " + (registerNum + 1) 
                        + "Options "  );
                switch(registers[registerNum].getState()){
                    case 0:
                        System.out.println("Register " + (registerNum + 1) 
                                +":  Closed");
                        break;
                    case 1:
                        System.out.println("Register " + (registerNum + 1) 
                                +":  Open");
                        break;
                    case 2: 
                        System.out.println("Register " + (registerNum + 1) 
                                +":  Busy");
                        break;
                    default:
                        //Should never be reached
                        System.err.println("Register " + (registerNum + 1) 
                                +":  ????");
                        break;
                }
                //Sub Menu
                System.out.println("");
                System.out.println("1: Close Register");
                System.out.println("2: Open Register");
                System.out.println("3: Finish Customer");
                System.out.println("4: Begin Customer");
                do {  
                    try {
                        subChoice = GetUserChoice();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        subChoice = -1;
                    }
                    
                } while (subChoice > 4 || subChoice < 1);
                
                switch(subChoice){
                    case 1:
                        //close reg
                        if(registers[registerNum].closeRegister()){
                            
                        } else {
                            System.out.println("Unable to Close Register");
                        }
                        
                        break;
                    case 2:
                        //open reg
                        if(registers[registerNum].openRegister()){
                            
                        } else {
                            System.out.println("Unable to Open Register");
                        }
                        
                        break;
                    case 3:
                        //finish cust
                        ElementType leavingCust;
                        if(registers[registerNum].getState() == 2){
                            
                            leavingCust = 
                                    registers[registerNum].getCurrentCustomer();
                            leavingCust.setEndTimeInStore();
                            LogCustomerTimes(leavingCust);
                            registers[registerNum] = new Register();
                            registers[registerNum].setState(1); //set it to open
                            store.setNumCustomers(store.getNumCustomers() -1);
                            
                        } else {
                            System.out.println("Unable to Finish a Customer");
                        }
                        
                        break;
                    case 4:
                        //begin cust 
                        ElementType NextCustInLine;
                        if(registers[registerNum].getState() != 2 && 
                                !line.IsEmpty()){
                            //bring in a cust to the register 
                            NextCustInLine = line.Dequeue();
                            NextCustInLine.setEndTimeInLine();
                            registers[registerNum].setCurrentCustomer(
                                    NextCustInLine);
                            //set the 
                             
                        } else {
                            if (registers[registerNum].getState() == 2) {
                                System.out.println("Register is Busy");
                            }
                            if (line.IsEmpty()) {
                                System.out.println("No Customers in Line");
                            }
                        } 
                        break;
                }
                
                break;
        //Add new Customer       
            case 4:
                
                if(store.isOpen()){
                    ElementType newCustomer = new ElementType();
                    line.Enqueue(newCustomer);
                    store.setNumCustomers(store.getNumCustomers() + 1);
                    
                }
                else
                    System.out.println("Cannot Add new Customer, "
                            + "the Store is Closed");
                
                break;
                
            case 5:
                //Quit
                
                break;
            default:
                break;
                
        }
        
    }
    
    public static void CalculateAverage(){
        /*
        DESCRIPTION
            Calculates the average time in line and time at the checkout
        PRECONDITIONS
            There must be a log File
            There must be data in the log File
            The data must be stored in the format of "HH:MM:SS"
                in the order of timer entered, time at end of line, time at end
                    of checkout, with an empty line afterwards 
        POSTCONDITIONS
            The two averages will be displayed to the user via screen. If the 
                average is larger than 60 seconds, it calculates out the time in
                min and in sec
        */
        File log; // logs saved in order written as HH:MM:SS
        Scanner inFileScanner;
        int start = 0, mid = 0, end = 0;
        int averageLineWait = 0, averageServiceTime = 0;
        
        int numOfTrans = 0;
        String Temp;
        
        try {
            log = new File("log.txt");
            inFileScanner = new Scanner(log);
            
            while (inFileScanner.hasNext()) {
                
                Temp = inFileScanner.nextLine();
                start = ConvertToSec(Temp);
                Temp = inFileScanner.nextLine();
                mid = ConvertToSec(Temp);
                Temp = inFileScanner.nextLine();
                end = ConvertToSec(Temp);
                
                averageLineWait += (mid - start);
                averageServiceTime += (end - mid);
                
               inFileScanner.nextLine();
               numOfTrans++;
                
            }
            inFileScanner.close();
            try {
                //wont work if numOfTrans is 0 thus exception
                averageLineWait = averageLineWait / numOfTrans; 
                averageServiceTime = averageServiceTime / numOfTrans;
                
                if (averageLineWait <= 60) {
                    System.out.println("Average Wait Time in Line: "
                            + averageLineWait + " seconds");
                } else{
                    System.out.println("Average Wait Time in Line: " 
                            + (averageLineWait / 60) + " minutes and " 
                            + (averageLineWait % 60) + " seconds");  
                }
                if (averageServiceTime <= 60) {
                    System.out.println("Average Time in Checkout : "
                            + averageServiceTime + " seconds");
                } else{
                    System.out.println("Average Time in Checkout : " 
                            + (averageServiceTime / 60) + " minutes and " 
                            + (averageServiceTime % 60) + " seconds");  
                }
            } catch (Exception e) {
                System.out.println("Average can not be calculated because "
                        + "there is no Data in File");
            }
            
            
        } catch (Exception e) { 
            System.err.println("Unable to access Log File");
        }
        
    }
    
    public static int ConvertToSec(String toFormat){
         // "HH:MM:SS" precondition
        /*
        DESCRIPTION
            Converts a string of the format "HH:MM:SS" to the number of seconds
        PRECONDITIONS
            A valid string must be passed
        POSTCONDITIONS
            the number of seconds will be returned
        */
        int formated = 0;
        
        formated += Integer.parseInt(toFormat.charAt(7) + ""); 
//+ the 1s spot of seconds
        formated += Integer.parseInt(toFormat.charAt(6) + "") * 10; 
//+ the 10s spot of seconds
        formated += Integer.parseInt(toFormat.charAt(4) + "") * 60; 
//+ the 1s spot of mins
        formated += Integer.parseInt(toFormat.charAt(3) + "") * 600;
//+ the 1s spot of mins
        formated += Integer.parseInt(toFormat.charAt(1) + "") * 12 * 60; 
//+ the 1s spot of hours
        formated += Integer.parseInt(toFormat.charAt(0) + "") * 12 * 60 * 10; 
//+ the 1s spot of hours
        
        return formated;
    }
    
    public static void LogCustomerTimes(ElementType customer){
        /*
        DESCRIPTION
            Saves one customer's time information to a file
        PRECONDITIONS
            the customer must have accurate time data within it
        POSTCONDITIONS
            4 appended lines will be added to the file in accending order
        */
        File log;
        FileWriter fw;
        PrintWriter pw;
        try {
            log = new File("log.txt");
            fw = new FileWriter(log, true);
            pw = new PrintWriter(fw, true);
            
            pw.println(customer.getStartTimeInLine());
            pw.println(customer.getEndTimeInLine());
            pw.println(customer.getEndTimeInStore());
            pw.println();
            pw.close();
        } catch (Exception e) {
            System.err.println("File fuc....messed up opening");
            
        }
        
        
    }
    
    public static void DisplayRegisters(Register[] registers){
        /*
        DESCRIPTION
            Displays all the registers and their states(useful for a variable
                number of registers)
        PRECONDITIONS
            the entire array of registers must instanciated and its contents 
                instanciated      
        POSTCONDITIONS
            All register's numbers and States will be displayed
        */
        for (int i = 0; i < registers.length; i++) {
            switch(registers[i].getState()){
            case 0:
                System.out.println("Register " + (i + 1) + ":  Closed");
                break;
            case 1:
                System.out.println("Register " + (i + 1) + ":  Open");
                break;
            case 2: 
                System.out.println("Register " + (i + 1) + ":  Busy");
                break;
            default:
                System.out.println("Register " + (i + 1) + ":  ????");
                break;
            }
        }
    }
}
