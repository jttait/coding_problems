package adventofcode.year2024.problem18;

import adventofcode.year2024.common.Cell;
import adventofcode.year2024.common.DjikstraState;

import java.util.*;

public class PartTwo {
    private final int width;
    private final int height;
    private final List<Cell> fallingBytes;

    public PartTwo(int width, int height, List<Cell> fallingBytes) {
        this.width = width;
        this.height = height;
        this.fallingBytes = fallingBytes;
    }

    public Cell findFirstBlockingCell() {
        for (int tick = 0; tick < fallingBytes.size() + 1; tick++) {
            List<Cell> corruptedBytes = fallingBytes.subList(0, tick);
            int result = findShortestPath(corruptedBytes);
            if (result == -1) {
                return new Cell(fallingBytes.get(tick-1).row(), fallingBytes.get(tick-1).col());
            }
        }
        return new Cell(-1, -1);
    }

    private int findShortestPath(List<Cell> corruptedPositions) {
        Set<Cell> visited = new HashSet<>();
        PriorityQueue<DjikstraState> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(DjikstraState::cost));
        priorityQueue.add(new DjikstraState(0, 0, 0));
        while (!priorityQueue.isEmpty()) {
            DjikstraState djikstraState = priorityQueue.poll();
            int x = djikstraState.x();
            int y = djikstraState.y();
            int cost = djikstraState.cost();
            Cell cell = new Cell(y, x);
            if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
                continue;
            }
            if (visited.contains(cell)) {
                continue;
            }
            if (corruptedPositions.contains(cell)) {
                continue;
            }
            if (y == this.height - 1 && x == this.width - 1) {
                return cost;
            }
            priorityQueue.add(new DjikstraState(x + 1, y, cost + 1));
            priorityQueue.add(new DjikstraState(x - 1, y, cost + 1));
            priorityQueue.add(new DjikstraState(x, y + 1, cost + 1));
            priorityQueue.add(new DjikstraState(x, y - 1, cost + 1));
            visited.add(cell);
        }
        return -1;
    }
}
