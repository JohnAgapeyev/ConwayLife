package conway.life;

import java.util.Timer;

public class LifeTimer extends Timer {
    
    LifeTimerTask updateTask;
    
    public LifeTimer() {
        updateTask = new LifeTimerTask();
    }
    
    public void start() {
        scheduleAtFixedRate(updateTask, 0, 16);
    }
}
