package adventofcode.year2025.problem04;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    private List<List<Character>> grid;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
    }

    public int countRemovableRolls() {
        int result = 0;
        while (true) {
            int removedRolls = removeAccessibleRolls();
            result += removedRolls;
            if (removedRolls == 0) {
                return result;
            }
        }
    }

    private int removeAccessibleRolls() {
        int result = 0;
        List<List<Character>> updatedGrid = new ArrayList<>();
        for (int row = 0; row < grid.size(); row++) {
            updatedGrid.add(new ArrayList<>());
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == '.') {
                    updatedGrid.get(row).add('.');
                } else if (countNeighbours(row, col) < 4) {
                    updatedGrid.get(row).add('.');
                    result++;
                } else {
                    updatedGrid.get(row).add('@');
                }
            }
        }
        this.grid = updatedGrid;
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
