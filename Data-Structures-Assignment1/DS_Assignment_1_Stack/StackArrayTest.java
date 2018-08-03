import static org.junit.Assert.*;

import org.junit.Test;

public class StackArrayTest {

    @Test
    public void testPushArray() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(10);
        Integer[] expected = { 4, 5, 10 };
        assertArrayEquals(expected, stackArray.returnStack());
    }

    @Test(expected = AssertionError.class)
    public void testPushArrayNeg() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(10);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(15);
    }

    @Test
    public void testPopArray() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(10);
        Integer expected = 10;
        assertEquals(expected, stackArray.pop());
    }

    @Test(expected = AssertionError.class)
    public void testPopArrayNeg() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        stackArray.pop();
        stackArray.pop();
    }

    @Test
    public void testisEmpty() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        stackArray.pop();
        assertEquals(true, stackArray.isEmpty());
    }

    @Test
    public void testisEmptyNeg() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        assertEquals(false, stackArray.isEmpty());
    }

    @Test
    public void testTop() {
        StackByArray<Integer> stackArray = new StackByArray<Integer>(5);
        stackArray.push(4);
        Integer expected = 4;
        assertEquals(expected, stackArray.getTop());
    }
}
