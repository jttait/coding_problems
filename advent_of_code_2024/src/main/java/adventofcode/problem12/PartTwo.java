package adventofcode.problem12;

import adventofcode.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartTwo {
    Set<Position> visited;
    List<List<Character>> grid;

    public PartTwo(List<List<Character>> grid) {
        this.visited = new HashSet<>();
        this.grid = grid;
    }

    public int calculateFencingCost() {
        int result = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (!visited.contains(new Position(x, y))) {
                    result += calculateRegionFencingCost(x, y);
                }
            }
        }
        return result;
    }

    private int calculateRegionFencingCost(int x, int y) {
        RegionFenceCosterWithBulkDiscount regionFenceCoster = new RegionFenceCosterWithBulkDiscount(this.grid);
        regionFenceCoster.calculate(x, y);
        this.visited.addAll(regionFenceCoster.getVisited());
        return regionFenceCoster.getArea() * regionFenceCoster.getEdges();
    }
}
