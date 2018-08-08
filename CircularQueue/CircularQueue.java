

public class CircularQueue<GenericType> {
    private GenericType[] queueArray;
    private int size;
    private static int front, rear;

    /**
     * This constructor initializes size of queue
     * 
     * @param size
     */
    public CircularQueue(int size) {
        this.size = size;
        queueArray = (GenericType[]) new Object[size];
        front = -1;
        rear = -1;
    }

    /**
     * This method is used to insert an element into queue. Insertion is done at
     * end
     */

    public void enqueue(GenericType value) {
        if (isFull()) {
            throw new AssertionError("Queue overflow");
        } else if(front==-1){
            front=rear=0;
            queueArray[rear] = value;
           
        }else if(rear==size-1 && front!=0){
            rear=0;
            queueArray[rear] = value;
           
        }else{
            queueArray[++rear]=value;
            
        }
    }

    /**
     * This method is used to delete an element from queue from front
     * 
     * @return deleted element
     */

    public GenericType dequeue() {
        GenericType value;
        if (isEmpty()) {
            throw new AssertionError("No elements in queue");
        } else{
            value= queueArray[front];
            if(front==rear) {   
            front=rear=-1;
            }else if(front==size-1){
            front=0;
            }else{
            front++;
            }
            
        }
        return value;
        } 

    

    /**
     * This method is used to display the queue
     */

    public void display() {
       if(rear>=front){
           for (int count = front; count <= rear; count++) {
               System.out.println("" + queueArray[count]);
           }
       }else{
           for (int count = front; count <= size-1; count++) {
               System.out.println("" + queueArray[count]);
           }
           for (int count = 0; count <= rear; count++) {
               System.out.println("" + queueArray[count]);
           }
       }
        

    }

    /**
     * This method checks if queue is empty
     * 
     * @return true if queue is empty else false
     */

    public boolean isEmpty() {
        if (front == -1 ) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if queue is full
     * 
     * @return true if queue is full else false
     */

    public boolean isFull() {
        if (rear==front-1 ||(rear == size - 1&& front==0) ) {
            return true;
        }
        return false;
    }
}
