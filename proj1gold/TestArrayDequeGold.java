import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<Integer>();
        int sad1_return;
        int solution_return;
        String op = "";
        for (int i = 0; i < 10; i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne <= 0.5){
                sad1.addFirst(i);
                solution.addFirst(i);
                op += "addFirst(" + String.valueOf(i) + ")\n";
            } else {
                sad1.addLast(i);
                solution.addLast(i);
                op += "addLast(" + String.valueOf(i) + ")\n";
            }
        }
        for (int j = 0; j < 10; j++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne <= 0.5){
                sad1_return = sad1.removeFirst();
                solution_return = solution.removeLast();
                op += "removeFirst()\n";
                assertEquals(op, solution_return, sad1_return);
            } else {
                sad1_return = sad1.removeLast();
                solution_return = solution.removeLast();
                op += "removeLast()";
                assertEquals(solution_return, sad1_return);
            }
        }
    }
}
