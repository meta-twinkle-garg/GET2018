package nQueens;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensTest {

	@Test
	public void test() {
		NQueens testInstance=new NQueens(4);
		boolean result=testInstance.solveProblem();
		assertEquals(result,true);
	}

}
