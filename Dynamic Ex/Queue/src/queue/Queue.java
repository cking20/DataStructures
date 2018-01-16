package queue;

public class Queue {

    public static void main(String[] args) {
        QueueADT aQueue = new QueueADT(25);
        ElementType anItem;
        int cnt;
        
        cnt = 0;
        while(!aQueue.IsFull() && cnt < 10) {
            anItem = new ElementType();
            anItem.Set("Person " + cnt, 20 + cnt, cnt);
            aQueue.Enqueue(anItem);
            cnt++;
        }
        
        while(!aQueue.IsEmpty()) {
            anItem = aQueue.Dequeue();
            //aQueue.Dequeue();
            System.out.printf("%-20s%10d%10d\n", anItem.GetName(),
                    anItem.GetAge(), anItem.GetIQ());
        }
        aQueue.Destroy();
    }
    
}
