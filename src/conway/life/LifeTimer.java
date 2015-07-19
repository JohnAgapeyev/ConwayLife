package conway.life;

import java.util.Timer;

/**
 * Timer for the program.
 *
 * @author John Agapeyev
 *
 */
public class LifeTimer extends Timer {

    /**
     * Task for the timer.
     */
    private LifeTimerTask updateTask;

    /**
     * Whether the timer is currently running.
     */
    private boolean timerActive;

    /**
     * Period for execution of the update task.
     */
    private final long timerPeriod = 100;

    /**
     * Panel to be used when calling methods in the timer task.
     */
    private final LifePanel lifePanel;

    /**
     * Constructor Method.
     *
     * @param lifePanel
     *            Panel to be used by the timer.
     */
    public LifeTimer(final LifePanel lifePanel) {
        updateTask = new LifeTimerTask(lifePanel);
        this.lifePanel = lifePanel;
        timerActive = false;
    }

    /**
     * Start method for the timer.
     */
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

    /**
     * Stop method for the timer.
     */
    public void stop() {
        updateTask.cancel();
        timerActive = false;
    }

    /**
     * Getter Method.
     *
     * @return Whether the timer is currently running.
     */
    public boolean getTimerActive() {
        return timerActive;
    }

    /**
     * Getter Method.
     *
     * @return The timer's task.
     */
    public LifeTimerTask getTask() {
        return updateTask;
    }
}
