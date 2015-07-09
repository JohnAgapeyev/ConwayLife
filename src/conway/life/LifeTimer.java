package conway.life;

import java.util.Timer;

public class LifeTimer extends Timer {

    LifeTimerTask updateTask;

    private boolean timerEnabled;
    
    private long timerPeriod = 10;

    GridPanel grid;

    public LifeTimer(GridPanel grid) {
        updateTask = new LifeTimerTask(grid);
        this.grid = grid;
        timerEnabled = false;
    }

    public void start() {
        try {
            scheduleAtFixedRate(updateTask, 0, timerPeriod);
        } catch (IllegalStateException e) {
            updateTask = new LifeTimerTask(grid);
            scheduleAtFixedRate(updateTask, 0, timerPeriod);
        } finally {
            timerEnabled = true;
        }
    }

    public void stop() {
        updateTask.cancel();
        timerEnabled = false;
    }

    public boolean getTimerActive() {
        return timerEnabled;
    }
}
