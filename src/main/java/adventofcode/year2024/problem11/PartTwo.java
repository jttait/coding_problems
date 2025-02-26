package adventofcode.year2024.problem11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {
    private final Map<CacheEntry, Long> cache;

    public PartTwo() {
        this.cache = new HashMap<>();
    }

    public long stoneAfterBlinks(List<Long> stones, int blinks) {
        long result = 0;
        for (long stone : stones) {
            result += recursion(stone, blinks);
        }
        return result;
    }

    private long recursion(long stone, int blinks) {
        if (blinks <= 0) {
            return 1;
        }
        CacheEntry cacheEntry = new CacheEntry(stone, blinks);
        if (this.cache.containsKey(cacheEntry)) {
            return this.cache.get(cacheEntry);
        }
        int numDigits = String.valueOf(stone).length();
        long result = 0;
        if (stone == 0) {
            result = recursion(1, blinks - 1);
        } else if (numDigits % 2 == 0) {
            String string = String.valueOf(stone);
            result += recursion(Long.parseLong(string.substring(0, string.length()/2)), blinks - 1);
            result += recursion(Long.parseLong(string.substring(string.length()/2)), blinks - 1);
        } else {
            result = recursion(stone * 2024, blinks - 1);
        }
        this.cache.put(cacheEntry, result);
        return result;
    }
}
