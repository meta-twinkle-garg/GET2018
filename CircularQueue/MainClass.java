



public class MainClass {

    public static void main(String args[]){
        CircularQueue<Integer> queue = new CircularQueue<Integer>(5);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(7);
        System.out.println("After insertion");
        queue.display();
        System.out.println("Deleted elemnt: " + queue.dequeue());
        System.out.println("After deletion");
        queue.display();
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(9);
        queue.enqueue(4);
        queue.display();
        System.out.println(queue.isFull());
    }
}
