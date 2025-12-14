package adventofcode.problem19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartTwo {
    private Map<Integer, Long> cache;
    private final Set<String> availableTowels;

    public PartTwo(List<String> availableTowels) {
        this.availableTowels = Set.copyOf(availableTowels);
        this.cache = new HashMap<>();
    }

    public long countPossibleArrangements(String design) {
        this.cache = new HashMap<>();
        return dfs("", 0, design);
    }

    private long dfs(String arrangement, int index, String design) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index == design.length()) {
            return 1;
        }
        long count = 0;
        for (String towel : this.availableTowels) {
            if (design.startsWith(towel, index)) {
                count += dfs(arrangement + towel, index + towel.length(), design);
            }
        }
        this.cache.put(index, count);
        return count;
    }

    public long countPossibleArrangementsForDesigns(List<String> designs) {
        long result = 0;
        for (String design : designs) {
            result += countPossibleArrangements(design);
        }
        return result;
    }
}
