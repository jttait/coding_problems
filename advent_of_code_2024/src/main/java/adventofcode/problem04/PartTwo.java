package adventofcode.problem04;

import java.util.List;

public class PartTwo {
    public int findXmas(List<List<Character>> grid) {
        int result = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == 'A') {
                    result += checkForXmas(row, col, grid);
                }
            }
        }
        return result;
    }

    private int checkForXmas(int row, int col, List<List<Character>> grid) {
        if (checkPositiveDiagonal(row, col, grid) && checkNegativeDiagonal(row, col, grid)) {
            return 1;
        }
        return 0;
    }

    private boolean checkPositiveDiagonal(int row, int col, List<List<Character>> grid) {
        if (!areCornersInBounds(row, col, grid)) {
            return false;
        }
        if (grid.get(row+1).get(col-1) == 'M' && grid.get(row-1).get(col+1) == 'S') {
            return true;
        }
        if (grid.get(row+1).get(col-1) == 'S' && grid.get(row-1).get(col+1) == 'M') {
            return true;
        }
        return false;
    }

    private boolean checkNegativeDiagonal(int row, int col, List<List<Character>> grid) {
        if (!areCornersInBounds(row, col, grid)) {
            return false;
        }
        if (grid.get(row-1).get(col-1) == 'M' && grid.get(row+1).get(col+1) == 'S') {
            return true;
        }
        if (grid.get(row-1).get(col-1) == 'S' && grid.get(row+1).get(col+1) == 'M') {
            return true;
        }
        return false;
    }

    private boolean areCornersInBounds(int row, int col, List<List<Character>> grid) {
        if (row - 1 < 0) {
            return false;
        }
        if (col - 1 < 0) {
            return false;
        }
        if (row + 1 >= grid.size()) {
            return false;
        }
        if (col + 1 >= grid.get(0).size()) {
            return false;
        }
        return true;
    }
}
