public class MainClass {
    public static void main(String args[]) {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(5);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(7);
        System.out.println("After insertion");
        queue.display();
        System.out.println("Deleted elemnt: " + queue.dequeue());
        System.out.println("After deletion");
        queue.display();
        System.out.println(queue.isEmpty());
    }
}
