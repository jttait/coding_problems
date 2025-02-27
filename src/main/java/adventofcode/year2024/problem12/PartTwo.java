package adventofcode.year2024.problem12;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartTwo {
    Set<Cell> visited;
    List<List<Character>> grid;

    public PartTwo(List<List<Character>> grid) {
        this.visited = new HashSet<>();
        this.grid = grid;
    }

    public int calculateFencingCost() {
        int result = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (!visited.contains(new Cell(row, col))) {
                    result += calculateRegionFencingCost(row, col);
                }
            }
        }
        return result;
    }

    private int calculateRegionFencingCost(int row, int col) {
        RegionFenceCosterWithBulkDiscount regionFenceCoster = new RegionFenceCosterWithBulkDiscount(this.grid);
        regionFenceCoster.calculate(row, col);
        this.visited.addAll(regionFenceCoster.getVisited());
        return regionFenceCoster.getArea() * regionFenceCoster.getEdges();
    }
}
