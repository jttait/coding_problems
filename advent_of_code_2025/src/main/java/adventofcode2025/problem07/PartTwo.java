package adventofcode2025.problem07;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    public List<List<Character>> grid;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
    }

    public long simulate() {
        List<Long> timelines = new ArrayList<>();
        for (int col = 0; col < grid.get(0).size(); col++) {
            if (grid.get(0).get(col) == 'S') {
                timelines.add(1L);
            } else {
                timelines.add(0L);
            }
        }
        for (int row = 1; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(row).size(); col++) {
                if (grid.get(row).get(col) == '^') {
                    timelines.set(col-1, timelines.get(col-1) + timelines.get(col));
                    timelines.set(col+1, timelines.get(col+1) + timelines.get(col));
                    timelines.set(col, 0L);
                }
            }
        }
        long result = 0;
        for (int col = 0; col < grid.get(0).size(); col++) {
            result += timelines.get(col);
        }
        return result;
    }
}
