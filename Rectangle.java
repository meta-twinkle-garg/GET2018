package GraphicsLibrary;

import java.util.Date;


/***
 * Rectangle class contains methods to:
 * 1. return area
 * 2. return perimeter
 * 3. check if point is enclosed
 * 4. find origin
 * @author Twinkle-Garg
 *
 */
public class Rectangle implements Shapes {
    Point origin;
    int length,breadth;
    double area,perimeter;
    int id;
    Date timeStamp;

   /**
    * Constructor will initialize parameters
    * @param id
    * @param point
    * @param length
    * @param breadth
    */
    public Rectangle(int id,Point point,int length,int breadth){
        origin=point;
        this.length=length;
        this.breadth=breadth;
        this.id=id;
    }
    
    /**
     * return area of rectangle
     */
    @Override
    public double getArea() {
        area=length*breadth;
        return area;
    }

    /**
     * return perimeter of rectangle
     */
    @Override
    public double getPerimeter() {
        perimeter=2*(length+breadth);
        return perimeter;
    }

    /**
     * check if point is enclosed in rectangle
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        if(point.getX()>origin.getX()&&point.getX()<(origin.getX()+length)
                && point.getY()>origin.getY()&&point.getY()<(origin.getY()+breadth)){
                    return true;
                }
        return false;
    }

    /**
     * return origin
     */
    @Override
    public Point getOrigin() {
        return origin;
    }
    
    /**
     * return id
     */
    @Override
    public int getId(){
        return id;
    }
    
    /**
     * return type of shape
     */
    public ShapeType getType(){
        return ShapeType.RECTANGLE;
    }
    
    /**
     * set timestamp
     */
    public void setTimestamp(Date date){
        this.timeStamp=date;
    }
    
    /**
     * return timestamp
     */
    public Date getTimestamp(){
        return timeStamp;
    }

}
