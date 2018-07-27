package SparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseTest {

    @Test
    public void testTranspose() {
        SparseMatrix object1=new SparseMatrix(new int[][]{{1,0,2,0},{0,3,0,0},{2,0,0,0},{0,0,6,0}});
        SparseMatrix object2=object1.transposeMatrix();
        int[][] expected={{1,0,2,0},{0,3,0,0},{2,0,0,6},{0,0,0,0}};
        assertArrayEquals(expected,object2.getMatrix());
    }
    @Test
    public void testAddition() {
        SparseMatrix object1=new SparseMatrix(new int[][]{{1,0,2,0},{0,3,0,0},{2,0,0,0},{0,0,6,0}});
        SparseMatrix object2=new SparseMatrix(new int[][]{{0,6,3,0},{9,0,0,0},{2,0,0,8},{0,0,0,0}});
        SparseMatrix object3=object1.add(object2);
        int[][] expected={{1,6,5,0},{9,3,0,0},{4,0,0,8},{0,0,6,0}};
        assertArrayEquals(expected,object3.getMatrix());
    }
    @Test
    public void testSymmetry() {
        SparseMatrix object1=new SparseMatrix(new int[][]{{2,0,2,0},{0,0,0,0},{2,0,0,0},{0,0,0,0}});
        assertEquals(true,object1.isSymmetric());
    }
    @Test
    public void testMultiplication() {
        SparseMatrix object1=new SparseMatrix(new int[][]{{2,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}});
        SparseMatrix object2=new SparseMatrix(new int[][]{{4,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}});
        SparseMatrix object3=object1.multiply(object2);
        int[][] expected={{8,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        assertArrayEquals(expected,object3.getMatrix());
    }

}
