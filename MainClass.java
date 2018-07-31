package assignment;

public class MainClass {
    public static void main(String args[]) {
        StackByArray stackInstance = new StackByArray(20);
        stackInstance.push(2);
        stackInstance.push(5);
        stackInstance.push(10);
        stackInstance.display();
        System.out.println("Top index is: " + stackInstance.top());
        stackInstance.pop();
        stackInstance.display();

    }
}
