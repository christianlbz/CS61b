import org.junit.Test;
import static org.junit.Assert.*;

public class OffByN implements CharacterComparator{

    private int diff;
    public OffByN(int N){
        this.diff = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        if(Math.abs(x - y) == this.diff){
            return true;
        } else {
            return false;
        }
    }

}
