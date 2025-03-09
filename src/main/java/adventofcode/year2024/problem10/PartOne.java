package adventofcode.year2024.problem10;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.year2024.common.Utils.inBounds;

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
        int x = cell.x();
        int y = cell.y();
        if (!inBounds(x, y, grid)) {
            return;
        }
        int val = grid.get(y).get(x);
        if (val == 9) {
            this.found.add(new Cell(x, y));
        }
        if (inBounds(x + 1, y, grid) && grid.get(y + 1).get(x) == val + 1) {
            dfs(new Cell(x + 1, y));
        }
        if (inBounds(x - 1, y, grid) && grid.get(y - 1).get(x) == val + 1) {
            dfs(new Cell(x - 1, y));
        }
        if (inBounds(x, y + 1, grid) && grid.get(y).get(x + 1) == val + 1) {
            dfs(new Cell(x, y + 1));
        }
        if (inBounds(x, y - 1, grid) && grid.get(y).get(x - 1) == val + 1) {
            dfs(new Cell(x, y - 1));
        }
    }
}
