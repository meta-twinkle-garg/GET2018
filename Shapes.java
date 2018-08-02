package GraphicsLibrary;

import java.util.Date;

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
