package adventofcode.year2024.problem21;

import adventofcode.year2024.common.Position;

import java.util.*;

public class Keypad2 {
    private static final List<List<Character>> directionalGrid = List.of(
            List.of('#', '#', '#', '#', '#'),
            List.of('#', '#', '^', 'A', '#'),
            List.of('#', '<', 'v', '>', '#'),
            List.of('#', '#', '#', '#', '#')
    );
    private static final List<List<Character>> numericGrid = List.of(
            List.of('#', '#', '#', '#', '#'),
            List.of('#', '7', '8', '9', '#'),
            List.of('#', '4', '5', '6', '#'),
            List.of('#', '1', '2', '3', '#'),
            List.of('#', '#', '0', 'A', '#'),
            List.of('#', '#', '#', '#', '#')
    );
    private final List<List<Character>> grid;
    private Keypad2 precedingKeypad;
    private final Map<String, Long> cache;

    public Keypad2(Grid grid) {
        if (grid == Grid.NUMERIC) {
            this.grid = numericGrid;
        } else {
            this.grid = directionalGrid;
        }
        this.precedingKeypad = null;
        this.cache = new HashMap<>();
    }

    public void setPrecedingKeypad(Keypad2 precedingKeypad) {
        this.precedingKeypad = precedingKeypad;
    }

    public long lengthOfShortestPath(Character start, Character end) {
        if (cache.containsKey(start + "," + end)) {
            return cache.get(start + "," + end);
        }
        Position current = find(start);
        PriorityQueue<DijkstraState2> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(DijkstraState2::cost));
        priorityQueue.add(new DijkstraState2(current.x(), current.y(), 0, new HashSet<>(), 'A'));
        while (!priorityQueue.isEmpty()) {
            DijkstraState2 dijkstraState = priorityQueue.poll();
            int x = dijkstraState.x();
            int y = dijkstraState.y();
            long cost = dijkstraState.cost();
            Set<Position> visited = dijkstraState.visited();
            char prev = dijkstraState.prev();
            if (grid.get(y).get(x) == end) {
                cost += ((precedingKeypad == null) ? 1 : precedingKeypad.lengthOfShortestPath(prev, 'A'));
                cache.put(start + "," + end, cost);
                return cost;
            }
            Position position = new Position(x, y);
            if (visited.contains(position)) {
                continue;
            }
            if (grid.get(y).get(x + 1) != '#') {
                priorityQueue.add(
                        new DijkstraState2(
                                x + 1,
                                y,
                                (precedingKeypad == null) ? cost + 1 : cost + precedingKeypad.lengthOfShortestPath(prev, '>'),
                                addToImmutableSet(visited, position),
                                '>'
                        )
                );
            }
            if (grid.get(y).get(x - 1) != '#') {
                priorityQueue.add(
                        new DijkstraState2(
                                x - 1,
                                y,
                                (precedingKeypad == null) ? cost + 1 : cost + precedingKeypad.lengthOfShortestPath(prev, '<'),
                                addToImmutableSet(visited, position),
                                '<'
                        )
                );
            }
            if (grid.get(y + 1).get(x) != '#') {
                priorityQueue.add(
                        new DijkstraState2(
                                x,
                                y + 1,
                                (precedingKeypad == null) ? cost + 1 : cost + precedingKeypad.lengthOfShortestPath(prev, 'v'),
                                addToImmutableSet(visited, position),
                                'v'
                        )
                );
            }
            if (grid.get(y - 1).get(x) != '#') {
                priorityQueue.add(
                        new DijkstraState2(
                                x,
                                y - 1,
                                (precedingKeypad == null) ? cost + 1 : cost + precedingKeypad.lengthOfShortestPath(prev, '^'),
                                addToImmutableSet(visited, position),
                                '^'
                        )
                );
            }
        }
        return -1;
    }

    private Position find(Character c) {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == c) {
                    return new Position(x, y);
                }
            }
        }
        return new Position(-1, -1);
    }

    private Set<Position> addToImmutableSet(Set<Position> immutableSet, Position item) {
        Set<Position> temp = new HashSet<>(immutableSet);
        temp.add(item);
        return Set.copyOf(temp);
    }
}

