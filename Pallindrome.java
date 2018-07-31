package pallindrome;

import java.util.*;

public class Pallindrome {
    Stack<Character> stackOfCharacter = new Stack<Character>();

    public boolean isPallindrome(String string) {
        for (int count = 0; count < string.length(); count++) {
            stackOfCharacter.push(string.charAt(count));
        }
        String reverse = "";
        for (int count2 = 0; count2 < string.length(); count2++) {
            reverse = reverse + stackOfCharacter.pop();
        }
        System.out.println("Reversed string is: " + reverse);
        if (string.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

}
