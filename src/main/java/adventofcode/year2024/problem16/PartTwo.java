package adventofcode.year2024.problem16;

import adventofcode.year2024.common.Heading;
import adventofcode.year2024.common.Position;

import java.util.*;

public class PartTwo {
    private final List<List<Character>> grid;
    private final Position start;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
        this.start = Utils.findStart(grid);
    }

    public int findBestSeats() {
        PartOne partOne = new PartOne(grid);
        int bestScore = partOne.findLowestScore();
        Map<Pose, Integer> lowestScores = new HashMap<>();
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                lowestScores.put(new Pose(x, y, Heading.NORTH), Integer.MAX_VALUE);
                lowestScores.put(new Pose(x, y, Heading.EAST), Integer.MAX_VALUE);
                lowestScores.put(new Pose(x, y, Heading.SOUTH), Integer.MAX_VALUE);
                lowestScores.put(new Pose(x, y, Heading.WEST), Integer.MAX_VALUE);
            }
        }
        Set<Position> bestSeats = new HashSet<>();
        PriorityQueue<State2> pq = new PriorityQueue<>(Comparator.comparingInt(State2::score));
        pq.add(new State2(start.x(), start.y(), Heading.EAST, 0, new HashSet<>()));
        while (!pq.isEmpty()) {
            State2 state = pq.poll();
            if (state == null) {
                continue;
            }
            int x = state.x();
            int y = state.y();
            int score = state.score();
            Heading heading = state.heading();
            Set<Position> route = state.route();
            if (score > lowestScores.get(new Pose(x, y, heading))) {
                continue;
            }
            if (route.contains(new Position(x, y))) {
                continue;
            }
            if (grid.get(y).get(x) == '#') {
                continue;
            }
            if (grid.get(y).get(x) == 'E') {
                if (score == bestScore) {
                    bestSeats.addAll(route);
                }
                continue;
            }
            lowestScores.put(new Pose(x, y, heading), score);
            Set<Position> newRoute = new HashSet<>(route);
            newRoute.add(new Position(x, y));
            pq.add(new State2(x, y - 1, Heading.NORTH, score + Utils.rotationCost(heading, Heading.NORTH) + 1, newRoute));
            pq.add(new State2(x + 1, y, Heading.EAST, score + Utils.rotationCost(heading, Heading.EAST) + 1, newRoute));
            pq.add(new State2(x, y + 1, Heading.SOUTH, score + Utils.rotationCost(heading, Heading.SOUTH) + 1, newRoute));
            pq.add(new State2(x - 1, y, Heading.WEST, score + Utils.rotationCost(heading, Heading.WEST) + 1, newRoute));
        }
        return bestSeats.size() + 1;
    }
}
