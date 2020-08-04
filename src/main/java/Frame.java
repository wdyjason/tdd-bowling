public class Frame {
    private final int MAX_FRAME = 10;
    private int throwBall;
    private int frame;
    private boolean hasFinished;
    public Frame(int frame) {
        this.frame = frame;
        this.throwBall = 0;
        this.hasFinished = false;
    }

    public int getThrowBall() {
        return throwBall;
    }

    public void addThrowBall() {
        this.throwBall ++;
        if (throwBall == 2 && frame < MAX_FRAME) this.hasFinished = true;
    }

    public int getFrame() {
        return frame;
    }

    public void completeThisFrame() {
        this.hasFinished = true;
    }

}
