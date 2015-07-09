package conway.life;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.SwingUtilities;

public class LifeMouseListener implements MouseMotionListener, MouseListener {

    private final GridPanel grid;

    // private final MenuPanel menu;

    private List<List<Cell>> cells;

    private int cellSize = Cell.getCellSize();

    private LifeTimer timer;

    public LifeMouseListener(GridPanel grid) {
        this.grid = grid;
        // this.menu = menu;
        cells = grid.getCells();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        cells.get(e.getX() / cellSize).get(e.getY() / cellSize)
                .setState(!SwingUtilities.isRightMouseButton(e));
        grid.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDragged(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
