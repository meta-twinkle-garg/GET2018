
package GraphicsLibrary;

import java.util.Date;

/***
 * Triangle class contains methods to:
 * 1. return area
 * 2. return perimeter
 * 3. check if point is enclosed
 * 4. find origin
 * @author Twinkle-Garg
 *
 */
public class Triangle implements Shapes {
   Point point1,point2,point3,origin;
   int base,height,id;
   double area,primeter;
   Date timeStamp;
  
   /**
    * Constructor will initialize parameters
    * @param id
    * @param origin
    * @param height
    * @param base
    */
   public Triangle(int id,Point origin,int height,int base){
       this.id=id;
       this.origin=origin;
       this.height=height;
       this.base=base;
   }
   
   /**
    * return area of triangle
    */
    @Override
    public double getArea(){
        return 0.5*base*height;
    }

    /**
     * return perimeter of triangle
     */
    @Override
    public double getPerimeter() {
        return height+base+Math.sqrt(Math.pow(height,2)+Math.pow(base,2));
    }

    /**
     * check if point is enclosed in triangle
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        point1=origin;
        point2=new Point(origin.getX()+base,origin.getY());
        point3=new Point(origin.getX(),origin.getY()+height);
        float subArea1,subArea2,subArea3;
        subArea1=subArea(point1.getX(),point2.getX(),point.getX(),point1.getY(),point2.getY(),point.getY());
        subArea2=subArea(point2.getX(),point3.getX(),point.getX(),point2.getY(),point3.getY(),point.getY());
        subArea3=subArea(point1.getX(),point3.getX(),point.getX(),point1.getY(),point3.getY(),point.getY());
        return (float)(getArea())==subArea1+subArea2+subArea3;
    }
    
    /**
     * utility method to calculate area of triangle
     * @param x1
     * @param x2
     * @param x3
     * @param y1
     * @param y2
     * @param y3
     * @return area of triangle
     */
    public float subArea(int x1,int x2,int x3,int y1, int y2,int y3){
        return (float) ((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2.0);
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
    public int getId() {
        return id;
    }
    
    /**
     * return type of shape
     */
    public ShapeType getType(){
        return ShapeType.TRIANGLE;
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
