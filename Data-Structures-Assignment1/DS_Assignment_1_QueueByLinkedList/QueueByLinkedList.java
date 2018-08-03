
/***
 * This class is the queue implementation by linked list. It contains methods to 
 * 1. add an element to queue
 * 2. delete an element from queue 
 * 3. check if queue is full
 * 4. check if queue is empty
 * @author Twinkle-Garg
 *
 * @param <GenericType> specified by user
 */
public class QueueByLinkedList<GenericType>  {
    /***
     * Inner class node contains 2 parts:
     * 1. data
     * 2. reference to next node
     * @author Twinkle-Garg
     *
     */
    class Node {
        GenericType data;
        Node next;

        public Node(GenericType d) {
            data = d;
            next = null;
        }
    }

    Node front = null;
    Node rear=null;

    /**
     * This method checks if queue is empty
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * This method inserts the value at end of queue
     */
    public void enqueue(GenericType number) {
        Node node = new Node(number);
        if(front==null){
            front=node;
            rear=node;
        }else{
            rear.next = node;
            rear = node;
        }
    }

    /**
     * This method deletes a value from queue from front and return it
     * @return deleted value value
     */
    public GenericType dequeue() {
        if (this.isEmpty()) {
            throw new AssertionError("Stack empty..!!");
        } else {
            GenericType value = front.data;
            front = front.next;
            return value;
        }
    }

    /**
     * This method displays elements of queue
     */
    public void display() {
        Node tempDisplay = front;
        while (tempDisplay != null) {
            System.out.println(tempDisplay.data);
            tempDisplay = tempDisplay.next;
        }
    }

    /**
     * This method checks if queue is full
     * @return true if full else false
     */
    public boolean isFull() {
        return false;
    }

}
