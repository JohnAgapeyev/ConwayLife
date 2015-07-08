package conway.life;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LifePanel extends JPanel {

    /**
     * Serial ID for the panel.
     */
    private static final long serialVersionUID = 3192170099150816320L;
    
    private MenuPanel menu;
    private GridPanel grid;

    public LifePanel() {
        setLayout(new BorderLayout());
        grid = new GridPanel();
        menu = new MenuPanel(grid);

        add(menu, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
    }
    
    public GridPanel getGridPanel() {
        return grid;
    }
}
