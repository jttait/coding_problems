package adventofcode.year2025.problem08;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private final Map<JunctionBox, JunctionBox> parent = new HashMap<>();

    public JunctionBox find(JunctionBox jb) {
        parent.putIfAbsent(jb, jb);
        if (!parent.get(jb).equals(jb)) {
            parent.put(jb, find(parent.get(jb)));
        }
        return parent.get(jb);
    }

    public void union(JunctionBox jb1, JunctionBox jb2) {
        JunctionBox rootA = find(jb1);
        JunctionBox rootB = find(jb2);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}
