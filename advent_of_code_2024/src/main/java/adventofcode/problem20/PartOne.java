package adventofcode.problem20;

import adventofcode.common.DjikstraState;
import adventofcode.common.Position;

import java.util.*;

public class PartOne {
    private final List<List<Character>> grid;
    private final Position start;
    private final List<Position> removableWalls;

    public PartOne(List<List<Character>> grid) {
        this.grid = grid;
        this.start = findStart();
        this.removableWalls = findAllRemovableWalls();
    }

    public int findNumberOfCheatsThatSave100picoseconds() {
        int shortestPathWithoutCheats = findShortestPath();
        int result = 0;
        for (Position removableWall : removableWalls) {
            this.grid.get(removableWall.y()).set(removableWall.x(), '.');
            int shortestPath = findShortestPath();
            int saving = shortestPathWithoutCheats - shortestPath;
            if (saving >= 100) {
                result++;
            }
            this.grid.get(removableWall.y()).set(removableWall.x(), '#');
        }
        return result;
    }

    public int findShortestPath() {
        PriorityQueue<DjikstraState> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(DjikstraState::cost));
        Set<Position> visited = new HashSet<>();
        priorityQueue.add(new DjikstraState(start.x(), start.y(), 0));
        while (!priorityQueue.isEmpty()) {
            DjikstraState state = priorityQueue.poll();
            int x = state.x();
            int y = state.y();
            int cost = state.cost();
            if (grid.get(y).get(x) == 'E') {
                return cost;
            }
            if (!visited.contains(new Position(x + 1, y)) && grid.get(y).get(x + 1) != '#') {
                priorityQueue.add(new DjikstraState(x + 1, y, cost + 1));
            }
            if (!visited.contains(new Position(x - 1, y)) && grid.get(y).get(x - 1) != '#') {
                priorityQueue.add(new DjikstraState(x - 1, y, cost + 1));
            }
            if (!visited.contains(new Position(x, y + 1)) && grid.get(y + 1).get(x) != '#') {
                priorityQueue.add(new DjikstraState(x, y + 1, cost + 1));
            }
            if (!visited.contains(new Position(x, y - 1)) && grid.get(y - 1).get(x) != '#') {
                priorityQueue.add(new DjikstraState(x, y - 1, cost + 1));
            }
            visited.add(new Position(x, y));
        }
        return -1;
    }

    private Position findStart() {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 'S') {
                    return new Position(x, y);
                }
            }
        }
        return new Position(-1, -1);
    }

    private List<Position> findAllRemovableWalls() {
        List<Position> result = new ArrayList<>();
        for (int y = 1; y < grid.size() - 1; y++) {
            for (int x = 1; x < grid.get(0).size() - 1; x++) {
                if (grid.get(y).get(x) == '#') {
                    result.add(new Position(x, y));
                }
            }
        }
        return result;
    }
}
