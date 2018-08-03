
public class MainClass {

    public static void main(String args[]){
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.display();
        System.out.println("deleted element is: "+queue.dequeue());
        queue.display();
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        
    }
}
