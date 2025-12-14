package adventofcode.problem10;

import adventofcode.common.Position;

import java.util.List;
import java.util.Set;

import static adventofcode.common.Utils.inBounds;

public class PartTwo {
    private final List<List<Integer>> grid;

    public PartTwo(List<List<Integer>> grid) {
        this.grid = grid;
    }

    public int sumTrailheadScores() {
        Set<Position> trailheads = Utils.findTrailheads(grid);
        int result = 0;
        for (Position trailhead : trailheads) {
            result += scoreTrailhead(trailhead);
        }
        return result;
    }

    private int scoreTrailhead(Position position) {
        return dfs(position);
    }

    private int dfs(Position position) {
        int x = position.x();
        int y = position.y();
        if (!inBounds(x, y, grid)) {
            return 0;
        }
        int val = grid.get(y).get(x);
        if (val == 9) {
            return 1;
        }
        int result = 0;
        if (inBounds(x + 1, y, grid) && grid.get(y).get(x + 1) == val + 1) {
            result += dfs(new Position(x + 1, y));
        }
        if (inBounds(x - 1, y, grid) && grid.get(y).get(x - 1) == val + 1) {
            result += dfs(new Position(x - 1, y));
        }
        if (inBounds(x, y + 1, grid) && grid.get(y + 1).get(x) == val + 1) {
            result += dfs(new Position(x, y + 1));
        }
        if (inBounds(x, y - 1, grid) && grid.get(y - 1).get(x) == val + 1) {
            result += dfs(new Position(x, y - 1));
        }
        return result;
    }
}
