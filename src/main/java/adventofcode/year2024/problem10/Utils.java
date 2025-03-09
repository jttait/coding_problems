package adventofcode.year2024.problem10;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    static Set<Cell> findTrailheads(List<List<Integer>> grid) {
        Set<Cell> result = new HashSet<>();
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 0) {
                    result.add(new Cell(x, y));
                }
            }
        }
        return result;
    }
}
