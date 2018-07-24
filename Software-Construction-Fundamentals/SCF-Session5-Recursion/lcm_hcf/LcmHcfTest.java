package lcm_hcf;

import static org.junit.Assert.*;


import org.junit.Test;

public class LcmHcfTest {

	@Test
	public void textLcm() {
		LcmHcf testLcm=new LcmHcf();
		int testNumber1=12;
                int testNumber2=18;
		assertEquals(36,testLcm.lcm(testNumber1, testNumber2));

	}
	@Test
	public void textHcf() {
		LcmHcf testHcf=new LcmHcf();
		int testNumber1=12;
                int testNumber2=18;
		assertEquals(6,testHcf.hcf(testNumber1, testNumber2));

	}
}