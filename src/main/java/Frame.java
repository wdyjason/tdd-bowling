public class Frame {
    public static final int MAX_FRAME = 10;
    private int throwBall;
    private int frame;
    private boolean isFinished;

    public Frame(int frame) {
        this.frame = frame;
        this.throwBall = 0;
        this.isFinished = false;
    }

    public int getThrowBall() {
        return throwBall;
    }

    public void addThrowBall() {
        this.throwBall ++;
        if (throwBall == 2 && frame < MAX_FRAME) this.isFinished = true;
    }

    public int getFrame() {
        return frame;
    }

    public void completeThisFrame() {
        this.isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
