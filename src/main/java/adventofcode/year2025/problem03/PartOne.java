package adventofcode.year2025.problem03;

import java.util.List;

public class PartOne {
    public int findLargestJoltage(List<Integer> batteries) {
        if (batteries.isEmpty()) {
            return 0;
        }
        if (batteries.size() == 1) {
            return batteries.get(0);
        }
        int tens = batteries.get(0);
        int ones = batteries.get(1);
        for (int i = 2; i < batteries.size(); i++) {
            if (ones > tens) {
                tens = ones;
                ones = batteries.get(i);
            } else if (batteries.get(i) > ones) {
                ones = batteries.get(i);
            }
        }
        return tens * 10 + ones;
    }
}
