package thelorax;

public class TheLorax {

    public static void main(String[] args) {
        TreeADT aTree = new TreeADT( );
        ElementType temp;
        
        temp = new ElementType( );
        temp.Set(50, "Jeff");
        aTree.Add(temp);
        
        temp = new ElementType( );
        temp.Set(25, "Karen");
        aTree.Add(temp);
        
        temp = new ElementType( );
        temp.Set(75, "Tanya");
        aTree.Add(temp);
        
        temp = new ElementType( );
        temp.Set(275, "Craig");
        aTree.Add(temp);
        
        temp = aTree.Retrieve(275);
        if(temp != null)
            System.out.println("Found " + temp.GetName( ) + " with an ID of " 
            + temp.GetID( ));
        else
            System.out.println("Not found");
        
        aTree.Delete(275);
        
        System.exit(0);
    }
    
}
