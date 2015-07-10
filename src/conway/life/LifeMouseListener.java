package conway.life;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.SwingUtilities;

public class LifeMouseListener implements MouseMotionListener, MouseListener {

    private final LifePanel lifePanel;

    private final List<List<Cell>> cells;

    private final int cellSize = Cell.getCellSize();

    public LifeMouseListener(final LifePanel lifePanel) {
        this.lifePanel = lifePanel;
        cells = lifePanel.getCells();
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        if (e.getY() >= 0 && !lifePanel.getTimer().getTimerActive()) {
            cells.get(e.getX() / cellSize).get(e.getY() / cellSize)
                    .setState(!SwingUtilities.isRightMouseButton(e));
            lifePanel.repaint();
        }
    }

    @Override
    public void mouseMoved(final MouseEvent e) {

    }

    @Override
    public void mouseClicked(final MouseEvent e) {

    }

    @Override
    public void mousePressed(final MouseEvent e) {
        mouseDragged(e);
    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }

}
