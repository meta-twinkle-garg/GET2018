package GraphicsLibrary;


import java.util.Date;
import java.util.HashMap;


import GraphicsLibrary.Shapes.ShapeType;

import java.util.Set;
/***
 * Screen class contains methods to:
 * 1. add a shape to screen
 * 2. delete shape from screen
 * 3. delete shape of a type from screen
 * 4. sort according to distance from origin
 * 5. sort according to area
 * 6. sort according to perimeter
 * 7. sort according to timestamp
 * @author twinkle-Garg
 *
 */
public class Screen {
    HashMap<Shapes, Date> timeStamp = new HashMap<>();
    Point endCoordinates;
    Point startCoordinates;
    
    /***
     * constructor will initialize screen coordinates
     * @param point
     */
    Screen(Point point){
        endCoordinates=point;
        startCoordinates=new Point(0,0);
    }
    
    /***
     * Add a shape to screen
     * @param shape
     */
    void addShape(Shapes shape){
        Date timestamp = new Date();
        shape.setTimestamp(timestamp);
        timeStamp.put(shape,timestamp);

    }
    
    /***
     * delete a shape from screen
     * @param shape
     */
    void deleteShape(Shapes shape){
        timeStamp.remove(shape);
    }
    
    /***
     * delete all shapes of specific type
     * @param type
     */
    void deleteAll(ShapeType type){
        Set<Shapes> shapeSet=timeStamp.keySet();
        for(Shapes shape:shapeSet){
            if(shape.getType()==type){
                timeStamp.remove(shape);
            }
        }
    }
    
    /***
     * Sort all shapes according to area
     * @return array of sorted shapes
     */
    public Shapes[] sortByArea(){
        Set<Shapes> shapeSet= timeStamp.keySet();
        Shapes[] arrayOfshapes=new Shapes[timeStamp.size()];
        Double[] arrayOfArea=new Double[timeStamp.size()];
        int index=0;
        for(Shapes shape:shapeSet){
            arrayOfshapes[index]=shape;
            arrayOfArea[index++]=shape.getArea();
        }
        return sortFunction(arrayOfshapes,arrayOfArea);
    }
    
    /***
     * Sort all shapes according to perimeter
     * @return array of sorted shapes
     */
    public Shapes[] sortByPerimeter(){
        Set<Shapes> shapeSet= timeStamp.keySet();
        Shapes[] arrayOfshapes=new Shapes[timeStamp.size()];
        Double[] arrayOfPerimeter=new Double[timeStamp.size()];
        int index=0;
        for(Shapes shape:shapeSet){
            arrayOfshapes[index]=shape;
            arrayOfPerimeter[index++]=shape.getPerimeter();
        }
        return sortFunction(arrayOfshapes,arrayOfPerimeter);
    }
    
    /***
     * Sort all shapes according to distance
     * @return array of sorted shapes
     */
    public Shapes[] sortByDistance(){
        Set<Shapes> shapeSet= timeStamp.keySet();
        Shapes[] arrayOfshapes=new Shapes[timeStamp.size()];
        Double[] arrayOfPerimeter=new Double[timeStamp.size()];
        int index=0;
        for(Shapes shape:shapeSet){
            arrayOfshapes[index]=shape;
            Point origin=shape.getOrigin();
            double distance=Math.sqrt(Math.pow(origin.getX(),2)+Math.pow(origin.getY(),2));
            arrayOfPerimeter[index++]=distance;
        }
        return sortFunction(arrayOfshapes,arrayOfPerimeter);
    }
    
    /***
     * Utility method to sort shapes
     * @param arrayOfShapes
     * @param arrayToSort
     * @return sorted array
     */
    public Shapes[] sortFunction(Shapes[] arrayOfShapes,Double[] arrayToSort){
        for(int count=0;count<timeStamp.size();count++){
            for(int count2=count+1;count2<timeStamp.size();count2++){
                if(arrayToSort[count]>arrayToSort[count2]){
                    Shapes shape=arrayOfShapes[count];
                    arrayOfShapes[count]=arrayOfShapes[count2];
                    arrayOfShapes[count2]=shape;
                    Double swapVariable=arrayToSort[count];
                    arrayToSort[count]=arrayToSort[count2];
                    arrayToSort[count2]=swapVariable;
                }
            }
        }
        return arrayOfShapes;
    }
    
    /***
     * Sort all shapes according to timestamp
     * @return sorted array of shapes
     */
    public Shapes[] sortByTimestamp(){
        Set<Shapes> shapeSet= timeStamp.keySet();
        Shapes[] arrayOfshapes=new Shapes[timeStamp.size()];
        Date[] arrayOfTimestamp=new Date[timeStamp.size()];
        int index=0;
        for(Shapes shape:shapeSet){
            arrayOfshapes[index]=shape;
            arrayOfTimestamp[index++]=timeStamp.get(shape);
        }
        for(int count=0;count<timeStamp.size();count++){
            for(int count2=count+1;count2<timeStamp.size();count2++){
                if(arrayOfTimestamp[count].after(arrayOfTimestamp[count2])){
                    Shapes shape=arrayOfshapes[count];
                    arrayOfshapes[count]=arrayOfshapes[count2];
                    arrayOfshapes[count2]=shape;
                    Date swapVariable=arrayOfTimestamp[count];
                    arrayOfTimestamp[count]=arrayOfTimestamp[count2];
                    arrayOfTimestamp[count2]=swapVariable;
                }
            }
        }
        return arrayOfshapes;
    }
    
}
