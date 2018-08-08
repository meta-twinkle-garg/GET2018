package InfixToPostfix;

import DS_Assignment_1_Stack.*;
/**
 * class InfixToPostfix uses linked list implementation of stack.
 * It contains method to convert infix expression to postfix expression
 * @author Twinkle-Garg
 *
 */
public class InfixToPostfix {

    /**
     * This method will return precedence of operator. Higher number indicates higher precedence.
     * @param operator
     * @return precedence
     */
    public int getPrecedence(String operator) {
        int precedence = 0;
        switch (operator) {
        case "||":
            precedence = 1;
            break;

        case "&&":
            precedence = 2;
            break;

        case "<":
        case ">":
        case ">=":
        case "<=":
            precedence = 3;
            break;
        case "+":
        case "-":
            precedence = 4;
            break;
        case "*":
        case "/":
            precedence = 5;
            break;
        case "!":
            precedence = 6;
            break;
        default:
            return 0;
        }
        return precedence;
    }

    /**
     * This method will convert infix expression to postfix expression
     * @param infix
     * @return postfix expression
     */
    public String convertInfixToPostfix(String infix) {
        String result = new String("");
        StackByLinkedList<Character> stack = new StackByLinkedList<>();
        try{for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += " " + c;
            }
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.getTop() != '(') {
                    result += " " + stack.pop();
                }
                    stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && getPrecedence(Character.toString(c)) <= getPrecedence(Character.toString(stack.getTop()))) {
                    result += " " + stack.pop();
                }

                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += " " + stack.pop();
        } catch(Exception exception){
            System.out.print(exception.getMessage());
        }

        return result;
    }
}
