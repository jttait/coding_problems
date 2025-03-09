package adventofcode.year2024.common;

import java.util.List;

public class Utils {
    public static <T> boolean inBounds(int x, int y, List<List<T>> grid) {
        return x >= 0 && y >= 0 && y < grid.size() && x < grid.get(0).size();
    }
}
