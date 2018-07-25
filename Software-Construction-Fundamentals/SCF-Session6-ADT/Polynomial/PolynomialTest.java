import static org.junit.Assert.*;

import org.junit.Test;


public class PolynomialTest {

    @Test
    public void test() {
        Poly object=new Poly(new int[][]{{1,3},{2,5},{5,7},{2,3}});
        int degree=object.getDegree();
        assertEquals(5,degree);
        int num=object.evaluate(2);
        assertEquals(262,num);
        Poly object2=new Poly(new int[][]{{1,5},{4,7}});
        Poly object3=object2.addPolynomial(object2, object);
        assertArrayEquals(new int[][]{{5,7},{4,7},{8,2}},object3.getPolynomial());
     //   Poly object4=object.multiplyPolynomial(object, object2);

    }

}
