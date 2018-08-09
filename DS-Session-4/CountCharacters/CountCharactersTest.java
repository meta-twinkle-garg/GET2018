
import countdistinctcharacters.CountDistinctCharacters;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Twinkle Garg
 */
public class CountCharactersTest {
    
    @Test
    public void testCountCharacters() {
        CountDistinctCharacters countCharacters=new CountDistinctCharacters();
        assertEquals(7,countCharacters.countChracters("metacube"));
    }
    
    
}
