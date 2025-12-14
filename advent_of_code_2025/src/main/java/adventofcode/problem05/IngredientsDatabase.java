package adventofcode.problem05;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record IngredientsDatabase(List<Range> freshIngredients, Set<Long> availableIngredients) {
    public long countFreshIngredients() {
        long result = 0;
        for (long availableIngredient : availableIngredients) {
            for (Range range : freshIngredients) {
                if (range.contains(availableIngredient)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public long countAllPossibleFreshIngredients() {
        List<Range> ranges = new ArrayList<>();
        for (Range freshIngredient : freshIngredients) {
            ranges.add(new Range(freshIngredient.start(), freshIngredient.end()));
        }
        combineOverlapping(ranges);
        long result = 0;
        for (Range range : ranges) {
            result += range.end() - range.start() + 1;
        }
        return result;
    }

    private int countOverlapping(List<Range> ranges) {
        int result = 0;
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i + 1; j < ranges.size(); j++) {
                if (ranges.get(i).isOverlapping(ranges.get(j))) {
                    result++;
                }
            }
        }
        return result;
    }

    private void combineOverlapping(List<Range> ranges) {
        while (countOverlapping(ranges) > 0) {
            combineNextOverlapping(ranges);
        }
    }

    private void combineNextOverlapping(List<Range> ranges) {
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i + 1; j < ranges.size(); j++) {
                if (ranges.get(i).isOverlapping(ranges.get(j))) {
                    long start = Math.min(ranges.get(i).start(), ranges.get(j).start());
                    long end = Math.max(ranges.get(i).end(), ranges.get(j).end());
                    ranges.set(i, new Range(start, end));
                    ranges.remove(j);
                    return;
                }
            }
        }
    }
}
