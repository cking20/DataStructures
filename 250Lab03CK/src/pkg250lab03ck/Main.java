/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg250lab03ck;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int userChoice = 0;
        ElementType schedule;
        schedule = new ElementType();
        ListADT masterSchedule = new ListADT(100, true);
        
        
        while(userChoice != 8){
            DisplayMenu();
            userChoice = GetUserChoice(kbd);
            PerformUserChoice(userChoice, kbd, schedule, masterSchedule);
        }
    }
    
    public static int GetUserChoice(Scanner kbd) {
        int userChoice;
        
        do {  
            
                userChoice = kbd.nextInt();
            
        } while (userChoice > 8 || userChoice < 1); 
        return userChoice;
    }

    public static void DisplayMenu(){
        System.out.println("\t Employee Tracking System");
        System.out.println("1: Load");
        System.out.println("2: Save");
        System.out.println("3: Display One");
        System.out.println("4: Display All");
        System.out.println("5: Display Range");
        System.out.println("6: Add");  
        System.out.println("7: Delete");  
        System.out.println("8: Quit");  
    }
    
    public static void PerformUserChoice(int userChoice, Scanner kbd,
            ElementType schedules, ListADT MasterSchedule) {
        switch(userChoice){
            case 1:
                //load a schedule
                Load(kbd, MasterSchedule);
                break;
            case 2:
                Save(kbd, MasterSchedule);
                 break;
            case 3:
                DisplayOne(kbd, MasterSchedule);
                 break;
            case 4:
                DisplayAll(MasterSchedule);
                 break;
            case 5:
                DisplayRange(kbd, MasterSchedule);
                 break;
            case 6:
                Add(kbd, MasterSchedule);
                 break;
            case 7:
                Delete(kbd, MasterSchedule);
                 break;
            case 8:
                //exit the program
                MasterSchedule.Destroy();
                 break;
            
             
         }
         
     }
    
    public static void Load(Scanner kbd, ListADT MasterSchedule) {
        //ask what file is to be loaded
        ElementType newSchedule = new ElementType();
        String fileName;
        //prompt for file name
        System.out.print("Enter the File name: ");
        do {            
            fileName = kbd.nextLine();
        } while (!fileName.contains(".txt"));
        
        //access the file
        
        try {
            //instantiate the file scanner
            File inFile = new File(fileName);
            Scanner inFileScanner = new Scanner(inFile);
            int i = 0; //count how many items loaded
            //read in the 
            while (inFileScanner.hasNext()) {
                newSchedule.setDate(inFileScanner.nextLine());
                newSchedule.setStart(inFileScanner.nextLine());
                newSchedule.setEnd(inFileScanner.nextLine());
                newSchedule.setLocation(inFileScanner.nextLine());
                newSchedule.setComment(inFileScanner.nextLine());
                //add this schedule to the list
                MasterSchedule.Add(newSchedule);
                //skip the empty line
                inFileScanner.nextLine();
                
                i++;
                
            }
            inFileScanner.close();
            System.err.println("Loaded:" + i + "schedules");
            System.err.println("File Loaded");
        } catch (Exception e) {
            System.err.println("Could not Load File");
        }
        
        
        
        
    }
    
    public static void Save(Scanner kbd, ListADT MasterSchedule) {
         //ask what file is to be loaded
        String fileName;
        FileWriter saveFileWriter;
        PrintWriter saveFilePrintWriter;
        ElementType newElement;
        //prompt for file name
        System.out.print("Enter the File name: ");
        do {            
            fileName = kbd.nextLine();
        } while (!fileName.contains(".txt"));
        
        //access the file
        try {
            saveFileWriter = new FileWriter(fileName, false);
            saveFilePrintWriter = new PrintWriter(saveFileWriter);
            
            int i = 0;
            MasterSchedule.Reset();
            do { 
                newElement = MasterSchedule.Retrieve();
                String date = newElement.getDate();
                System.out.println(date);
                saveFilePrintWriter.println(date);
                saveFilePrintWriter.println(newElement.getStart());
                saveFilePrintWriter.println(newElement.getEnd());
                saveFilePrintWriter.println(newElement.getLocation());
                saveFilePrintWriter.println(newElement.getComment());
                saveFilePrintWriter.println();
                i++;
                System.out.println("Saved " + i + "schedules");
                MasterSchedule.GetNext();
            } while(!MasterSchedule.AtEnd()); 
            
            saveFilePrintWriter.close();
            
        } catch (Exception e) {
            System.err.println("Could not Save File!");
        }
    }

    public static void DisplayRange(Scanner kbd, ListADT MasterSchedule){
        int fromInt, toInt;
        String from, to;
        ElementType anElement;
    //get the from and to dates
        System.out.println("Enter From Date: (YYYYMMDD)");
        do {            
            fromInt = kbd.nextInt();
            from = ""+ fromInt;
            //tests to see if the string is the proper lenght, and that the int 
            //is lower than jan 1st 2050 and higher than jan 1st 2016
        } while (from.length() != "YYYYMMDD".length() && fromInt < 20500101 
                && fromInt > 20000101); 
        
        System.out.println("Enter To Date: (YYYYMMDD)");
        do {            
            toInt = kbd.nextInt();
            to = ""+ toInt;
            //tests to see if the string is the proper lenght, and that the int 
            //is lower than jan 1st 2050 and higher than jan 1st 2016
        } while (to.length() != "YYYYMMDD".length() && toInt < 20500101 
                && toInt > 20000101);
    //find where the start value is in the list
        
        //while the returned date is less than the TO DATE display the next item
        if(MasterSchedule.Search(from)){ //CHNAGED TO AND FROM
            anElement = MasterSchedule.Retrieve();
            //System.err.println("" + anElement.getDate().compareTo(to));
            
            while (anElement.getDate().compareTo(to) <= 0) {                  
                //System.err.println("" + anElement.getDate().compareTo(to));
                
                System.out.println("");
                System.out.println(anElement.getDate());
                System.out.println("    Start Time:" + anElement.getStart());
                System.out.println("    End Time:  " + anElement.getEnd());
                System.out.println("    " + anElement.getLocation());
                System.out.println("    Comments: " + anElement.getComment());
                System.out.println("");
                //attempt to get the next item
                MasterSchedule.GetNext();
                try {
                    anElement = MasterSchedule.Retrieve(); 
                } catch (Exception e) {
                }
                
            }
        }
    }
    
    public static void DisplayOne(Scanner kbd, ListADT MasterSchedule){
        int fromInt; 
        String from;
        ElementType anElement;
    //get the from and to dates
        System.out.println("Enter Date: (YYYYMMDD)");
        do {            
            fromInt = kbd.nextInt();
            from = ""+ fromInt;
            //tests to see if the string is the proper lenght, and that the int 
            //is lower than jan 1st 2050 and higher than jan 1st 2016
        } while (from.length() != "YYYYMMDD".length() && fromInt < 20500101 
                && fromInt > 20160101);
            if(MasterSchedule.Search(from)){
                anElement = MasterSchedule.Retrieve();
                System.out.println("");
                System.out.println(anElement.getDate());
                System.out.println("    Start Time:" + anElement.getStart());
                System.out.println("    End Time:  " + anElement.getEnd());
                System.out.println("    " + anElement.getLocation());
                System.out.println("    Comments: " + anElement.getComment());
                System.out.println(""); 
            } else {
                System.out.println("No Date Found");
            }
        
    }
    
    public static void Add(Scanner kbd, ListADT MasterSchedule){
        String date,start, end, location, comment;
        int dateint;
        
        ElementType anElement;
    //get the from and to dates
        System.out.println("Enter Date: (YYYYMMDD)");
        do {            
            dateint = kbd.nextInt();
            date = ""+ dateint;
            //tests to see if the string is the proper lenght, and that the int 
            //is lower than jan 1st 2050 and higher than jan 1st 2016
        } while (date.length() != "YYYYMMDD".length() && dateint < 20500101 
                && dateint > 20160101);
        do {            
            System.out.println("Enter Start Time: (HH:MM)");
            start = kbd.nextLine();
        } while (!start.contains(":"));
        
        do{
            System.out.println("Enter End Time: (HH:MM)");
            end = kbd.nextLine();
        }while (!end.contains(":"));
        
        
            System.out.println("Enter Location");
            location = kbd.nextLine();
        
        
        
            System.out.println("Enter Comment");
            comment = kbd.nextLine();
        
        
        anElement = new ElementType();
        
        anElement.setDate(date);
        anElement.setComment(comment);
        anElement.setEnd(end);
        anElement.setStart(start);
        anElement.setLocation(location);
        
        MasterSchedule.Add(anElement);
        
    }
    
    public static void Delete(Scanner kbd, ListADT MasterSchedule){
        int fromInt; 
        String from;
        ElementType anElement;
    //get the from and to dates
        System.out.println("Enter Date: (YYYYMMDD)");
        do {            
            fromInt = kbd.nextInt();
            from = ""+ fromInt;
            //tests to see if the string is the proper lenght, and that the int 
            //is lower than jan 1st 2050 and higher than jan 1st 2016
        } while (from.length() != "YYYYMMDD".length() && fromInt < 20500101 
                && fromInt > 20160101);
        
        if(MasterSchedule.Search(from)){
             MasterSchedule.Delete(from);
            System.out.println("Deleted");
        } else
            System.err.println("Not Deleted");
    }
    
    public static void DisplayAll(ListADT MasterSchedule){
        ElementType anElement;
        MasterSchedule.Reset();
        
        
        
        
       do{            
            anElement = MasterSchedule.Retrieve();
            System.out.println("");
                System.out.println(anElement.getDate());
                System.out.println("    Start Time:" + anElement.getStart());
                System.out.println("    End Time:  " + anElement.getEnd());
                System.out.println("    " + anElement.getLocation());
                System.out.println("    Comments: " + anElement.getComment());
                System.out.println("");
                
                MasterSchedule.GetNext();
                try {
                    anElement = MasterSchedule.Retrieve();
                } catch (Exception e) {
                    //System.err.println("at end of list with no item apparently");
                }
               
        }  while (!MasterSchedule.AtEnd());
    }
    
}
