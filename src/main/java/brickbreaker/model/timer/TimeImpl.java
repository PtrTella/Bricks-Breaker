package brickbreaker.model.timer;

public class TimeImpl implements Time {

    private static final int SECONDS_IN_MINUTE = 60;
    private int total;

    public TimeImpl(final int time) {
        this.setTotal(time);
    }

    @Override
    public void setTotal(int totalTime) {
        this.total = totalTime;
    }

    @Override
    public int getTotal() {
        return this.total;    
    }

    @Override
    public int getMinutes() {
        return this.total / SECONDS_IN_MINUTE;
    }

    @Override
    public int getSecondsInMinute() {
        return this.total % SECONDS_IN_MINUTE;
    }
}
