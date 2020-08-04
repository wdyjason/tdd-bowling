import java.util.List;

public class BowlingGame {
    private final int MIN_LEN = 11;
    Line line = new Line();

    public int calcGrade(List<Integer> input) {
        int totGrade = 0;
        int inputSize = input.size();
        if (inputSize < MIN_LEN) Utils.throwFailException("size is illegal");

        for (int i = 0; i < inputSize; i ++) {
            int curThrow =input.get(i);
            if (curThrow < 0) Utils.throwFailException("negative number is not allowed");
            totGrade += curThrow;
            line.getCurrentFrame().addThrowBall();
        }
        return totGrade;
    }
}
