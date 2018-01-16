package stacks;

public class Stacks {

    public static void main(String[] args) {
        StackADT aStack;
        int cnt;
        ElementType anElement;
        
        aStack = new StackADT(10);
        
        cnt = 10000;
        while(!aStack.IsFull() && cnt < 10050) {
            anElement = new ElementType();
            anElement.SetName("Body of person " + cnt);
            System.out.println("" + cnt + aStack.Push(anElement));
            cnt++;
        }
        
        while(!aStack.IsEmpty() && cnt > 10000) {
            anElement = aStack.Pop( );
            System.out.println(anElement.GetName());
            cnt--;
        }
    }
    
}
