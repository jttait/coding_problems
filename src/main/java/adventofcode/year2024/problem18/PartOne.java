package adventofcode.year2024.problem18;

import adventofcode.year2024.common.Position;
import adventofcode.year2024.common.DjikstraState;

import java.util.*;

public class PartOne {
    private final int width;
    private final int height;
    private final List<Position> fallingBytes;
    private final Set<Position> corruptedPositions;

    public PartOne(int width, int height, List<Position> fallingBytes) {
        this.width = width;
        this.height = height;
        this.fallingBytes = fallingBytes;
        this.corruptedPositions = new HashSet<>();
    }

    public void simulate(int ticks) {
        for (int tick = 0; tick < ticks; tick++) {
            if (tick > fallingBytes.size() - 1) {
                return;
            }
            this.corruptedPositions.add(fallingBytes.get(tick));
        }
    }

    public int findShortestPath() {
        Set<Position> visited = new HashSet<>();
        PriorityQueue<DjikstraState> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(DjikstraState::cost));
        priorityQueue.add(new DjikstraState(0, 0, 0));
        while (!priorityQueue.isEmpty()) {
            DjikstraState djikstraState = priorityQueue.poll();
            int x = djikstraState.x();
            int y = djikstraState.y();
            int cost = djikstraState.cost();
            Position position = new Position(y, x);
            if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
                continue;
            }
            if (visited.contains(position)) {
                continue;
            }
            if (this.corruptedPositions.contains(position)) {
                continue;
            }
            if (y == this.height - 1 && x == this.width - 1) {
                return cost;
            }
            priorityQueue.add(new DjikstraState(x + 1, y, cost + 1));
            priorityQueue.add(new DjikstraState(x - 1, y, cost + 1));
            priorityQueue.add(new DjikstraState(x, y + 1, cost + 1));
            priorityQueue.add(new DjikstraState(x, y - 1, cost + 1));
            visited.add(position);
        }
        return -1;
    }
}
