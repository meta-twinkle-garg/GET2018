package GraphicsLibrary;


import java.util.List;

import GraphicsLibrary.Shapes.ShapeType;

public class ShapeFactory {
    static int count;
    static Shapes createShape(ShapeType type,Point point,List<Integer> list){
        Shapes shape=null;
        int id=count++;
        switch(type){
        case RECTANGLE: int length=list.get(0);
                        int breadth=list.get(1);
                        shape=new Rectangle(id,point,length,breadth);
                        break;
                        
        case CIRCLE: int radius=list.get(0);
                     shape=new Circle(id,point,radius);
                     break;
                     
        case SQUARE:int side=list.get(0);
                    shape=new Square(id,point,side);
                     break;
                     
        case TRIANGLE:int height=list.get(0);
                      int base=list.get(1);
                      shape=new Triangle(id,point,height,base);
                      break;
                      
        default:System.out.println("Not appropriate properties");
            break;
        }
        return shape;
    }
}
