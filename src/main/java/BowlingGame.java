import java.util.List;

public class BowlingGame {
    private final int MIN_LEN = 11;

    public int calcGrade(List<Integer> input) {
        int inputSize = input.size();
        if (inputSize < MIN_LEN) Utils.throwFailException("size is illegal");

        for (int i = 0; i < inputSize; i ++) {
            if (input.get(i) < 0) Utils.throwFailException("negative number is not allowed");
        }
        return 1;
    }
}
