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
    private final Map<String, List<List<Character>>> shortestPathsCache;

    public Keypad2(Grid grid) {
        if (grid == Grid.NUMERIC) {
            this.grid = numericGrid;
        } else {
            this.grid = directionalGrid;
        }
        this.precedingKeypad = null;
        this.cache = new HashMap<>();
        this.shortestPathsCache = new HashMap<>();
    }

    public void setPrecedingKeypad(Keypad2 precedingKeypad) {
        this.precedingKeypad = precedingKeypad;
    }

    public long solve(char start, char end) {
        if (cache.containsKey(start + "," + end)) {
            return cache.get(start + "," + end);
        }
        List<List<Character>> paths = shortestPaths(start, end);
        if (precedingKeypad == null) {
            long result = paths.stream().map(List::size).min(Comparator.comparingInt(a -> a)).get();
            cache.put(start + "," + end, result);
            return result;
        }
        long result = Long.MAX_VALUE;
        for (List<Character> path : paths) {
            long pathLength = precedingKeypad.solve('A', path.get(0));
            for (int i = 0; i < path.size() - 1; i++) {
                pathLength += precedingKeypad.solve(path.get(i), path.get(i + 1));
            }
            result = Math.min(result, pathLength);
        }
        cache.put(start + "," + end, result);
        return result;
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

    public List<List<Character>> shortestPaths(Character start, Character end) {
        if (shortestPathsCache.containsKey(start + "," + end)) {
            return shortestPathsCache.get(start + "," + end);
        }
        Position current = find(start);
        List<List<Character>> result = new ArrayList<>();
        PriorityQueue<DijkstraStateWithPath> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(DijkstraStateWithPath::cost));
        priorityQueue.add(new DijkstraStateWithPath(current.x(), current.y(), 0, new ArrayList<>(), new HashSet<>()));
        int lowestCost = Integer.MAX_VALUE;
        while (!priorityQueue.isEmpty()) {
            DijkstraStateWithPath dijkstraState = priorityQueue.poll();
            int x = dijkstraState.x();
            int y = dijkstraState.y();
            int cost = dijkstraState.cost();
            List<Character> path = dijkstraState.path();
            Set<Position> visited = dijkstraState.visited();
            if (grid.get(y).get(x) == end && cost <= lowestCost) {
                result.add(List.copyOf(addToImmutableList(path, 'A')));
                lowestCost = cost;
            }
            Position position = new Position(x, y);
            if (visited.contains(position)) {
                continue;
            }
            if (grid.get(y).get(x + 1) != '#') {
                priorityQueue.add(new DijkstraStateWithPath(x + 1, y, cost + 1, addToImmutableList(path, '>'), addToImmutableSet(visited, position)));
            }
            if (grid.get(y).get(x - 1) != '#') {
                priorityQueue.add(new DijkstraStateWithPath(x - 1, y, cost + 1, addToImmutableList(path, '<'), addToImmutableSet(visited, position)));
            }
            if (grid.get(y + 1).get(x) != '#') {
                priorityQueue.add(new DijkstraStateWithPath(x, y + 1, cost + 1, addToImmutableList(path, 'v'), addToImmutableSet(visited, position)));
            }
            if (grid.get(y - 1).get(x) != '#') {
                priorityQueue.add(new DijkstraStateWithPath(x, y - 1, cost + 1, addToImmutableList(path, '^'), addToImmutableSet(visited, position)));
            }
        }
        shortestPathsCache.put(start + "," + end, result);
        return result;
    }

    private List<Character> addToImmutableList(List<Character> immutableList, Character item) {
        List<Character> temp = new ArrayList<>(immutableList);
        temp.add(item);
        return List.copyOf(temp);
    }

    private Set<Position> addToImmutableSet(Set<Position> immutableSet, Position item) {
        Set<Position> temp = new HashSet<>(immutableSet);
        temp.add(item);
        return Set.copyOf(temp);
    }
}

