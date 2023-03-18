package main.model.timer;

public class TimerImpl implements Timer{

    private Time remainedTime;

    public TimerImpl (final int time) {
        this.remainedTime = new TimeImpl(time);
    }

    @Override
    public synchronized void setTimer(final int time) {
        this.remainedTime.setTotal(time);
    }

    @Override
    public synchronized void decTime() {
        int currentTimeAmount = this.remainedTime.getTotal();
        this.remainedTime.setTotal(currentTimeAmount - 1);
    }

    @Override
    public Time getTime() {
        return this.remainedTime;
    }
    
    @Override
    public String toString() {
        return String.format("%02d", this.getTime().getMinutes() + ":" + String.format("%02d", this.getTime().getSecondsInMinute()));
    }
}
