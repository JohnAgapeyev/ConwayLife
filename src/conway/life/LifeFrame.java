package conway.life;

import javax.swing.JFrame;

/**
 * Frame for the program.
 *
 * @author John Agapeyev
 *
 */
public class LifeFrame extends JFrame {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -5004002945226567786L;

    /**
     * Frame constructor.
     */
    public LifeFrame() {
        super("The Game of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new LifePanel());
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    /**
     * Method called when the program launches.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(final String[] args) {
        new LifeFrame();
    }
}
