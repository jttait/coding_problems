package adventofcode2025.problem11;

import java.util.Map;
import java.util.Set;

public class PartOne {
    private final Map<String, Set<String>> connections;
    private int count;

    public PartOne(Map<String, Set<String>> connections) {
        this.connections = connections;
        this.count = 0;
    }

    public int countPathsFromYouToOut() {
        dfs("you");
        return count;
    }

    private void dfs(String device) {
        if (device.equals("out")) {
            this.count++;
        }
        if (!connections.containsKey(device)) {
            return;
        }
        for (String connectedDevice : connections.get(device)) {
            dfs(connectedDevice);
        }
    }
}
