package InfixToPostfix;

public class MainClass {

    public static void main(String args[]){
        InfixToPostfix infixInstance=new InfixToPostfix();
        System.out.println(infixInstance.convertInfixToPostfix("(a+b*(c+d-e))"));
    }
}
