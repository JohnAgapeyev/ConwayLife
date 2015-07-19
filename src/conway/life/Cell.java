package conway.life;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for the cells in the grid.
 *
 * @author John Agapeyev
 *
 */
public class Cell {

    /**
     * The size of each individual cell.
     */
    private static final int cellSize = 10;

    /**
     * The state of the cell.
     */
    private boolean state;

    /**
     * The states of all adjacent cells.
     */
    private List<Boolean> neighbours = new ArrayList<>(8);

    /**
     * Creates a cell with the given state.
     *
     * @param state
     *            The cell's initial state.
     */
    public Cell(final boolean state) {
        this.state = state;
    }

    /**
     * Sets the cell forward one generation based on the state of its
     * neighbours.
     */
    public void nextGeneration() {
        final int living = Collections.frequency(neighbours,
                Boolean.valueOf(true));

        if (living < 2 || living > 3) {
            state = false;
        } else if (living == 3) {
            state = true;
        }
    }

    /**
     * Getter Method.
     *
     * @return The cell's current state.
     */
    public boolean getState() {
        return state;
    }

    /**
     * Setter Method.
     *
     * @param state
     *            The desired state of the cell.
     */
    public void setState(final boolean state) {
        this.state = state;
    }

    /**
     * Setter Method.
     *
     * @param neighbours
     *            A list of states of all adjacent cells.
     */
    public void setNeighbours(final List<Boolean> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * Getter Method.
     *
     * @return The size of each cell.
     */
    public static int getCellSize() {
        return cellSize;
    }
}
