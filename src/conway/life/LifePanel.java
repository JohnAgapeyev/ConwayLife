package conway.life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel for the program.
 *
 * @author John Agapeyev
 *
 */
public class LifePanel extends JPanel {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 4467159917692364446L;

    /**
     * The size of the user's screen.
     */
    private static final Dimension size = Toolkit.getDefaultToolkit()
            .getScreenSize();

    /**
     * Size of each individual cell.
     */
    private static final int cellSize = Cell.getCellSize();

    /**
     * Number of cells that can fit the width of the screen.
     */
    private final int widthCellCount = (int) size.getWidth() / cellSize + 1;

    /**
     * Number of cells that can fit the height of the screen.
     */
    private final int heightCellCount = (int) size.getHeight() / cellSize + 1;

    /**
     * 2D list of cells.
     */
    private List<List<Cell>> cells = new ArrayList<>(widthCellCount);

    /**
     * Timer for the panel.
     */
    private final LifeTimer timer;

    /**
     * Constructor for the panel.
     */
    public LifePanel() {
        setLayout(new BorderLayout());
        for (int i = 0; i < widthCellCount; i++) {
            final List<Cell> column = new ArrayList<>(heightCellCount);
            for (int j = 0; j < heightCellCount; j++) {
                column.add(new Cell(false));
            }
            cells.add(column);
        }
        setNeighbours();

        final LifeMouseListener listener = new LifeMouseListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        final JPanel menu = new JPanel();
        menu.setBackground(Color.lightGray);
        final JButton startButton = new JButton("Start");
        final JButton nextButton = new JButton("Next");
        final JButton randButton = new JButton("Randomize");
        final JButton exitButton = new JButton("Exit");

        timer = new LifeTimer(this);

        startButton.addActionListener(ae -> {
            if (timer.getTimerActive()) {
                timer.stop();
                startButton.setText("Start");
            } else {
                timer.start();
                startButton.setText("Stop");
            }
        });

        nextButton.addActionListener(ae -> {
            timer.getTask().run();
        });

        randButton.addActionListener(ae -> {
            random();
            timer.stop();
            startButton.setText("Start");
        });

        exitButton.addActionListener(ae -> System.exit(0));

        menu.add(startButton);
        menu.add(nextButton);
        menu.add(randButton);
        menu.add(exitButton);

        add(menu, BorderLayout.NORTH);
    }

    /**
     * Randomly generates a starting board.
     */
    public void random() {
        final Random rand = new Random();
        cells.parallelStream().flatMap(column -> column.parallelStream())
                .forEach(cell -> cell.setState(rand.nextBoolean()));
        setNeighbours();
        repaint();
    }

    /**
     * Sets the neighbours for every cell. It iterates through all adjacent
     * cells and adds them to a list which is sent to the cell for counting.
     */
    public void setNeighbours() {
        List<Boolean> neighbours;
        for (int a = 0; a < widthCellCount; a++) {
            for (int b = 0; b < heightCellCount; b++) {
                neighbours = new ArrayList<>(8);
                for (int c = -1; c < 2; c++) {
                    for (int d = -1; d < 2; d++) {
                        if (c == 0 && d == 0) {
                            continue;
                        } else {
                            /*
                             * Checks to make sure everything is in bounds and
                             * won't cause an exception before being added.
                             */
                            if (a + c >= 0 && b + d >= 0
                                    && a + c < widthCellCount
                                    && b + d < heightCellCount) {
                                neighbours.add(
                                        cells.get(a + c).get(b + d).getState());
                            }
                        }
                    }
                }
                cells.get(a).get(b).setNeighbours(neighbours);
            }
        }
    }

    /**
     * Paint method for the panel.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < widthCellCount; i++) {
            for (int j = 0; j < heightCellCount; j++) {
                if (cells.get(i).get(j).getState()) {
                    g.setColor(Color.yellow);
                } else {
                    g.setColor(Color.gray);
                }
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                g.setColor(Color.black);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }

    /**
     * Getter Method.
     *
     * @return All the cells.
     */
    public List<List<Cell>> getCells() {
        return cells;
    }

    /**
     * Getter Method
     *
     * @return The timer for the program.
     */
    public LifeTimer getTimer() {
        return timer;
    }
}
