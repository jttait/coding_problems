package adventofcode.year2024.problem10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.year2024.problem10.Utils.inBounds;

public class PartOne {
    private final List<List<Integer>> grid;
    private Set<Cell> found;

    public PartOne(List<List<Integer>> grid) {
        this.grid = grid;
        this.found = new HashSet<>();
    }

    public int sumTrailheadScores() {
        Set<Cell> trailheads = Utils.findTrailheads(grid);
        int result = 0;
        for (Cell trailhead : trailheads) {
            this.found = new HashSet<>();
            scoreTrailhead(trailhead);
            result += this.found.size();

        }
        return result;
    }

    private void scoreTrailhead(Cell cell) {
        dfs(cell);
    }

    private void dfs(Cell cell) {
        int row = cell.row();
        int col = cell.col();
        if (!inBounds(row, col, grid)) {
            return;
        }
        int val = grid.get(row).get(col);
        if (val == 9) {
            this.found.add(new Cell(row, col));
        }
        if (inBounds(row+1, col, grid) && grid.get(row+1).get(col) == val + 1) {
            dfs(new Cell(row + 1, col));
        }
        if (inBounds(row-1, col, grid) && grid.get(row-1).get(col) == val + 1) {
            dfs(new Cell(row - 1, col));
        }
        if (inBounds(row, col+1, grid) && grid.get(row).get(col+1) == val + 1) {
            dfs(new Cell(row, col + 1));
        }
        if (inBounds(row, col-1, grid) && grid.get(row).get(col-1) == val + 1) {
            dfs(new Cell(row, col - 1));
        }
    }
}
