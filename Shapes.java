package GraphicsLibrary;

import java.util.Date;
/***
* Interface shapes contains various methods to be implemented on shapes:
* 1. return area
* 2. return perimeter
* 3. check if point is enclosed
* 4. return origin
* 5. return id
* 6. get type of shape
* 7. set timestamp
* 8. return time stamp
*/
public interface Shapes {
    public enum ShapeType {
        CIRCLE,RECTANGLE,SQUARE,TRIANGLE,REGULAR_POLYGON
        }
    double getArea();
    double getPerimeter();
    boolean isPointEnclosed(Point p);
    Point getOrigin();
    int getId();
    ShapeType getType();
    void setTimestamp(Date date);
    Date getTimestamp();
}
