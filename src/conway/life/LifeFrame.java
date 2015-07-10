package conway.life;

import javax.swing.JFrame;

public class LifeFrame extends JFrame {

    /**
     * Serial ID for the frame.
     */
    private static final long serialVersionUID = 154602988047161157L;

    public LifeFrame() {
        super("The Game of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new LifePanel());
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(final String[] args) {
        new LifeFrame();
    }
}
