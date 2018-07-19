package stackLinkedList;
import java.util.*;
public class User {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackClass stack = new StackClass();
        while (true) {
            System.out.println("\nStack MENU(size -- 10)");
            System.out.println("1. Add an element");
            System.out.println("2. See the Top element.");
            System.out.println("3. Remove top element.");
            System.out.println("4. Display stack elements.");
            System.out.println("5. Exit");
            System.out.println("Select your choice: ");
            int choice = in.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter an Element : ");
                stack.push(in.nextInt());
                break;
 
            case 2:
                System.out.printf("Top element is: {%d}", stack.topValue());
                break;
 
            case 3:
                System.out.printf("Element removed: {%d}", stack.pop());
                break;
 
            case 4:
                stack.display();
                break;
 
            case 5:
            default:
                System.exit(0);
                break;
            }
            System.out.printf("\n");
            
        }
    }
}
