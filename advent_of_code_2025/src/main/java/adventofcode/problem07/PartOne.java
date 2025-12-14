package adventofcode.problem07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartOne {
    public List<List<Character>> grid;

    public PartOne(List<List<Character>> grid) {
        this.grid = grid;
    }

    public int simulate() {
        int result = 0;
        Set<Integer> tachyons = new HashSet<>();
        for (int col = 0; col < grid.get(0).size(); col++) {
            if (grid.get(0).get(col) == 'S') {
                tachyons.add(col);
            }
        }
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(row).size(); col++) {
                if (tachyons.contains(col)) {
                    if (grid.get(row).get(col) == '^') {
                        tachyons.remove(col);
                        tachyons.add(col-1);
                        tachyons.add(col+1);
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
