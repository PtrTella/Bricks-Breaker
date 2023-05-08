package brickbreaker.model.timer;

public class TimerThread extends Thread {

    private Timer timer;
    private boolean running;

    public TimerThread(final Timer t) {
        this.timer = t;
        this.running = true;
    }

    public void setTimer(final Timer newT) {
        this.timer = newT;
    }

    public void stopTimer() {
        this.running = false;
    }

    @Override
    public void run() {
        while(this.running) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            this.timer.decTime();
        }
    }
}
