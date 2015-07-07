package conway.life;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class LifePanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 3192170099150816320L;

    private static final int squareSize = 10;

    private static final Dimension size = Toolkit.getDefaultToolkit()
            .getScreenSize();

    public LifePanel() {
        setLayout(new BorderLayout());
        JPanel menu = new MenuPanel();
        JPanel grid = new GridPanel();
        
        add(menu, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < size.getWidth(); i++) {
            if (i % squareSize == 0) {
                g.drawLine(i, 0, i, (int) size.getHeight());
                g.drawLine(0, i, (int) size.getWidth(), i);
            }
        }
    }
}
