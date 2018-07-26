package AreaOfShapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class AreaTest {

    @Test
    public void testSquare() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertEquals(9.0, findArea.areaOfSquare(3), 0.001);
    }

    @Test
    public void testSquareNegative() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertNotEquals(10.0, findArea.areaOfSquare(3), 0.001);
    }

    @Test
    public void testRectangle() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertEquals(30.0, findArea.areaOfRectangle(6, 5), 0.001);
    }

    @Test
    public void testRectangleNegative() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertNotEquals(20.0, findArea.areaOfRectangle(6, 5), 0.001);
    }

    @Test
    public void testCircle() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertEquals(153.86, findArea.areaOfCircle(7), 0.001);
    }

    @Test
    public void testCircleNegative() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertNotEquals(153.00, findArea.areaOfCircle(7), 0.001);
    }

    @Test
    public void testTriangle() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertEquals(18.0, findArea.areaOfTriangle(4, 9), 0.001);
    }

    @Test
    public void testTriangleNegative() {
        AreaOfShapes findArea = new AreaOfShapes();
        assertNotEquals(18.7, findArea.areaOfTriangle(4, 9), 0.001);
    }

}
