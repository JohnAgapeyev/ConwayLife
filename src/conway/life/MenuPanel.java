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

    private final LifeTimer timer;

    public MenuPanel(GridPanel grid) {
        setBackground(Color.red);
        startButton = new JButton("Start");
        nextButton = new JButton("Next");
        exitButton = new JButton("Exit");

        timer = new LifeTimer(grid);

        startButton.addActionListener(ae -> grid.random());

        nextButton.addActionListener(ae -> {
            if (timer.getTimerActive()) {
                timer.stop();
            } else {
                timer.start();
            }
        });

        exitButton.addActionListener(ae -> System.exit(0));

        add(startButton);
        add(nextButton);
        add(exitButton);
    }

}
