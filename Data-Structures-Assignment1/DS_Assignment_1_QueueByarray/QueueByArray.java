/***
 * This class is the queue implementation by array It contains methods to 
 * 1. add an element to queue
 * 2. delete an element from queue 
 * 3. check if queue is full
 * 4. check if queue is empty
 */
public class QueueByArray<GenericType> implements QueueInterface<GenericType> {

    private GenericType[] queueArray;
    private int size;
    private static int front, rear;

    /**
     * This constructor initializes size of queue
     * 
     * @param size
     */
    public QueueByArray(int size) {
        this.size = size;
        queueArray = (GenericType[]) new Object[size];
        front = -1;
        rear = -1;
    }

    /**
     * This method is used to insert an element into queue. Insertion is done at
     * end
     */
    @Override
    public void enqueue(GenericType value) {
        if (rear == size - 1) {
            throw new AssertionError("Queue overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            queueArray[++rear] = value;
        }
    }

    /**
     * This method is used to delete an element from queue from front
     * 
     * @return deleted element
     */
    @Override
    public GenericType dequeue() {
        if (rear == -1) {
            throw new AssertionError("No elements in queue");
        } else {
            GenericType value = queueArray[front];
            for (int count = 0; count < rear; count++) {
                queueArray[count] = queueArray[count + 1];
            }
            rear--;
            return value;
        }

    }

    /**
     * This method is used to display the queue
     */
    @Override
    public void display() {
        for (int count = front; count <= rear; count++) {
            System.out.println("" + queueArray[count]);
        }

    }

    /**
     * This method checks if queue is empty
     * 
     * @return true if queue is empty else false
     */
    @Override
    public boolean isEmpty() {
        if (front == -1 || front > rear) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if queue is full
     * 
     * @return true if queue is full else false
     */
    @Override
    public boolean isFull() {
        if (rear == size - 1) {
            return true;
        }
        return false;
    }

    /**
     * This method returns the queue
     * 
     * @return queue
     */
    public GenericType[] returnQueue() {
        GenericType[] newArray = (GenericType[]) new Object[rear + 1];
        for (int count = 0; count <= rear; count++) {
            newArray[count] = queueArray[count];
        }
        return newArray;
    }
}
