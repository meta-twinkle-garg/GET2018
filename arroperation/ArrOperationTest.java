package ArrOperation;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void textFixXy() {
		ArrOperation fixXy=new ArrOperation(4);
		int[] array={1, 4, 1, 5};
		int[] arrayResult=fixXy.rearrange(array,4,5);
		int[] result={1, 4, 5, 1};
		assertArrayEquals(arrayResult,result);

	}
	@Test
	public void testClumps() {
		ArrOperation clump=new ArrOperation(6);
		int[] array={1, 2, 2, 3, 3, 4};
		int numOfClumps=clump.findClumps(array);
		assertEquals(2,numOfClumps);

	}
	@Test
	public void testSplit(){
		ArrOperation split=new ArrOperation(5);
		int[] array={1,1,1,2,1};
		int index=split.splitArray(array);
		assertEquals(3,index);
	}
        @Test
	public void testSplit(){
		ArrOperation split=new ArrOperation(5);
		int[] array={1,1,1,2,1};
		int index=split.splitArray(array);
		assertEquals(3,index);
	}
        @Test
        public void testMirror(){
		ArrOperation largestMirror=new ArrOperation(5);
		int[] array={1,2,1,4};
		int size=largestMirror.findLargestMirror(array);
		assertEquals(3,size);
	}
}
