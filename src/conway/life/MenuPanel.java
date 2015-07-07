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
    private final JButton exitButton;

    public MenuPanel() {
        setBackground(Color.red);
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");

        startButton.addActionListener(ae -> ((GridPanel)this.getParent().getComponents()[1]).random());
        exitButton.addActionListener(ae -> System.exit(0));

        add(startButton);
        add(exitButton);
    }

}
