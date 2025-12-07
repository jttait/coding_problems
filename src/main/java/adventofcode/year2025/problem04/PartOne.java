package adventofcode.year2025.problem04;

import java.util.List;

public class PartOne {
    public final List<List<Character>> grid;

    public PartOne(List<List<Character>> grid) {
        this.grid = grid;
    }

    public int countAccessibleRolls() {
        int result = 0;
        for (int col = 0; col < grid.get(0).size(); col++) {
            for (int row = 0; row < grid.size(); row++) {
                if (grid.get(row).get(col) == '@' && countNeighbours(row, col) < 4) {
                    result++;
                }
            }
        }
        return result;
    }

    private int countNeighbours(int row, int col) {
        int result = 0;
        for (int colDiff = -1; colDiff <= 1; colDiff++) {
            for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
                if (!(rowDiff == 0 && colDiff == 0) && isCellOccupied(row+rowDiff, col+colDiff)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isCellOccupied(int row, int col) {
        if (row < 0) {
            return false;
        }
        if (col < 0) {
            return false;
        }
        if (row >= grid.size()) {
            return false;
        }
        if (col >= grid.get(0).size()) {
            return false;
        }
        if (grid.get(row).get(col) == '.') {
            return false;
        }
        return true;
    }
}
