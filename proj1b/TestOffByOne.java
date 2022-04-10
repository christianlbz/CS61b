import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void TestOffByOne(){
        assertFalse(offByOne.equalChars('a', 'z'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('a','a'));
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('r','q'));
        assertTrue(offByOne.equalChars('l','k'));
        assertFalse(offByOne.equalChars('a','B'));
    }
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. */

}
