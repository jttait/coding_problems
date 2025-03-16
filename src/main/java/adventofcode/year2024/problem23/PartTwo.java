package adventofcode.year2024.problem23;

import java.util.HashSet;
import java.util.Set;

public class PartTwo {
    private final PartOne partOne;
    private Set<String> longestInterconnectedParty;
    private Set<Set<String>> visited;

    public PartTwo(Set<Connection> connections) {
        this.partOne = new PartOne(connections);
        this.longestInterconnectedParty = new HashSet<>();
        this.visited = new HashSet<>();
    }

    public Set<String> findLargestFullyInterconnectedParty() {
        for (String computer : partOne.getComputers()) {
            dfs(computer, new HashSet<>());
        }
        return this.longestInterconnectedParty;
    }

    private void dfs(String computer, Set<String> party) {
        if (party.contains(computer)) {
            return;
        }
        if (!partOne.getNeighbours().get(computer).containsAll(party)) {
            return;
        }
        party = new HashSet<>(party);
        party.add(computer);
        if (this.visited.contains(party)) {
            return;
        }
        if (party.size() > this.longestInterconnectedParty.size()) {
            this.longestInterconnectedParty = Set.copyOf(party);
        }
        for (String neighbour : partOne.getNeighbours().get(computer)) {
            dfs(neighbour, Set.copyOf(party));
        }
        this.visited.add(Set.copyOf(party));
    }
}
