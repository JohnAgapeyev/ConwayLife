package conway.life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 5894984420121210194L;

    private static final Dimension size = Toolkit.getDefaultToolkit()
            .getScreenSize();

    private final int cellSize = Cell.getCellSize();
    private final int widthCellCount = (int) size.getWidth() / cellSize + 1;
    private final int heightCellCount = (int) size.getHeight() / cellSize + 1;

    private List<List<Boolean>> cells = new ArrayList<>();

    public GridPanel() {
        setBackground(Color.blue);
        for (int i = 0; i < widthCellCount; i++) {
            List<Boolean> column = new ArrayList<>();
            for (int j = 0; j < heightCellCount; j++) {
                column.add(new Boolean(new Random().nextBoolean()));
            }
            cells.add(column);
        }
    }

    public void random() {

        for (int a = 0; a < cells.size(); a++) {
            for (int b = 0; b < cells.get(a).size(); b++) {
                for (int c = -1; c < 2; c++) {
                    for (int d = -1; d < 2; d++) {
                        if (c == 0 && d == 0) {
                            continue;
                        } else {
                            List<Boolean> neighbours = new ArrayList<>(8);
                            try {
                                neighbours.add(cells.get(a + c).get(b + d));
                            } catch (IndexOutOfBoundsException e) {
                                neighbours.add(new Boolean(false));
                            }
                        }
                    }
                }
            }
        }

        // cells = new ArrayList<>();
        // for (int i = 0; i < widthCellCount; i++) {
        // List<Boolean> column = new ArrayList<>();
        // for (int j = 0; j < heightCellCount; j++) {
        // column.add(new Boolean(new Random().nextBoolean()));
        // }
        // cells.add(column);
        // }
        // repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < widthCellCount; i++) {
            for (int j = 0; j < heightCellCount; j++) {
                if (cells.get(i).get(j)) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.magenta);
                }
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                g.setColor(Color.black);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }

    }
}
