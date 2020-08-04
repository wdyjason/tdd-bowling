import java.util.List;

public class BowlingGame {
    private final int MIN_SIZE = 11;
    private final int STRIKE_PINS = 10;
    private Line line;
    private int totGrade;

    public BowlingGame() {
        this.line = new Line();
        this.totGrade = 0;
    }

    public int calcGrade(List<Integer> input) {
        int inputSize = input.size();
        if (inputSize < MIN_SIZE) Utils.throwFailException("size is illegal");

        for (int i = 0; i < inputSize; i ++) {

            if (line.getCurrentFrame().getFrame() == Frame.MAX_FRAME) {
                totGrade += calcLastFrameGrade(input.subList(i , inputSize));
                break;
            }

            int curThrow =input.get(i);
            int nextThrow = input.get(i + 1);
            int nextNextThrow = input.get(i + 2);

            totGrade += curThrow;
            line.getCurrentFrame().addThrowBall();

            if (STRIKE_PINS == curThrow + nextThrow) totGrade += nextNextThrow;
            if (STRIKE_PINS == curThrow) {
                line.getCurrentFrame().completeThisFrame();
                totGrade += (nextThrow + nextNextThrow);
            }

            if (line.getCurrentFrame().isFinished()) line.nextFrame();

            if (curThrow < 0) Utils.throwFailException("negative number is not allowed");
            if (STRIKE_PINS < curThrow + nextThrow && line.getCurrentFrame().getThrowBall() == 2)
                Utils.throwFailException("second throw strike not allowed");
            if (STRIKE_PINS < curThrow) Utils.throwFailException("throw more than 10 is illegal");
        }
        return totGrade;
    }

    public int calcLastFrameGrade(List<Integer> lastFrame) {
        int lastFrameSize = lastFrame.size();
        if (lastFrameSize < 2 || lastFrameSize > 3) Utils.throwFailException("last frame size error");
        return lastFrame.stream().mapToInt(h -> h).sum();
    }
}
