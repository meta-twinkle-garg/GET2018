
public class MainClass {
public static void main(String args[]){
    Poly object=new Poly(new int[][]{{1,3},{2,5},{5,7},{2,3}});
    object.display();
    int degree=object.getDegree();
    System.out.println("Degree is: "+degree);
    int num=object.evaluate(2);
    System.out.println("value of polynomial after taking x as 2 is: "+num);
    Poly object2=new Poly(new int[][]{{1,5},{4,7}});
    object2.display();
    System.out.print("Addition ");
    Poly object3=object2.addPolynomial(object2, object);
    object3.display();
    System.out.print("Multplication ");
    Poly object4=object.multiplyPolynomial(object, object2);
    object4.display();
}
}
