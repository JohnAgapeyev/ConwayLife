package conway.life;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * Mouse listener for the grid.
 *
 * @author John Agapeyev.
 *
 */
public class LifeMouseListener extends MouseAdapter
        implements MouseMotionListener {

    /**
     * Panel used to check if the timer is currently running.
     */
    private final LifePanel lifePanel;

    /**
     * All the cells of the grid.
     */
    private final List<List<Cell>> cells;

    /**
     * Size of the individual cells.
     */
    private final int cellSize = Cell.getCellSize();

    /**
     * Constructor Method.
     *
     * @param lifePanel
     *            Panel to be used.
     */
    public LifeMouseListener(final LifePanel lifePanel) {
        this.lifePanel = lifePanel;
        cells = lifePanel.getCells();
    }

    /**
     * Changes the state of the cell based on the mouse location and the mouse
     * button pressed.
     */
    @Override
    public void mouseDragged(final MouseEvent e) {
        if (e.getY() >= 0 && !lifePanel.getTimer().getTimerActive()) {
            cells.get(e.getX() / cellSize).get(e.getY() / cellSize)
                    .setState(!SwingUtilities.isRightMouseButton(e));
            lifePanel.repaint();
        }
    }

    /**
     * Calls the drag method whenever the mouse is clicked.
     */
    @Override
    public void mousePressed(final MouseEvent e) {
        mouseDragged(e);
    }
}
