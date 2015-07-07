package conway.life;

import java.util.List;

public class Cell {

    private static final int cellSize = 10;

    private boolean enabledState;

    public Cell() {
        enabledState = false;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public boolean getEnabledState() {
        return enabledState;
    }

    public void setEnabledState(boolean enabledState) {
        this.enabledState = enabledState;
    }

    public void nextGeneration(List<Boolean> neighbours) {

    }

}
