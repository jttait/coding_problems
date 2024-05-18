package leetcode.problem2812;

import java.util.Objects;

public class Cell {
    private final int row;
    private final int col;
    private final int safeness;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.safeness = 0;
    }

    public Cell(int row, int col, int safeness) {
        this.row = row;
        this.col = col;
        this.safeness = safeness;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getSafeness() {
        return safeness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
