package adventofcode.year2024.common;

import java.util.List;

public class Utils {
    public static <T> boolean inBounds(int row, int col, List<List<T>> grid) {
        return row >= 0 && col >= 0 && row < grid.size() && col < grid.get(0).size();
    }
}
