package InfixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

    @Test
    public void testInfixToPostfix() {
        InfixToPostfix infixInstance=new InfixToPostfix();
        String expected=" a b c d + e - * +";
        assertEquals(expected,infixInstance.convertInfixToPostfix("(a+b*(c+d-e))"));
    }


}
