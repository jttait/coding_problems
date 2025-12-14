package adventofcode.problem10;

import adventofcode.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    static Set<Position> findTrailheads(List<List<Integer>> grid) {
        Set<Position> result = new HashSet<>();
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 0) {
                    result.add(new Position(x, y));
                }
            }
        }
        return result;
    }
}
