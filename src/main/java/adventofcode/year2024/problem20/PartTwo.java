package adventofcode.year2024.problem20;

import adventofcode.year2024.common.Cell;

import java.util.*;

public class PartTwo {
    private final List<List<Character>> grid;
    private final List<List<Integer>> lowestCostsWithoutCheats;
    private final Cell end;
    private final Map<Cell, Map<Integer, Set<Cell>>> jumps;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
        this.end = findEnd();
        this.lowestCostsWithoutCheats = findLowestCosts();
        this.jumps = new HashMap<>();
        for (int y = 1; y < grid.size() - 1; y++) {
            for (int x = 1; x < grid.get(0).size() - 1; x++) {
                if (grid.get(y).get(x) != 'E' && grid.get(y).get(x) != '#') {
                    Cell cell = new Cell(x, y);
                    this.jumps.put(cell, new HashMap<>());
                    for (int distance = 1; distance <= 20; distance++) {
                        jumps.get(cell).put(distance, new HashSet<>());

                        for (int dy = -1 * distance; dy <= distance; dy++) {
                            for (int dx = -1 * distance; dx <= distance; dx++) {
                                if (Math.abs(dx) + Math.abs(dy) == Math.abs(distance) && x + dx >= 1 && y + dy >= 1 && x + dx < grid.get(0).size() - 1 && y + dy < grid.size() - 1 && grid.get(y + dy).get(x + dx) != '#') {
                                    jumps.get(cell).get(distance).add(new Cell(x + dx, y + dy));
                                }
                            }
                        }
                    }
                }
            }
        }
//        for (int y = 0; y < grid.size(); y++) {
//            System.out.println();
//            for (int x = 0; x < grid.get(0).size(); x++) {
//                System.out.printf("%d ", lowestCostsWithoutCheats.get(y).get(x));
//            }
//        }
    }

    public int findSavings(int minimumSaving) {
        int result = 0;
        for (int y = 1; y < grid.size() - 1; y++) {
            for (int x = 1; x < grid.get(0).size() - 1; x++) {
                if (grid.get(y).get(x) == 'S' || grid.get(y).get(x) == '.') {
                    result += findSavingsForCell(new Cell(x, y), minimumSaving);
                }
            }
        }
        return result;
    }

    private int findSavingsForCell(Cell cell, int minimumSaving) {
        if (cell.x() == end.x() && cell.y() == end.y()) {
            return 0;
        }
        int result = 0;
        for (int distance = 1; distance <= 20; distance++) {
            for (Cell c : this.jumps.get(cell).get(distance)) {
                int x = c.x();
                int y = c.y();
                int saving = this.lowestCostsWithoutCheats.get(cell.y()).get(cell.x()) - (this.lowestCostsWithoutCheats.get(y).get(x) + distance);
                if (saving >= minimumSaving) {
                    result++;
                }
            }
        }
        return result;
    }

    private List<List<Integer>> findLowestCosts() {
        List<List<Integer>> result = new ArrayList<>();
        for (int y = 0; y < grid.size(); y++) {
            result.add(new ArrayList<>());
            for (int x = 0; x < grid.get(0).size(); x++) {
                result.get(y).add(Integer.MAX_VALUE);
            }
        }
        Set<Cell> seen = new HashSet<>();
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(end.x(), end.y()));
        int cost = 0;
        while (!stack.isEmpty()) {
            Stack<Cell> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            while (!stack2.isEmpty()) {
                Cell cell = stack2.pop();
                int x = cell.x();
                int y = cell.y();
                if (grid.get(y).get(x) == '.' || grid.get(y).get(x) == 'E' || grid.get(y).get(x) == 'S') {
                    result.get(y).set(x, cost);
                    seen.add(cell);
                    if (!seen.contains(new Cell(x + 1, y))) {
                        stack.push(new Cell(x + 1, y));
                    }
                    if (!seen.contains(new Cell(x - 1, y))) {
                        stack.push(new Cell(x - 1, y));
                    }
                    if (!seen.contains(new Cell(x, y + 1))) {
                        stack.push(new Cell(x, y + 1));
                    }
                    if (!seen.contains(new Cell(x, y - 1))) {
                        stack.push(new Cell(x, y - 1));
                    }
                }
            }
            cost++;
        }
        return result;
    }

    private Cell findEnd() {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 'E') {
                    return new Cell(x, y);
                }
            }
        }
        return new Cell(-1, -1);
    }
}
