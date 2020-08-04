import java.util.List;

public class BowlingGame {
    public int calcGrade(List<Integer> input) {
        int inputSize = input.size();

        for (int i = 0; i < inputSize; i ++) {
            if (input.get(i) < 0) {
                throw new RuntimeException("negative number is not allowed");
            }
        }
        return 1;
    }
}
