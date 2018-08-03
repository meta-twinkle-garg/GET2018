

/***
 * This interface is for queue implementation. It contains methods to be performed on queue.
 * 1. add an element to queue
 * 2. delete an element from queue 
 * 3. check if queue is full
 * 4. check if queue is empty
 * @author Twinkle-Garg
 *
 * @param <GenericType> specified by user
 */
public interface QueueInterface<GenericType> {
    public void enqueue(GenericType value);
    public GenericType dequeue();
    public void display();
    public boolean isEmpty();
    public boolean isFull();
}

