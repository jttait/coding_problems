package adventofcode.year2024.problem10;

import adventofcode.year2024.common.Cell;

import java.util.List;
import java.util.Set;

import static adventofcode.year2024.common.Utils.inBounds;

public class PartTwo {
    private final List<List<Integer>> grid;

    public PartTwo(List<List<Integer>> grid) {
        this.grid = grid;
    }

    public int sumTrailheadScores() {
        Set<Cell> trailheads = Utils.findTrailheads(grid);
        int result = 0;
        for (Cell trailhead : trailheads) {
            result += scoreTrailhead(trailhead);
        }
        return result;
    }

    private int scoreTrailhead(Cell cell) {
        return dfs(cell);
    }

    private int dfs(Cell cell) {
        int row = cell.row();
        int col = cell.col();
        if (!inBounds(row, col, grid)) {
            return 0;
        }
        int val = grid.get(row).get(col);
        if (val == 9) {
            return 1;
        }
        int result = 0;
        if (inBounds(row+1, col, grid) && grid.get(row+1).get(col) == val + 1) {
            result += dfs(new Cell(row + 1, col));
        }
        if (inBounds(row-1, col, grid) && grid.get(row-1).get(col) == val + 1) {
            result += dfs(new Cell(row - 1, col));
        }
        if (inBounds(row, col+1, grid) && grid.get(row).get(col+1) == val + 1) {
            result += dfs(new Cell(row, col + 1));
        }
        if (inBounds(row, col-1, grid) && grid.get(row).get(col-1) == val + 1) {
            result += dfs(new Cell(row, col - 1));
        }
        return result;
    }
}
