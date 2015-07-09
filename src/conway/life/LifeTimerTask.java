package conway.life;

import java.util.TimerTask;

public class LifeTimerTask extends TimerTask {
    
    private GridPanel grid;
    
    public LifeTimerTask(GridPanel grid) {
        this.grid = grid;
    }

    @Override
    public void run() {
        grid.setNeighbours();
        grid.getCells().forEach(
                column -> column.forEach(cell -> cell.nextGeneration()));
        grid.repaint();
    }
}
