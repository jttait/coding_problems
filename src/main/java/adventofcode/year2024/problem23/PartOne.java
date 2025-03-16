package adventofcode.year2024.problem23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartOne {
    private final Set<String> computers;
    private final Set<Connection> connections;
    private final Map<String, Set<String>> neighbours;
    private final Set<Set<String>> parties;

    public PartOne(Set<Connection> connections) {
        this.connections = connections;
        this.computers = findComputers();
        this.neighbours = findNeighbours();
        this.parties = findParties();
    }

    public Set<Set<String>> getParties() {
        return this.parties;
    }

    public Map<String, Set<String>> getNeighbours() {
        return this.neighbours;
    }

    public Set<String> getComputers() {
        return this.computers;
    }

    public Set<Connection> getConnections() {
        return this.connections;
    }

    private Set<String> findComputers() {
        Set<String> result = new HashSet<>();
        for (Connection connection : this.connections) {
            result.add(connection.computer1());
            result.add(connection.computer2());
        }
        return result;
    }

    private Map<String, Set<String>> findNeighbours() {
        Map<String, Set<String>> result = new HashMap<>();
        for (Connection connection : this.connections) {
            result.putIfAbsent(connection.computer1(), new HashSet<>());
            result.get(connection.computer1()).add(connection.computer2());
            result.putIfAbsent(connection.computer2(), new HashSet<>());
            result.get(connection.computer2()).add(connection.computer1());
        }
        return result;
    }

    private Set<Set<String>> findParties() {
        Set<Set<String>> result = new HashSet<>();
        for (String computer : this.computers) {
            for (String connectedComputer1 : this.neighbours.get(computer)) {
                for (String connectedComputer2 : this.neighbours.get(computer)) {
                    if (!connectedComputer1.equals(connectedComputer2) && this.neighbours.get(connectedComputer1).contains(connectedComputer2)) {
                        result.add(Set.of(computer, connectedComputer1, connectedComputer2));
                    }
                }
            }
        }
        return result;
    }
}
