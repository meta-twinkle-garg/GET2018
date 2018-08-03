/***
 * This class implements stack by linked list and contains operations:
 * 1. push an element into stack
 * 2. pop an element from stack
 * 3. display stack elements
 * 4. check if stack is empty
 * 5. return top element of stack
 * @author Twinkle-Garg
 *
 * @param <GenericType> specified by user
 */
public class StackByLinkedList<GenericType> implements
        StackInterface<GenericType> {
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

    Node top = null;

    /**
     * This method checks if stack is empty
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * This method pushes the value on top of stack
     */
    public void push(GenericType number) {
        Node node = new Node(number);
        node.next = top;
        top = node;
    }

    /**
     * This method pops out a value from stack and return it
     * @return popped value
     */
    public GenericType pop() {
        if (this.isEmpty()) {
            throw new AssertionError("Stack empty..!!");
        } else {
            GenericType hold = top.data;
            top = top.next;
            return hold;
        }
    }

    /**
     * This method displays elements of stack
     */
    public void display() {
        Node tempDisplay = top;
        while (tempDisplay != null) {
            System.out.println(tempDisplay.data);
            tempDisplay = tempDisplay.next;
        }
    }

    /**
     * @return top element of stack
     */
    public GenericType getTop() {
        isEmpty();
        return top.data;

    }
}