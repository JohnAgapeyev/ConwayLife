package conway.life;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 5894984420121210194L;

    public GridPanel() {
        setLayout(new GridLayout());
        setBackground(Color.blue);
    }
}
