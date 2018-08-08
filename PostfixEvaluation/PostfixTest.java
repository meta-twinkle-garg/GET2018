package PostfixEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixTest {

    @Test
    public void testEvaluateExpression() {
        PostfixEvaluation postfixInstance=new PostfixEvaluation();
        int value=postfixInstance.evaluatePostfix("2 3 1 * + 9 -");
        assertEquals(-4,value);
    }
    @Test(expected=AssertionError.class)
    public void testEvaluateExpressionWhenExpressonIsInvalid() {
        PostfixEvaluation postfixInstance=new PostfixEvaluation();
        postfixInstance.evaluatePostfix("2 3 1 * + 9 - +");
    }

}
