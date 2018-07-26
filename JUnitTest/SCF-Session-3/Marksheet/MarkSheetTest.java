package Marksheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkSheetTest {

    @Test
    public void testMaxGrade() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertEquals(80, markSheet.maximumGrade());
    }

    @Test
    public void testMaxGradeNegative() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertNotEquals(10, markSheet.maximumGrade());
    }

    @Test
    public void testMinGrade() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertEquals(10, markSheet.minimumGrade());
    }

    @Test
    public void testMinGradeNegative() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertNotEquals(80, markSheet.minimumGrade());
    }

    @Test
    public void testAverage() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertEquals(40.0, markSheet.average(), 0.001);
    }

    @Test
    public void testAverageNegative() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertNotEquals(10.0, markSheet.average(), 0.001);
    }

    @Test
    public void testPassed() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertEquals(33.33, markSheet.findPercentPassed(), 0.001);
    }

    @Test
    public void testPassedNegative() {
        Marksheet markSheet = new Marksheet(6, new int[] { 20, 40, 60, 30, 80,
                10 });
        assertNotEquals(33.0, markSheet.findPercentPassed(), 0.001);
    }

}
