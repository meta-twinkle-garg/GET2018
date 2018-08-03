import static org.junit.Assert.*;

import org.junit.Test;


public class QueueByLinkedListTest {

    @Test
    public void testEnqueue() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        Integer expected=2;
        assertEquals(expected,queue.dequeue());
    }
    @Test
    public void testEnqueueNeg() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        Integer expected=3;
        assertNotEquals(expected,queue.dequeue());
    }
    @Test
    public void testDequeue() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        queue.enqueue(3);
        Integer expected=2;
        assertEquals(expected,queue.dequeue());
    }
    @Test(expected=AssertionError.class)
    public void testDequeueNeg() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
    }
    @Test
    public void testIsFull() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("due to dynamic allocation of memory it is never full",false,queue.isFull());
    }
    @Test
    public void testIsEmpty() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        queue.dequeue();
        assertEquals(true,queue.isEmpty());
    }
    @Test
    public void testIsEmptyNeg() {
        QueueByLinkedList<Integer> queue=new QueueByLinkedList<Integer>();
        queue.enqueue(2);
        assertEquals(false,queue.isEmpty());
    }
}
