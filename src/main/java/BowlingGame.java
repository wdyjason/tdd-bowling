import java.util.List;

public class BowlingGame {
    private final int MIN_LEN = 11;
    private Line line;
    private int totGrade;

    public BowlingGame() {
        this.line = new Line();
        this.totGrade = 0;
    }

    public int calcGrade(List<Integer> input) {
        int inputSize = input.size();
        if (inputSize < MIN_LEN) Utils.throwFailException("size is illegal");

        for (int i = 0; i < inputSize; i ++) {

            if (line.getCurrentFrame().getFrame() == Frame.MAX_FRAME) {
                totGrade += calcLastFrameGrade(input.subList(i , inputSize));
                break;
            }

            int curThrow =input.get(i);
            int nextThrow = input.get(i + 1);
            int nextNextThrow = input.get(i + 2);

            if (curThrow < 0) Utils.throwFailException("negative number is not allowed");
            if (10 == curThrow + nextThrow) totGrade += nextNextThrow;

            totGrade += curThrow;
            line.getCurrentFrame().addThrowBall();

            if (line.getCurrentFrame().isFinished()) line.nextFrame();
        }
        return totGrade;
    }

    public int calcLastFrameGrade(List<Integer> lastFrame) {
        int lastFrameSize = lastFrame.size();
        if (lastFrameSize < 2 || lastFrameSize > 3) Utils.throwFailException("last frame size error");
        return lastFrame.stream().mapToInt(h -> h).sum();
    }
}
