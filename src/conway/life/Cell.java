package conway.life;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cell {

    private static final int cellSize = 10;

    private boolean state;

    private List<Boolean> neighbours = new ArrayList<>(8);

    public Cell() {
        state = false;
    }

    public Cell(boolean value) {
        state = value;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setNeighbours(List<Boolean> neighbours) {
        this.neighbours = neighbours;
    }

    public void nextGeneration() {
        final int living = Collections.frequency(neighbours,
                Boolean.valueOf(true));
        if (living < 2 || living > 3) {
            state = false;
        } else if (living == 3) {
            state = true;
        }
    }

}
