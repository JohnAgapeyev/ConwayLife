package conway.life;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LifePanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 3192170099150816320L;

    public LifePanel() {
        setLayout(new BorderLayout());
        JPanel menu = new MenuPanel();
        JPanel grid = new GridPanel();

        add(menu, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
    }
}
