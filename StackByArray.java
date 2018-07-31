package assignment;

public class StackByArray {
    private int[] stack_arr;
    private int size;
    private static int top;

    public StackByArray(int size) {
        this.size = size;
        stack_arr = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
        } else {
            stack_arr[++top] = value;

        }
    }

    public void pop() {
        if (!this.isEmpty()) {
            int value = stack_arr[top--];
            System.out.println("Popped value is: " + value);
        } else {
            System.out.println("Stack underflow");
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int top() {
        return top;
    }

    public int[] returnStack() {
        int[] stackArray = new int[top + 1];
        for (int count = 0; count <= top; count++) {
            stackArray[count] = stack_arr[count];
        }
        return stackArray;
    }

    public void display() {
        System.out.println("The list is: ");
        for (int count = 0; count <= top; count++) {
            System.out.print(" " + stack_arr[count]);
        }
        System.out.println();
    }

}
