package conway.life;

import java.util.TimerTask;

public class LifeTimerTask extends TimerTask {

    private final LifePanel lifePanel;

    public LifeTimerTask(final LifePanel lifePanel) {
        this.lifePanel = lifePanel;
    }

    @Override
    public void run() {
        lifePanel.setNeighbours();
        lifePanel.getCells().forEach(
                column -> column.forEach(cell -> cell.nextGeneration()));
        lifePanel.repaint();
    }
}
