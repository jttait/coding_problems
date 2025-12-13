package adventofcode.year2025.problem08;

import java.util.*;

public class PartOne {

    public int calculateThreeLargestCircuits(List<JunctionBox> junctionBoxes, int pairs) {
        PriorityQueue<Connection> priorityQueue = new PriorityQueue<>((connection1, connection2) -> {
            if (connection1.distance() == connection2.distance()) {
                return 0;
            }
            return (connection1.distance() > connection2.distance()) ? 1 : -1;
        });

        for (int i = 0; i < junctionBoxes.size(); i++) {
            for (int j = i + 1; j < junctionBoxes.size(); j++) {
                double distance = junctionBoxes.get(i).distanceBetween(junctionBoxes.get(j));
                priorityQueue.add(new Connection(junctionBoxes.get(i), junctionBoxes.get(j), distance));
            }
        }

        List<Set<JunctionBox>> circuits = new ArrayList<>();
        while (pairs > 0 && !priorityQueue.isEmpty()) {
            Connection connection = priorityQueue.poll();
            JunctionBox jb1 = connection.jb1();
            JunctionBox jb2 = connection.jb2();
            circuits.add(Set.of(jb1, jb2));
            pairs--;
        }

        circuits = mergeOverlappingSets(circuits);

        circuits.sort((c1, c2) -> {
            if (c1.size() == c2.size()) {
                return 0;
            }
            return c1.size() > c2.size() ? -1 : 1;
        });

        int result = 1;
        for (int i = 0; i < Math.min(3, circuits.size()); i++) {
            result *= circuits.get(i).size();
        }
        return result;
    }

    private List<Set<JunctionBox>> mergeOverlappingSets(List<Set<JunctionBox>> circuits) {
        UnionFind uf = new UnionFind();
        for (Set<JunctionBox> circuit : circuits) {
            Iterator<JunctionBox> it = circuit.iterator();
            if (!it.hasNext()) continue;
            JunctionBox first = it.next();
            while (it.hasNext()) {
                uf.union(first, it.next());
            }
        }
        Map<JunctionBox, Set<JunctionBox>> groups = new HashMap<>();
        for (Set<JunctionBox> circuit : circuits) {
            for (JunctionBox jb : circuit) {
                JunctionBox root = uf.find(jb);
                groups.computeIfAbsent(root, k -> new HashSet<>()).add(jb);
            }
        }
        return new ArrayList<>(groups.values());
    }
}
