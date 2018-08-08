


import org.junit.Test;
import static org.junit.Assert.*;


public class CircularQueueTest {
    
    @Test
    public void testEnqueue() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        assertEquals(4,queue.dequeue());
    }
    
    @Test(expected=AssertionError.class)
    public void testEnqueueWhenQueueIsFull() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(6);
    }
   @Test
    public void testDequeue() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(4,queue.dequeue());
    }
    @Test(expected=AssertionError.class)
    public void testDequeueWhenQueueIsEmpty() {
        CircularQueue queue=new CircularQueue(5);
        queue.dequeue();
    }
    @Test
    public void testFull() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(8);
        assertEquals(true,queue.isFull());
    }
    @Test
    public void testNotFull() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        assertEquals(false,queue.isFull());
    }
    @Test
    public void testEmpty() {
        CircularQueue queue=new CircularQueue(5);
        assertEquals(true,queue.isEmpty());
    }
    @Test
    public void testNotEmpty() {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(4);
        assertEquals(false,queue.isEmpty());
    }
}
