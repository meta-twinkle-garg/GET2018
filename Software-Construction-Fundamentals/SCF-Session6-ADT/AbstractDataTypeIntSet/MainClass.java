package AbstractDataTypeIntSet;

public class MainClass {
public static void main(String args[]){
    IntSet object=new IntSet(new int[]{2,4,7,10});

    object.printElements();
    System.out.println(object.isMember(4));
    System.out.println(object.isMember(11));
    System.out.println(object.size());
    IntSet object2=new IntSet(new int[]{2,9});

    System.out.println(object.isSubSet(object2));
    IntSet object3;
    object3=object.complement();
    object3.printElements();
    System.out.println();
    IntSet object4;
    object4=object.union(object, object2);
    object4.printElements();
}
}
