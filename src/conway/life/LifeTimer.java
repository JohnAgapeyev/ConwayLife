package conway.life;

import java.util.Timer;

public class LifeTimer extends Timer {

    private LifeTimerTask updateTask;

    private boolean timerActive;

    private final long timerPeriod = 100;

    private final LifePanel lifePanel;

    public LifeTimer(final LifePanel lifePanel) {
        updateTask = new LifeTimerTask(lifePanel);
        this.lifePanel = lifePanel;
        timerActive = false;
    }

    public void start() {
        try {
            scheduleAtFixedRate(updateTask, 0, timerPeriod);
        } catch (final IllegalStateException e) {
            updateTask = new LifeTimerTask(lifePanel);
            scheduleAtFixedRate(updateTask, 0, timerPeriod);
        } finally {
            timerActive = true;
        }
    }

    public void stop() {
        updateTask.cancel();
        timerActive = false;
    }

    public boolean getTimerActive() {
        return timerActive;
    }

    public LifeTimerTask getTask() {
        return updateTask;
    }
}
