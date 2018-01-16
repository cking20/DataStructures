
package pkg250lab01ck;


import java.io.*;
import java.util.Scanner;
public class Cup {
    //attr
     private String cupType;
     private double BowlBasePrice;
     private int BowlMax; 
     private double ConeBasePrice;
     private int ConeMax;
     private double WaffleBasePrice;
     private int WaffleMax;
     private int weight;
     private int iceCreamRate;
     private int toppingRate;
     private int candyRate;
     private double pricePerGram;
     private double price;
     
     //methods
    public Cup() throws IOException{
         weight = 0;
         cupType = "bowl";
         //read in vals and set them from the file
         
         
        Scanner inFscnr;
        File inFile = new File("IF.txt");
        inFscnr = new Scanner(inFile);
        
        BowlMax = inFscnr.nextInt();
        ConeMax = inFscnr.nextInt();
        WaffleMax = inFscnr.nextInt();
        BowlBasePrice = inFscnr.nextDouble();
        ConeBasePrice = inFscnr.nextDouble();
        WaffleBasePrice = inFscnr.nextDouble();
        iceCreamRate = inFscnr.nextInt();
        toppingRate = inFscnr.nextInt();
        candyRate = inFscnr.nextInt();
        pricePerGram = inFscnr.nextDouble();
        inFscnr.close();
     }
    
    public Cup(String FileName) throws IOException{
         weight = 0;
         //default cup choice
         cupType = "bowl";
         //read in vals and set them from the file
         
            Scanner inFscnr = new Scanner(FileName);
            BowlMax = inFscnr.nextInt();
            ConeMax = inFscnr.nextInt();
            WaffleMax = inFscnr.nextInt(); 
            
            BowlBasePrice = inFscnr.nextDouble();
            ConeBasePrice = inFscnr.nextDouble();
            WaffleBasePrice = inFscnr.nextDouble();
            
            iceCreamRate = inFscnr.nextInt();
            toppingRate = inFscnr.nextInt();
            candyRate = inFscnr.nextInt();
            pricePerGram = inFscnr.nextDouble();
            inFscnr.close();
         
            
     }
    //basic gets
    public String getCupType() {
        return cupType;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public double getCupPrice(){
        
        switch(cupType){
            case("bowl"):
                return BowlBasePrice;
                    
            case("cone"):
                return ConeBasePrice;
                    
            case("waffle"):
                return WaffleBasePrice;
                
            default:
                return 0.00;
            
        }
    }
    //this gives back the price of the stuff inside AND the cup
    public double getCupAndFillingPrice() {
        switch(cupType){
            case("bowl"):
                    price = weight * pricePerGram + BowlBasePrice;
                    return price;
                case("cone"):
                    price = weight * pricePerGram + ConeBasePrice;
                    return price;
                case("waffle"):
                    price = weight * pricePerGram + WaffleBasePrice;
                    return price;
                default:
                    return 0.00;
            
        }
        
        
    }
    //more complex methods
    public boolean isFull(){
        switch(getCupType()){
            case("bowl"):
                if (getWeight() >= BowlMax) {
                    return true;
                } else
                    return false;
            case("cone"):
                if (getWeight() >= ConeMax) {
                    return true;
                } else
                    return false;
            case("waffle"):
                if (getWeight() >= WaffleMax) {
                    return true;
                } else
                    return false;
            default:
                return true;
        }      
    }
    
    public boolean isEmpty(){
        switch(getCupType()){
            case("bowl"):
                if (getWeight() == 0) {
                    return true;
                } else
                    return false;
            case("cone"):
                if (getWeight() == 0) {
                    return true;
                } else
                    return false;
            case("waffle"):
                if (getWeight() == 0) {
                    return true;
                } else
                    return false;
            default:
                return false;
        }      
    }
    
    public boolean ChangeCupType(String inputCupType){
        if (this.isEmpty()) {
            switch(inputCupType){
                case("bowl"):
                    cupType = "bowl";
                    return true;
                case("cone"):
                    cupType = "cone";
                    return true;
                case("waffle"):
                    cupType = "waffle";
                    return true;
                default:
                    return false;
            }
        } else
            return false; 
    }
    
    public boolean AddIceCream(int time){ 
        switch(this.getCupType()){
            case("bowl"):
                if ((time * iceCreamRate + getWeight()) <= BowlMax) {
                    weight += time * iceCreamRate; 
                    return true;
                }
                return false;
            case("cone"):
                if ((time * iceCreamRate + getWeight()) <= ConeMax) {
                    weight += time * iceCreamRate;
                    return true;
                }
                return false;
            case("waffle"):
                if ((time * iceCreamRate + getWeight()) <= WaffleMax) {
                    weight += time * iceCreamRate;
                    return true;
                }
                return false;
            default:
                return false;  
        }
    }
    
    public boolean AddHotTopping(int time){ 
        switch(this.getCupType()){
            case("bowl"):
                if ((time * toppingRate + getWeight()) <= BowlMax) {
                    weight += time * toppingRate;
                    return true;
                }    
                return false;
            case("cone"):
                if ((time * toppingRate + getWeight()) <= ConeMax) {
                    weight += time * toppingRate;
                    return true;
                }
                return false;
            case("waffle"):
                if ((time * toppingRate + getWeight()) <= WaffleMax) {
                    weight += time * toppingRate;
                    return true;
                }
                return false;
            default:
                return false;  
        }
    }
    
    public boolean AddCandy(int time){
        switch(this.getCupType()){
            case("bowl"):
                if ((time * candyRate + getWeight()) <= BowlMax) {
                    weight += time * candyRate;
                    return true;
                }    
                return false;
            case("cone"):
                if ((time * candyRate + getWeight()) <= ConeMax) {
                    weight += time * candyRate;
                    return true;
                }
                return false;
            case("waffle"):
                if ((time * candyRate + getWeight()) <= WaffleMax) {
                    weight += time * candyRate;
                    return true;
                }
                return false;
            default:
                return false;  
        }
    }

    public void reset(){
        this.weight = 0;
        cupType = "bowl";
        
    }
    
}
