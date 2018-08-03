import static org.junit.Assert.*;

import org.junit.Test;

public class QueueByArrayTest {

    @Test
    public void testEnqueue() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(5);
        queue.enqueue(2);
        queue.enqueue(3);
        Integer[] expected = { 2, 3 };
        assertArrayEquals(expected, queue.returnQueue());
    }

    @Test(expected = AssertionError.class)
    public void testEnqueueNeg() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(5);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    }

    @Test
    public void testDequeue() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(5);
        queue.enqueue(2);
        queue.enqueue(3);
        Integer expected = 2;
        assertEquals(expected, queue.dequeue());
    }

    @Test(expected = AssertionError.class)
    public void testDequeueNeg() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(5);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testIsFull() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(true, queue.isFull());
    }

    @Test
    public void testIsFullNeg() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(3);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(false, queue.isFull());
    }

    @Test
    public void testIsEmptyNeg() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(3);
        queue.enqueue(2);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        QueueByArray<Integer> queue = new QueueByArray<Integer>(3);
        queue.enqueue(2);
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }
}
