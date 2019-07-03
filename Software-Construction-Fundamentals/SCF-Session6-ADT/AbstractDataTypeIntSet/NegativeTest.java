package AbstractDataTypeIntSet;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegativeTest {

    @Test
    public void testSizeNeg() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        int size=object.size();
        assertEquals(5,size);
    }
    @Test
    public void testSubSetNeg() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        IntSet object2=new IntSet(new int[]{2,4});
        boolean isSubset=object.isSubSet(object2);
        assertNotEquals(false,isSubset);
    }
    @Test
    public void testMemberNeg() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        boolean testMemberNegative=object.isMember(11);
        assertNotEquals(true,testMemberNegative);
    }


}
