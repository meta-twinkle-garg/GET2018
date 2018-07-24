
package search;


import org.junit.Test;
import static org.junit.Assert.*;


public class SearchTest {
    @Test
    public void linearTest() {
        Search linearTest=new Search();
        int[] testArray={2,3,4,6,1,4};
        int element=6;
        int outputIndex=linearTest.linearSearch(testArray, 5, 0, element);
        assertEquals(3,outputIndex);
    }
    @Test
    public void binaryTest() {
        Search binaryTest=new Search();
        int[] testArray={1,2,3,4,5,7,9};
        int element=5;
        int outputIndex=binaryTest.binarySearch(testArray, 6, 0, element);
        assertEquals(4,outputIndex);
    }

    

}
