import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator{

    public boolean equalChars(char x, char y){
        if (Math.abs(x - y) == 1){
            return true;
        } else{
            return false;
        }
    }
}
