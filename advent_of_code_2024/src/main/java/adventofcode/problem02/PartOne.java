package adventofcode.problem02;

import java.util.List;

public class PartOne {
    public boolean areLevelsSafe(List<Integer> levels) {
        if (areLevelsAllIncreasing(levels)) {
            return true;
        }
        return areLevelsAllDecreasing(levels);
    }

    private boolean areLevelsAllIncreasing(List<Integer> levels) {
        for (int i = 1; i < levels.size(); i++) {
            if (levels.get(i) <= levels.get(i-1) || levels.get(i) > levels.get(i-1) + 3) {
                return false;
            }
        }
        return true;
    }

    private boolean areLevelsAllDecreasing(List<Integer> levels) {
        for (int i = 1; i < levels.size(); i++) {
            if (levels.get(i) >= levels.get(i-1) || levels.get(i) < levels.get(i-1) - 3) {
                return false;
            }
        }
        return true;
    }
}
