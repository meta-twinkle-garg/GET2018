package AreaOfShapes;
/**
 * AreaOfShapes class contains various methods which return area of folling:
 * 1. Square
 * 2. Triangle
 * 3. Rectangle
 * 4. Circle
 * @author Twinkle-Garg
 *
 */
public class AreaOfShapes {
	/**
	 * Find area of square.
	 * @param side of square of type double
	 * @return area of square of type double by computing side*side
	 */
	public double areaOfSquare(double side){
		return side*side;
	}
/**
 * Find area of triangle.
 * @param height of triangle of type double
 * @param width of triangle of type double
 * @return area of triangle of type double by computing (0.5*height*width)
 */
	public double areaOfTriangle(double height,double width){
		return (0.5*height*width);
	}
/**
 * Find area of rectangle.
 * @param height of rectangle of type double
 * @param width of rectangle of type double
 * @return area of rectangle of type double by computing (height*width)
 */
	public double areaOfRectangle(double length,double breadth){
		return length*breadth;
	}
	/**
	 * Find area of circle.
	 * @param radius of circle of type double
	 * @return area of circle of type double by computing 3.14*radius*radius
	 */
	public double areaOfCircle(double radius){
		return (3.14*radius*radius);
	}
}
