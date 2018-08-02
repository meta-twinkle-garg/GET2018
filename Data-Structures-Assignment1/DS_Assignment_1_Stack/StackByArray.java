


/***
 * This class implements stack by array and contains operations:
 * 1. push an element into stack
 * 2. pop an element from stack
 * 3. display stack elements
 * 4. check if stack is empty
 * 5. return top element of stack
 * @author Twinkle-Garg
 *
 * @param <GenericType> specified by user
 */

public class StackByArray<GenericType> implements StackInterface<GenericType> {
    private GenericType[] stackArray;
    private int size;
    private static int top;

    /**
     * Constructor initializes the array of stack
     * @param size
     */
    public StackByArray(int size) {
        this.size = size;
        stackArray = (GenericType[]) new Object[size];
        top = -1;
    }

    /**
     * This method pushes the value on top of stack
     */
    public void push(GenericType value) {
        if (top == size - 1) {
            throw new AssertionError("Stack underflow");
        } else {
            stackArray[++top] = value;

        }
    }

    /**
     * This method pops out a value from stack and return it
     * @return popped value
     */
    public GenericType pop() {
        if (this.isEmpty()) {
            throw new AssertionError("Stack underflow");
        } else {
            GenericType value = stackArray[top--];
            return value;
        }
    }

    /**
     * This method checks if stack is empty
     * @return true if empty else false
     */
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @returntop element of stack
     */
    public GenericType getTop() {
        return stackArray[top];
    }

    /**
     * @return stack
     */
    public GenericType[] returnStack() {
        GenericType[] newArray = (GenericType[]) new Object[top + 1];
        for (int count = 0; count <= top; count++) {
            newArray[count] = stackArray[count];
        }
        return newArray;
    }

    /**
     * This method displays elements of stack
     */
    public void display() {
        System.out.println("The list is: ");
        for (int count = 0; count <= top; count++) {
            System.out.print(" " + stackArray[count]);
        }
        System.out.println();
    }

}
