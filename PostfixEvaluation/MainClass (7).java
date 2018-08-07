package PostfixEvaluation;

public class MainClass {
    public static void main(String args[]){
        PostfixEvaluation postfixInstance=new PostfixEvaluation();
        int value=postfixInstance.evaluatePostfix("2 3 1 * + 9 -");
        System.out.println(value);
    }
}
