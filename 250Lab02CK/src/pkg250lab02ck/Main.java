
package pkg250lab02ck;

import java.util.Scanner;



/**
 * Lab 02
 * @author Christopher
 * Description: This program used both package and 
 * truck objects to represent a shipping service. This can
 * be used create and load packages, as well as display the 
 * contents of a truck.
 * 
 */
public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int userChoice = 0;
        Truck regional, national, international;
        regional = new Truck();
        national = new Truck();
        international = new Truck();
        
        
        while(userChoice != 5){
            DisplayMenu();
            userChoice = GetUserChoice(kbd);
            PerformUserChoice(userChoice, kbd, regional, national, international);
        }
        
        
    }
    public static void DisplayMenu(){
        System.out.println("\t Package Management System");
        System.out.println("1: Ship New Item");
        System.out.println("2: Calculate Value of Truck");
        System.out.println("3: Calculate Mass of Truck");
        System.out.println("4: Display Contents of Truck");
        System.out.println("5: Quit");
        
        
    }
    
    public static int GetUserChoice(Scanner kbd){
        int userChoice;
        do {            
            userChoice = kbd.nextInt();
        } while (userChoice < 0 || userChoice > 5);
        
        return userChoice;
    }
    
    public static void PerformUserChoice(int userChoice, Scanner kbd, 
                    Truck regional, Truck national, Truck international){
        Package packageToAdd = new Package();
        double value, mass;
        int region = 0;
        switch(userChoice){
            
            case 1:
                System.out.println("Package " + packageToAdd.getIDNum());
                System.out.print("Enter Value:");             
                value = kbd.nextDouble();
                packageToAdd.setValue(value);
                
                System.out.print("Enter Mass:");
                mass = kbd.nextDouble();
                packageToAdd.setMass(mass);
                //load package onto a truck of users choice
                do {   
                    System.out.println("Enter Destination Zone");
                    System.out.println("1: regional");
                    System.out.println("2: national");
                    System.out.println("3: international");
                    region = kbd.nextInt();
                    
                } while (region < 1 || region > 3);
                switch(region){
                    case 1: 
                        regional.addPackage(packageToAdd);
                        break;
                    case 2: 
                        national.addPackage(packageToAdd);
                        break;
                    case 3: 
                        international.addPackage(packageToAdd);
                        break;
                    default:
                        System.err.println("Error Adding Package");
                        break;
                }
                break;
            case 2:
                do {   
                    System.out.println("Enter Truck Selection");
                    System.out.println("1: regional");
                    System.out.println("2: national");
                    System.out.println("3: international");
                    region = kbd.nextInt();
                    
                } while (region < 1 || region > 3);
                switch(region){
                    case 1: 
                        System.out.println("Value: " + regional.calcValue());
                        break;
                    case 2: 
                        System.out.println("Value: " + national.calcValue());
                        break;
                    case 3: 
                        System.out.println("Value: " + international.calcValue());
                        break;
                    default:
                        System.err.println("Error Displaying Value");
                        break;
                }
                break;
            case 3:
                do {   
                    System.out.println("Enter Truck Selection");
                    System.out.println("1: regional");
                    System.out.println("2: national");
                    System.out.println("3: international");
                    region = kbd.nextInt();
                    
                } while (region < 1 || region > 3);
                switch(region){
                    case 1: 
                        System.out.println("Mass: " + regional.calcMass());
                        break;
                    case 2: 
                        System.out.println("Mass: " + national.calcMass());
                        break;
                    case 3: 
                        System.out.println("Mass: " + international.calcMass());
                        break;
                    default:
                        System.err.println("Error Displaying Mass");
                        break;
                }
                break;
            case 4:
                do {   
                    System.out.println("Enter Truck Selection");
                    System.out.println("1: regional");
                    System.out.println("2: national");
                    System.out.println("3: international");
                    region = kbd.nextInt();
                    
                } while (region < 1 || region > 3);
                switch(region){
                    case 1: 
                        regional.Display();
                        break;
                    case 2: 
                        national.Display();
                        break;
                    case 3: 
                        international.Display();
                        break;
                    default:
                        System.err.println("Error Displaying Contents");
                        break;
                }
                break;
            case 5:
                System.out.println("Exiting Program");
                break;
            default:
                System.err.println("Input Error");
                break;
        }
    }
    
}
