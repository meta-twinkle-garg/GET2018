package hexDecimal;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegativeTest {

    @Test
    public void testHexToDecimalNeg() {
        Conversion objectTest = new Conversion();
        int number = objectTest.toInt("A8");
        assertNotEquals(160, number);
    }

    @Test
    public void testDecimalToHexNeg() {
        Conversion objectTest = new Conversion();
        String hexNumber = objectTest.toHex(168);
        assertNotEquals("A1", hexNumber);
    }

    @Test
    public void testAddNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "AA";
        String hexNumber2 = "B1";
        String result = objectTest.add(hexNumber1, hexNumber2);
        assertNotEquals("15C", result);
    }

    @Test
    public void testSubtractNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "AA";
        String hexNumber2 = "B1";
        String result = objectTest.diff(hexNumber2, hexNumber1);
        assertNotEquals("6", result);
    }

    @Test
    public void testMultiplyNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        String result = objectTest.mult(hexNumber1, hexNumber2);
        assertNotEquals("53", result);
    }

    @Test
    public void testDivisionNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "50";
        String hexNumber2 = "8";
        String result = objectTest.div(hexNumber1, hexNumber2);
        assertNotEquals("B", result);
    }

    @Test
    public void testGreaterNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        Boolean result = objectTest.isGreater(hexNumber1, hexNumber2);
        assertNotEquals(false, result);
    }

    @Test
    public void testLessNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "8";
        Boolean result = objectTest.isLess(hexNumber1, hexNumber2);
        assertNotEquals(true, result);
    }

    @Test
    public void testEqualNeg() {
        HexCalc objectTest = new HexCalc();
        String hexNumber1 = "A";
        String hexNumber2 = "A";
        Boolean result = objectTest.isEqual(hexNumber1, hexNumber2);
        assertNotEquals(false, result);
    }

}
