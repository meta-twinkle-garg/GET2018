package pallindrome;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        Pallindrome objectPallindrome = new Pallindrome();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = input.next();
        if (objectPallindrome.isPallindrome(string)) {
            System.out.println("Pallindrome");
        } else {
            System.out.println("Not a Pallindrome");
        }
        input.close();
    }
}
