package AbstractDataTypeIntSet;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class IntSetTest {

    @Test
    public void testMember() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        boolean testMemberPositive=object.isMember(4);
        assertEquals(true,testMemberPositive);
    }
    @Test
    public void testMemberNeg() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        boolean testMemberNegative=object.isMember(11);
        assertNotEquals(true,testMemberNegative);
    }
    @Test
    public void testSize() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        int size=object.size();
        assertEquals(4,size);
    }
    @Test
    public void testSubSet() {
        IntSet object=new IntSet(new int[]{2,4,7,10});
        IntSet object2=new IntSet(new int[]{2,4});
        boolean isSubset=object.isSubSet(object2);
        assertEquals(true,isSubset);
    }
    @Test
    public void testComplement() {
        IntSet object=new IntSet(new int[]{2,4,7,10});   
        IntSet object2;
        object2=object.complement();
        int[] array=new int[1000];
        for(int count=1;count<=1000;count++){
            if(count==2||count==7||count==4||count==10){
                array[count-1]=0;
            }else{
            array[count-1]=count;
            }
        }
        int[] resultArray=object2.getArray();
        assertArrayEquals(array,resultArray);
    }
    @Test
    public void testUnion() {
        IntSet object,object2,result;
        object=new IntSet(new int[]{2,4,9});
        object2=new IntSet(new int[]{2,4,7,10});
        result=object.union(object2, object);
        IntSet checkUnion=new IntSet(new int[]{2,4,7,9,10});

        assertArrayEquals(checkUnion.getArray(),result.getArray());
    }



}
