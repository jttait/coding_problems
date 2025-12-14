package adventofcode.problem25;

import java.util.List;

public class PartOne {
    private final List<List<Integer>> locks;
    private final List<List<Integer>> keys;
    
    public PartOne(List<List<Integer>> locks, List<List<Integer>> keys) {
        this.locks = locks;
        this.keys = keys;
    }

    public int countFittingLocksAndKeys() {
        int result = 0;
        for (List<Integer> lock : locks) {
            for (List<Integer> key : keys) {
                if (fits(lock, key)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean fits(List<Integer> lock, List<Integer> key) {
        for (int i = 0; i < 5; i++) {
            if (key.get(i) > 5 - lock.get(i)) {
                return false;
            }
        }
        return true;
    }
}
