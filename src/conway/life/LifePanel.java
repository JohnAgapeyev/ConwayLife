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

public class LifePanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 5894984420121210194L;

    private static final Dimension size = Toolkit.getDefaultToolkit()
            .getScreenSize();

    private final int cellSize = Cell.getCellSize();
    private final int widthCellCount = (int) size.getWidth() / cellSize + 1;
    private final int heightCellCount = (int) size.getHeight() / cellSize + 1;

    private List<List<Cell>> cells = new ArrayList<>();

    private final JButton startButton;
    private final JButton nextButton;
    private final JButton randButton;
    private final JButton exitButton;

    private final LifeTimer timer;

    public LifePanel() {
        setLayout(new BorderLayout());
        for (int i = 0; i < widthCellCount; i++) {
            final List<Cell> column = new ArrayList<>();
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
        startButton = new JButton("Start");
        nextButton = new JButton("Next");
        randButton = new JButton("Randomize");
        exitButton = new JButton("Exit");

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

    public void random() {
        cells = new ArrayList<>();
        for (int i = 0; i < widthCellCount; i++) {
            final List<Cell> column = new ArrayList<>();
            for (int j = 0; j < heightCellCount; j++) {
                column.add(new Cell(new Random().nextBoolean()));
            }
            cells.add(column);
        }
        setNeighbours();
        repaint();
    }

    public void setNeighbours() {
        List<Boolean> neighbours;
        for (int a = 0; a < cells.size(); a++) {
            for (int b = 0; b < cells.get(a).size(); b++) {
                neighbours = new ArrayList<>(8);
                for (int c = -1; c < 2; c++) {
                    for (int d = -1; d < 2; d++) {
                        if (c == 0 && d == 0) {
                            continue;
                        } else {
                            if (a + c >= 0 && b + d >= 0 && a + c < cells.size()
                                    && b + d < cells.get(a).size()) {
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

    public List<List<Cell>> getCells() {
        return cells;
    }

    public LifeTimer getTimer() {
        return timer;
    }
}
