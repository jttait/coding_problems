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
        int x = cell.x();
        int y = cell.y();
        if (!inBounds(x, y, grid)) {
            return 0;
        }
        int val = grid.get(y).get(x);
        if (val == 9) {
            return 1;
        }
        int result = 0;
        if (inBounds(x + 1, y, grid) && grid.get(y).get(x + 1) == val + 1) {
            result += dfs(new Cell(x + 1, y));
        }
        if (inBounds(x - 1, y, grid) && grid.get(y).get(x - 1) == val + 1) {
            result += dfs(new Cell(x - 1, y));
        }
        if (inBounds(x, y + 1, grid) && grid.get(y + 1).get(x) == val + 1) {
            result += dfs(new Cell(x, y + 1));
        }
        if (inBounds(x, y - 1, grid) && grid.get(y - 1).get(x) == val + 1) {
            result += dfs(new Cell(x, y - 1));
        }
        return result;
    }
}
