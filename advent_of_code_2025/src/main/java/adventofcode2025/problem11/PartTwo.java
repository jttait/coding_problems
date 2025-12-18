package adventofcode2025.problem11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PartTwo {
    private final Map<String, Set<String>> connections;
    private final Map<String, Long> cache;

    public PartTwo(Map<String, Set<String>> connections) {
        this.connections = connections;
        this.cache = new HashMap<>();
    }

    public long countPathsFromSvrToOut() {
        long svrToDac = dfs("svr", "dac");
        long dacToFft = dfs("dac", "fft");
        long fftToOut = dfs("fft", "out");
        long svrToFft = dfs("svr", "fft");
        long fftToDac = dfs("fft", "dac");
        long dacToOut = dfs("dac", "out");
        return (svrToDac * dacToFft * fftToOut) + (svrToFft * fftToDac * dacToOut);
    }

    private long dfs(String current, String target) {
        if (current.equals(target)) {
            return 1;
        }
        if (this.cache.containsKey(current + "->" + target)) {
            return this.cache.get(current + "->" + target);
        }
        if (!connections.containsKey(current)) {
            return 0;
        }
        long result = 0;
        for (String device : connections.get(current)) {
            result += dfs(device, target);
        }
        this.cache.put(current + "->" + target, result);
        return result;
    }
}
