package GraphicsLibrary;

import java.util.Date;
/***
 * Square class contains methods to:
 * 1. return area
 * 2. return perimeter
 * 3. check if point is enclosed
 * 4. find origin
 * @author Twinkle-Garg
 *
 */
public class Square implements Shapes {
    Point origin;
    int side;
    double area,perimeter;
    int id;
    Date timeStamp;
    public Square(int id,Point point,int side){
        this.id=id;
        this.origin=point;
        this.side=side;
    }
    
    /***
     * returns area of square
     */
    @Override
    public double getArea() {
        area= side*side;
        return area;
    }
    
    /***
     * returns perimeter of square
     */
    @Override
    public double getPerimeter() {
        perimeter= 4*side;
        return perimeter;
    }
    
    /***
     * check if point is enclosed
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        if(point.getX()>origin.getX()&&point.getY()>origin.getY() &&
                point.getX()<(origin.getX()+side)&&point.getY()<(origin.getY()+side)){
            return true;
        }
        return false;
    }
    
    /***
     * return origin
     */
    @Override
    public Point getOrigin() {
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
        return ShapeType.SQUARE;
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
