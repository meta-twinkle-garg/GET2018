package SparseMatrix;

public class MainClass {
public static void main(String args[]){
    SparseMatrix object1=new SparseMatrix(new int[][]{{0,0,2,0},{0,0,0,0},{2,0,0,0},{0,0,0,0}});
    object1.printMatrix();
    SparseMatrix object2=object1.transposeMatrix();
    object2.printMatrix();
    System.out.println(object1.isSymmetric());
    SparseMatrix object3=new SparseMatrix(new int[][]{{1,0,2,0},{0,0,0,0},{2,0,0,8},{0,0,0,0}});
    object3.printMatrix();
    SparseMatrix object4=object1.add(object3);
    object4.printMatrix();
    SparseMatrix object5=object3.multiply(object4);
    object5.printMatrix();
}
}
