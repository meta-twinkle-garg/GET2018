import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackByArray<Integer> stack = new StackByArray<Integer>(10);
        stack.push(5);
        stack.push(10);
        stack.push(7);
        stack.display();
        System.out.println("Top element is:" + stack.getTop());
        System.out.println("Element removed: "+ stack.pop());
        stack.display();
        StackByLinkedList<String> stackLinkedList=new StackByLinkedList<String>();
        stackLinkedList.push("abcd");
        stackLinkedList.push("twinkle");
        stackLinkedList.display();
        System.out.println("Top element is:" + stackLinkedList.getTop());
        System.out.println("Element removed: "+ stackLinkedList.pop());
        stackLinkedList.display();
    }
}