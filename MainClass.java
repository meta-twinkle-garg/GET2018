package GraphicsLibrary;


import java.util.Arrays;

import GraphicsLibrary.Shapes.ShapeType;

public class MainClass {
    public static void main(String args[]){
        Screen screen=new Screen(new Point(100,100));
        
        Shapes rectangle= ShapeFactory.createShape(ShapeType.RECTANGLE,new Point(4,5), Arrays.asList(4,6));
       screen.addShape(rectangle);
       
       Shapes square= ShapeFactory.createShape(ShapeType.SQUARE,new Point(3,7), Arrays.asList(4));
       screen.addShape(square);
       
       Shapes circle= ShapeFactory.createShape(ShapeType.CIRCLE,new Point(2,5), Arrays.asList(7));
       screen.addShape(circle);
       
       Shapes triangle= ShapeFactory.createShape(ShapeType.TRIANGLE,new Point(2,2), Arrays.asList(4,6));
       screen.addShape(triangle);
       
       System.out.println("For Rectangle: we have checked for (5,6)");
       System.out.println("Area= "+rectangle.getArea());
       System.out.println("Perimeter= "+rectangle.getPerimeter());
       System.out.println(rectangle.isPointEnclosed(new Point(5,6)));
       
       System.out.println("For Square: we have checked for (5,6)");
       System.out.println("Area= "+rectangle.getArea());
       System.out.println("Perimeter= "+rectangle.getPerimeter());
       System.out.println(rectangle.isPointEnclosed(new Point(5,6)));
       
       System.out.println("area"+circle.getArea());
       System.out.println("circumference"+circle.getPerimeter());
       
    }
}
