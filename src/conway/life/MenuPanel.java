package conway.life;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 1236835302774337179L;

    private final JButton startButton;
    private final JButton nextButton;
    private final JButton exitButton;

    public MenuPanel(GridPanel grid) {
        setBackground(Color.red);
        startButton = new JButton("Start");
        nextButton = new JButton("Next");
        exitButton = new JButton("Exit");

        startButton.addActionListener(ae -> grid.random());

        nextButton.addActionListener(ae -> {
            grid.getNeighbours();
            grid.getCells().forEach(
                    column -> column.forEach(cell -> cell.nextGeneration()));
            grid.repaint();
        });

        exitButton.addActionListener(ae -> System.exit(0));

        add(startButton);
        add(nextButton);
        add(exitButton);
    }

}
