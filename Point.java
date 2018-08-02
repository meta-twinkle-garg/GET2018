package GraphicsLibrary;
/***
 * Point class contains methods to:
 * 1. return x coordinate
 * 2. return y coordinate
 */
public class Point {
    int x;
    int y;
    
    /**
    *Constructor will initialize coordinates
    */
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    /**
    * return x coordinate
    */
    int getX(){
        return x;
    }
    
    /**
    * return y coordinate
    */
    int getY(){
        return y;
    }

}
