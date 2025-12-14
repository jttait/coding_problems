package adventofcode.problem02;

import adventofcode.problem02.PartOne;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    public boolean areLevelsSafeWithProblemDampener(List<Integer> levels) {
        PartOne partOne = new PartOne();
        for (int i = 0; i < levels.size(); i++) {
            if (partOne.areLevelsSafe(removeLevelAtIndex(levels, i))) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> removeLevelAtIndex(List<Integer> levels, int index) {
        List<Integer> result = new ArrayList<>(levels);
        result.remove(index);
        return result;
    }
}
