package pallindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class PallindromeTest {

    @Test
    public void testPallindrome() {
        Pallindrome objectPallindrome = new Pallindrome();
        assertEquals(true,objectPallindrome.isPallindrome("malayalam"));
    }
    @Test
    public void testPallindromeNeg() {
        Pallindrome objectPallindrome = new Pallindrome();
        assertEquals(false,objectPallindrome.isPallindrome("twinkle"));
    }


}
