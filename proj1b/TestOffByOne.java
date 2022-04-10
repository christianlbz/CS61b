import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    OffByOne ofo = new OffByOne();

    @Test
    public void TestOffByOne(){
        assertFalse(ofo.equalChars('a', 'z'));
        assertFalse(ofo.equalChars('a', 'e'));
        assertFalse(ofo.equalChars('a','a'));
        assertTrue(ofo.equalChars('a','b'));
        assertTrue(ofo.equalChars('r','q'));
        assertTrue(ofo.equalChars('l','k'));
        assertFalse(ofo.equalChars('a','B'));
    }
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. */

}
