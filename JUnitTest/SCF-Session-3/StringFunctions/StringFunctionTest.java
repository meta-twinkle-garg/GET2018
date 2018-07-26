package StringFunctions;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringFunctionTest {

    @Test
    public void testEqual() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "twinkle";
        String string2 = "twinkle";
        assertEquals(true, stringFunction.isEqual(string1, string2));
    }

    @Test
    public void testEqualNegative() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "twinkle";
        String string2 = "twinkle";
        assertNotEquals(false, stringFunction.isEqual(string1, string2));
    }

    @Test
    public void testChangeCase() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle";
        String string2 = "tWINKLE";
        assertEquals(string2, stringFunction.changeCase(string1));
    }

    public void testChangeCaseNegative() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle";
        String string2 = "tWINKLe";
        assertNotEquals(string2, stringFunction.changeCase(string1));
    }

    @Test
    public void testReverse() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle";
        String string2 = "elkniwT";
        assertEquals(string2, stringFunction.reverse(string1));
    }

    @Test
    public void testReverseNegative() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle";
        String string2 = "elkiwT";
        assertNotEquals(string2, stringFunction.reverse(string1));
    }

    @Test
    public void testLargest() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle is working in metacube";
        String string2 = "metacube";
        assertEquals(string2, stringFunction.largestWord(string1));
    }

    @Test
    public void testLargestNegative() {
        StringFunctions stringFunction = new StringFunctions();
        String string1 = "Twinkle is working in metacube";
        String string2 = "Twinkle";
        assertNotEquals(string2, stringFunction.largestWord(string1));
    }

}
