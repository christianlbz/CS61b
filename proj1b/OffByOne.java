import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y){
        if (Math.abs(x - y) == 1){
            return true;
        } else{
            return false;
        }
    }



    public boolean isPalindrome(String word){
        Deque dq = new Palindrome().wordToDeque(word);
        return  recursiveDeque(dq);
    }

    public boolean recursiveDeque(Deque<Character> dq) {
        if (dq.size() == 1 | dq.size() == 0) {
            return true;
        } else {
            char first = dq.get(0);
            char last = dq.get(dq.size() - 1);
            int diff = Math.abs(first - last);
            if (diff == 0 | diff == 1) {
                dq.removeLast();
                dq.removeFirst();
                return recursiveDeque(dq);
            } else {
                return false;
            }
        }
    }

    @Test
    public void TestIsPalindrome(){
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("axxa"));
        assertTrue(isPalindrome("abfba"));
        assertFalse(isPalindrome("xqg"));
        assertFalse(isPalindrome("xqhlwf"));
    }
}
