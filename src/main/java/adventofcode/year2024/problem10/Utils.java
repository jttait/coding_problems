package adventofcode.year2024.problem10;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    static Set<Cell> findTrailheads(List<List<Integer>> grid) {
        Set<Cell> result = new HashSet<>();
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == 0) {
                    result.add(new Cell(row, col));
                }
            }
        }
        return result;
    }
}
