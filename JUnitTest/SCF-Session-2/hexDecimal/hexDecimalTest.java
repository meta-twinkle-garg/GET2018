package hexDecimal;

import static org.junit.Assert.*;

import org.junit.Test;

public class hexDecimalTest {

    @Test
    public void testHexToDecimal() {
        Conversion objectTest = new Conversion();
        int number = objectTest.toInt("A8");
        assertEquals(168, number);
    }

    @Test
    public void testDecimalToHex() {
        Conversion objectTest = new Conversion();
        String hexNumber = objectTest.toHex(168);
        assertEquals("A8", hexNumber);
    }

    @Test
    public void testAdd() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "AA";
        String hexNumber2 = "B1";
        String result = objectTest.add(hexNumber1, hexNumber2);
        assertEquals("15B", result);
    }

    @Test
    public void testSubtract() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "AA";
        String hexNumber2 = "B1";
        String result = objectTest.diff(hexNumber2, hexNumber1);
        assertEquals("7", result);
    }

    @Test
    public void testMultiply() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        String result = objectTest.mult(hexNumber1, hexNumber2);
        assertEquals("50", result);
    }

    @Test
    public void testDivision() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "50";
        String hexNumber2 = "8";
        String result = objectTest.div(hexNumber1, hexNumber2);
        assertEquals("A", result);
    }

    @Test
    public void testGreater() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        Boolean result = objectTest.isGreater(hexNumber1, hexNumber2);
        assertEquals(true, result);
    }

    @Test
    public void testLess() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        Boolean result = objectTest.isLess(hexNumber1, hexNumber2);
        assertEquals(false, result);
    }

    @Test
    public void testEqual() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "A";
        Boolean result = objectTest.isEqual(hexNumber1, hexNumber2);
        assertEquals(true, result);
    }

}
