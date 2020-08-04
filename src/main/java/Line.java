import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Frame> frameList;
    public Line() {
        this.frameList = new ArrayList<>();
        initLine();
    }

    public void initLine() {
        this.frameList.add(new Frame(1));
    }

    public void nextLine() {
        Frame curFrame = getCurrentFrame();
        frameList.add(new Frame(curFrame.getFrame() + 1));
    }

    public Frame getCurrentFrame() {
        return frameList.get(frameList.size()-1);
    }
}
