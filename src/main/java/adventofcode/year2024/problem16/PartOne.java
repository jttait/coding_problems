package adventofcode.year2024.problem16;

import java.util.*;

public class PartOne {
    private final List<List<Character>> grid;
    private final Position start;

    public PartOne(List<List<Character>> grid) {
        this.grid = grid;
        this.start = Utils.findStart(grid);
    }

    public int findLowestScore() {
        Set<String> visited = new HashSet<>();
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(State::score));
        pq.add(new State(start.x(), start.y(), Heading.EAST, 0));
        while (true) {
            State state = pq.poll();
            if (state == null) {
                continue;
            }
            int x = state.pose().position().x();
            int y = state.pose().position().y();
            int score = state.score();
            Heading heading = state.pose().heading();
            if (visited.contains(x + "," + y)) {
                continue;
            }
            if (grid.get(y).get(x) == '#') {
                continue;
            }
            if (grid.get(y).get(x) == 'E') {
                return score;
            }
            pq.add(new State(x, y - 1, Heading.NORTH, score + Utils.rotationCost(heading, Heading.NORTH) + 1));
            pq.add(new State(x + 1, y, Heading.EAST, score + Utils.rotationCost(heading, Heading.EAST) + 1));
            pq.add(new State(x, y + 1, Heading.SOUTH, score + Utils.rotationCost(heading, Heading.SOUTH) + 1));
            pq.add(new State(x - 1, y, Heading.WEST, score + Utils.rotationCost(heading, Heading.WEST) + 1));
            visited.add(x + "," + y);
        }
    }
}
