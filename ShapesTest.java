package GraphicsLibrary;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import GraphicsLibrary.Shapes.ShapeType;

public class ShapesTest {
    Screen screen=new Screen(new Point(100,100));
    
    Shapes rectangle= ShapeFactory.createShape(ShapeType.RECTANGLE,new Point(4,5), Arrays.asList(4,6));
   
   Shapes square= ShapeFactory.createShape(ShapeType.SQUARE,new Point(3,7), Arrays.asList(2));
   
   Shapes circle= ShapeFactory.createShape(ShapeType.CIRCLE,new Point(8,8), Arrays.asList(7));
   
   Shapes triangle= ShapeFactory.createShape(ShapeType.TRIANGLE,new Point(2,2), Arrays.asList(4,3));
    @Test
    public void testAreaRectangle() {
        assertEquals(24,rectangle.getArea(),0.001);
    }
    @Test
    public void testAreaSquare() {
        assertEquals(4,square.getArea(),0.001);
    }
    @Test
    public void testAreaCircle() {
        assertEquals(153.86,circle.getArea(),0.001);
    }
    @Test
    public void testAreaTriangle() {
        assertEquals(6,triangle.getArea(),0.001);
    }
    @Test
    public void testPerimeterTriangle() {
        assertEquals(12,triangle.getPerimeter(),0.001);
    }
    @Test
    public void testPerimeterCircle() {
        assertEquals(43.96,circle.getPerimeter(),0.001);
    }
    @Test
    public void testPerimeterSquare() {
        assertEquals(8,square.getPerimeter(),0.001);
    }
    @Test
    public void testPerimeterRectangle() {
        assertEquals(20,rectangle.getPerimeter(),0.001);
    }
    @Test
    public void testPointRectangle() {
        assertEquals(false,rectangle.isPointEnclosed(new Point(4,5)));
    }
    @Test
    public void testPointSquare() {
        assertEquals(false,square.isPointEnclosed(new Point(4,5)));
    }
    @Test
    public void testPointCircle() {
        assertEquals(true,circle.isPointEnclosed(new Point(4,5)));
    }
    @Test
    public void testPointTriangle() {
        assertEquals(false,triangle.isPointEnclosed(new Point(4,5)));
    }
    @Test
    public void testSortByArea() {
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(triangle);
        screen.addShape(circle);
        Shapes[] expected={square,triangle,rectangle,circle};
        assertArrayEquals(expected,screen.sortByArea());
    }
    @Test
    public void testSortByPerimeter() {
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(triangle);
        screen.addShape(circle);
        Shapes[] expected={square,triangle,rectangle,circle};
        assertArrayEquals(expected,screen.sortByPerimeter());
    }
    @Test
    public void testSortBytimeStamp() {
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(triangle);
        screen.addShape(circle);
        Shapes[] expected={rectangle,square,triangle,circle};
        assertArrayEquals(expected,screen.sortByTimestamp());
    }
    @Test
    public void testSortByDistance() {
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(triangle);
        screen.addShape(circle);
        Shapes[] expected={triangle,circle,rectangle,square};
        assertArrayEquals(expected,screen.sortByDistance());
    }
    @Test
    public void testDelete() {
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(triangle);
        screen.addShape(circle);
        screen.deleteShape(circle);
        Shapes[] expected={square,triangle,rectangle};
        assertArrayEquals(expected,screen.sortByArea());
    }
    
}
