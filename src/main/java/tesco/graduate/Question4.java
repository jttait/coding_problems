package tesco.graduate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question4 {
    public static int lowestMissing(List<Integer> list) {
        Set<Integer> existing = new HashSet<>(list);
        int result = 1;
        while (existing.contains(result)) {
            result++;
        }
        return result;
    }
}
