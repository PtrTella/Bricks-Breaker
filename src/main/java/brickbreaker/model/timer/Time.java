package brickbreaker.model.timer;

public interface Time {

    void setTotal(final int totalTime);

    int getTotal();

    int getMinutes();

    int getSecondsInMinute();
}
