package adventofcode.problem10;

import adventofcode.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.common.Utils.inBounds;

public class PartOne {
    private final List<List<Integer>> grid;
    private Set<Position> found;

    public PartOne(List<List<Integer>> grid) {
        this.grid = grid;
        this.found = new HashSet<>();
    }

    public int sumTrailheadScores() {
        Set<Position> trailheads = Utils.findTrailheads(grid);
        int result = 0;
        for (Position trailhead : trailheads) {
            this.found = new HashSet<>();
            scoreTrailhead(trailhead);
            result += this.found.size();

        }
        return result;
    }

    private void scoreTrailhead(Position position) {
        dfs(position);
    }

    private void dfs(Position position) {
        int x = position.x();
        int y = position.y();
        if (!inBounds(x, y, grid)) {
            return;
        }
        int val = grid.get(y).get(x);
        if (val == 9) {
            this.found.add(new Position(x, y));
        }
        if (inBounds(x + 1, y, grid) && grid.get(y).get(x + 1) == val + 1) {
            dfs(new Position(x + 1, y));
        }
        if (inBounds(x - 1, y, grid) && grid.get(y).get(x - 1) == val + 1) {
            dfs(new Position(x - 1, y));
        }
        if (inBounds(x, y + 1, grid) && grid.get(y + 1).get(x) == val + 1) {
            dfs(new Position(x, y + 1));
        }
        if (inBounds(x, y - 1, grid) && grid.get(y - 1).get(x) == val + 1) {
            dfs(new Position(x, y - 1));
        }
    }
}
