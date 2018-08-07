package PostfixEvaluation;


import DS_Assignment_1_Stack.StackByLinkedList;
import DS_Assignment_1_Stack.StackInterface;
/**
 * This class PostfixEvaluation contains a method to evaluate a postfix expression
 * Linked list implementation of stack has been used.
 * @author Twinkle-Garg
 *
 */
public class PostfixEvaluation {
    
    /**
     * This method accepts a postfix expression as string and evaluates it using stack
     * @param expression
     * @return result
     */
    public int evaluatePostfix(String expression) {
        StackInterface<Integer> stack = new StackByLinkedList<Integer>();
        int value=0,firstNumber,secondNumber;
        for(int count=0;count<expression.length();count++){
            if(Character.isDigit(expression.charAt(count))){ //If character is a digit, then push it
                stack.push(Integer.parseInt(String.valueOf(expression.charAt(count))));
            }else if(expression.charAt(count)==' '){ //Space indicates seperation of characters
                continue;
            }else{
                //Check for operators
                if(expression.charAt(count)=='+'){
                    firstNumber=stack.pop();
                    secondNumber=stack.pop();
                     value=secondNumber+firstNumber;
                }else if(expression.charAt(count)=='-'){
                    firstNumber=stack.pop();
                    secondNumber=stack.pop();
                    value=secondNumber-firstNumber;
                }else if(expression.charAt(count)=='*'){
                    firstNumber=stack.pop();
                    secondNumber=stack.pop();
                    value=secondNumber*firstNumber;
                }else if(expression.charAt(count)=='/'){
                    firstNumber=stack.pop();
                    secondNumber=stack.pop();
                    value=secondNumber/firstNumber;
                }else{
                    System.out.println("Not valid symbol..!!");
                }
                stack.push(value);
            }
        }
        return stack.pop(); //Last value in stack is the required result
    }
}
