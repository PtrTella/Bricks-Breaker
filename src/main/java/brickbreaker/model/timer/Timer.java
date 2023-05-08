package brickbreaker.model.timer;

public interface Timer {

    void setTimer(final int time);

    void decTime();

    Time getTime();

    String toString();
}
