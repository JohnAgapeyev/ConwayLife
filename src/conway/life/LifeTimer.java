package conway.life;

import java.util.Timer;

public class LifeTimer extends Timer {

    private LifeTimerTask updateTask;

    private boolean timerActive;

    private long timerPeriod = 100;

    private GridPanel grid;

    public LifeTimer(GridPanel grid) {
        updateTask = new LifeTimerTask(grid);
        this.grid = grid;
        timerActive = false;
    }

    public void start() {
        try {
            scheduleAtFixedRate(updateTask, 0, timerPeriod);
        } catch (IllegalStateException e) {
            updateTask = new LifeTimerTask(grid);
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
