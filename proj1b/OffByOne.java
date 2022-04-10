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

    public boolean isPalindrome(String word, CharacterComparator f){
        Deque dq = new Palindrome().wordToDeque(word);
        return  recursiveDeque(dq,f);
    }

    public boolean recursiveDeque(Deque<Character> dq,CharacterComparator f) {
        if (dq.size() == 1 | dq.size() == 0) {
            return true;
        } else {
            char first = dq.get(0);
            char last = dq.get(dq.size() - 1);
            int diff = Math.abs(first - last);
            if (diff == 0 | f.equalChars(first, last)) {
                dq.removeLast();
                dq.removeFirst();
                return recursiveDeque(dq,f);
            } else {
                return false;
            }
        }
    }


}
