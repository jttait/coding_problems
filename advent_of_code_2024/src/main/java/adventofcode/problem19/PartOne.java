package adventofcode.problem19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartOne {
    private Map<Integer, Boolean> cache;
    private final Set<String> availableTowels;

    public PartOne(List<String> availableTowels) {
        this.cache = new HashMap<>();
        this.availableTowels = Set.copyOf(availableTowels);
    }

    public int countPossibleDesigns(List<String> designs) {
        int result = 0;
        for (String design : designs) {
            if (isDesignPossible(design)) {
                result++;
            }
        }
        return result;
    }

    public boolean isDesignPossible(String design) {
        this.cache = new HashMap<>();
        return dfs(0, design);
    }

    private boolean dfs(int index, String design) {
        if (this.cache.containsKey(index)) {
            return this.cache.get(index);
        }
        if (index == design.length()) {
            return true;
        }
        for (String towel : this.availableTowels) {
            if (design.startsWith(towel, index) && dfs(index + towel.length(), design)) {
                return true;
            }
        }
        this.cache.put(index, false);
        return false;
    }
}
