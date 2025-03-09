package adventofcode.year2024.problem20;

import adventofcode.year2024.common.Position;

import java.util.*;

public class PartTwo {
    private final List<List<Character>> grid;
    private final List<List<Integer>> lowestCostsWithoutCheats;
    private final Position end;
    private final Map<Position, Map<Integer, Set<Position>>> jumps;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
        this.end = findEnd();
        this.lowestCostsWithoutCheats = findLowestCosts();
        this.jumps = new HashMap<>();
        for (int y = 1; y < grid.size() - 1; y++) {
            for (int x = 1; x < grid.get(0).size() - 1; x++) {
                if (grid.get(y).get(x) != 'E' && grid.get(y).get(x) != '#') {
                    Position position = new Position(x, y);
                    this.jumps.put(position, new HashMap<>());
                    for (int distance = 1; distance <= 20; distance++) {
                        jumps.get(position).put(distance, new HashSet<>());

                        for (int dy = -1 * distance; dy <= distance; dy++) {
                            for (int dx = -1 * distance; dx <= distance; dx++) {
                                if (Math.abs(dx) + Math.abs(dy) == Math.abs(distance) && x + dx >= 1 && y + dy >= 1 && x + dx < grid.get(0).size() - 1 && y + dy < grid.size() - 1 && grid.get(y + dy).get(x + dx) != '#') {
                                    jumps.get(position).get(distance).add(new Position(x + dx, y + dy));
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
                    result += findSavingsForCell(new Position(x, y), minimumSaving);
                }
            }
        }
        return result;
    }

    private int findSavingsForCell(Position position, int minimumSaving) {
        if (position.x() == end.x() && position.y() == end.y()) {
            return 0;
        }
        int result = 0;
        for (int distance = 1; distance <= 20; distance++) {
            for (Position c : this.jumps.get(position).get(distance)) {
                int x = c.x();
                int y = c.y();
                int saving = this.lowestCostsWithoutCheats.get(position.y()).get(position.x()) - (this.lowestCostsWithoutCheats.get(y).get(x) + distance);
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
        Set<Position> seen = new HashSet<>();
        Stack<Position> stack = new Stack<>();
        stack.push(new Position(end.x(), end.y()));
        int cost = 0;
        while (!stack.isEmpty()) {
            Stack<Position> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            while (!stack2.isEmpty()) {
                Position position = stack2.pop();
                int x = position.x();
                int y = position.y();
                if (grid.get(y).get(x) == '.' || grid.get(y).get(x) == 'E' || grid.get(y).get(x) == 'S') {
                    result.get(y).set(x, cost);
                    seen.add(position);
                    if (!seen.contains(new Position(x + 1, y))) {
                        stack.push(new Position(x + 1, y));
                    }
                    if (!seen.contains(new Position(x - 1, y))) {
                        stack.push(new Position(x - 1, y));
                    }
                    if (!seen.contains(new Position(x, y + 1))) {
                        stack.push(new Position(x, y + 1));
                    }
                    if (!seen.contains(new Position(x, y - 1))) {
                        stack.push(new Position(x, y - 1));
                    }
                }
            }
            cost++;
        }
        return result;
    }

    private Position findEnd() {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 'E') {
                    return new Position(x, y);
                }
            }
        }
        return new Position(-1, -1);
    }
}
