package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

    @Test
    public void testPush() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(5);
        stackInstance.push(10);
        int[] stackArray = stackInstance.returnStack();
        int[] result = { 2, 5, 10 };
        assertArrayEquals(result, stackArray);
    }

    @Test
    public void testPushNeg() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(5);
        stackInstance.push(10);
        int[] stackArray = stackInstance.returnStack();
        int[] result = { 2, 5 };
        assertNotEquals(result.length, stackArray.length);
    }

    @Test
    public void testPop() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(5);
        stackInstance.push(10);
        stackInstance.pop();
        int[] stackArray = stackInstance.returnStack();
        int[] result = { 2, 5 };
        assertArrayEquals(result, stackArray);
    }

    @Test
    public void testPopNeg() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(5);
        stackInstance.push(10);
        stackInstance.pop();
        int[] stackArray = stackInstance.returnStack();
        int[] result = { 2, 5 };
        assertNotEquals(result[0], stackArray[1]);
    }

    @Test
    public void testEmpty() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.pop();
        boolean result = stackInstance.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void testEmptyNeg() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        boolean result = stackInstance.isEmpty();
        assertEquals(false, result);
    }

    @Test
    public void testTop() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(3);
        assertEquals(1, stackInstance.top());
    }

    @Test
    public void testTopNeg() {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(3);
        assertNotEquals(0, stackInstance.top());
    }

}
