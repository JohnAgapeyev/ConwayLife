package conway.life;

import java.util.TimerTask;

/**
 * Timer task for the program.
 *
 * @author John Agapeyev
 *
 */
public class LifeTimerTask extends TimerTask {

    /**
     * Panel to be used to call methods for the task.
     */
    private final LifePanel lifePanel;

    /**
     * Constructor Method.
     *
     * @param lifePanel
     *            Panel to be used.
     */
    public LifeTimerTask(final LifePanel lifePanel) {
        this.lifePanel = lifePanel;
    }

    /**
     * Overridden run method for the task.
     */
    @Override
    public void run() {
        lifePanel.setNeighbours();
        lifePanel.getCells().forEach(
                column -> column.forEach(cell -> cell.nextGeneration()));
        lifePanel.repaint();
    }
}
