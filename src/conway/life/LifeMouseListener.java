package conway.life;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class LifeMouseListener implements MouseMotionListener, MouseListener {

    GridPanel grid;

    List<List<Cell>> cells;

    int cellSize = Cell.getCellSize();

    public LifeMouseListener(GridPanel grid) {
        this.grid = grid;
        cells = grid.getCells();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        cells.get(e.getX() / cellSize).get(e.getY() / cellSize).setState(true);
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
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
