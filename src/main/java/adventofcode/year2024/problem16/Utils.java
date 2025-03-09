package adventofcode.year2024.problem16;

import adventofcode.year2024.common.Position;

import java.util.List;
import java.util.Map;

public class Utils {
    private final static Map<Heading, Map<Heading, Integer>> headingScores = Map.of(
            Heading.NORTH, Map.of(Heading.NORTH, 0, Heading.EAST, 1000, Heading.SOUTH, 2000,Heading.WEST, 1000),
            Heading.EAST, Map.of(Heading.NORTH, 1000, Heading.EAST, 0, Heading.SOUTH, 1000, Heading.WEST, 2000),
            Heading.SOUTH, Map.of(Heading.NORTH, 2000, Heading. EAST, 1000, Heading.SOUTH, 0, Heading.WEST, 1000),
            Heading.WEST, Map.of(Heading.NORTH, 1000, Heading.EAST, 2000, Heading.SOUTH, 1000, Heading.WEST, 0)
    );

    public static int rotationCost(Heading current, Heading target) {
        return headingScores.get(current).get(target);
    }

    public static Position findStart(List<List<Character>> grid) {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 'S') {
                    return new Position(x, y);
                }
            }
        }
        return new Position(-1, -1);
    }
}
