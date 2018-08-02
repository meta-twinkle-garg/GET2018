import static org.junit.Assert.*;

import org.junit.Test;


public class StackLinkedList {

    @Test
    public void testPushArray() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        stackLinkedList.push("mango");
        String expected="mango";
        assertEquals(expected,stackLinkedList.getTop());
    }
    
    @Test
    public void testPushArrayNeg() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        stackLinkedList.push("mango");
        String expected="apple";
        assertNotEquals(expected,stackLinkedList.getTop());
    }
    
    @Test
    public void testPopArray() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        stackLinkedList.push("mango");
        String expected="mango";
        assertEquals(expected,stackLinkedList.pop());
    }
    
    @Test(expected = AssertionError.class)
    public void testPopArrayNeg() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        stackLinkedList.pop();
        stackLinkedList.pop();
    }
    
    @Test
    public void testisEmpty() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        stackLinkedList.pop();
        assertEquals(true,stackLinkedList.isEmpty());
    }
    
    @Test
    public void testisEmptyNeg() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        assertEquals(false,stackLinkedList.isEmpty());
    }
    
    @Test
    public void testTop() {
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("apple");
        String expected="apple";
        assertEquals(expected,stackLinkedList.getTop());
    }

}
