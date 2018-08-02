package GraphicsLibrary;

import java.util.Date;
/***
 * Circle class contains methods to:
 * 1. return area
 * 2. return perimeter
 * 3. check if point is enclosed
 * 4. find origin
 * @author Twinkle-Garg
 *
 */
public class Circle implements Shapes{
    Point origin,center;
    int radius;
    double area,perimeter;
    int id;
    Date timeStamp;
    
    /**
     * Constructor will initialize parameters
     * @param id
     * @param center
     * @param radius
     */
    public Circle(int id,Point center,int radius){
        this.id=id;
        this.center=center;
        this.radius=radius;
    }
  
    /**
     * return area of circle
     */
    @Override
    public double getArea() {
        area= (3.14*radius*radius);
        return area;
    }

    /***
     * return perimeter of circle
     */
    @Override
    public double getPerimeter() {
        perimeter= (2*3.14*radius);
        return perimeter;
    }

    /***
     * check if point is enclosed
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        double distance;
        distance=Math.sqrt(Math.pow(point.getX()-center.getX(),2)+Math.pow(point.getY()-center.getY(),2));
        if(distance<=radius){
            return true;
        }
        return false;
    }

    /***
     * return origin of circle
     */
    @Override
    public Point getOrigin() {
        double distanceFromOrigin,diffrence;
        distanceFromOrigin=Math.sqrt(Math.pow(center.getX(),2)+Math.pow(center.getY(),2));
        diffrence=distanceFromOrigin-radius;
        int xCoordinate,yCoordinate;
        xCoordinate=(int) (diffrence*center.getX()/distanceFromOrigin);
        yCoordinate=(int) (diffrence*center.getY()/(distanceFromOrigin));
        origin=new Point(xCoordinate,yCoordinate);
        return origin;
    }

    /***
     * return id
     */
    @Override
    public int getId() {
        return id;
    }
    
    /***
     * return type of shape
     */
    public ShapeType getType(){
        return ShapeType.CIRCLE;
    }
    
    /***
     * set timestamp
     */
    public void setTimestamp(Date date){
        this.timeStamp=date;
    }
    
    /***
     * return timestamp
     */
    public Date getTimestamp(){
        return timeStamp;
    }

}
