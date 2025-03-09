package adventofcode.year2024.problem01;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

    public int totalDistance(List<Integer> left, List<Integer> right) {
        left = new ArrayList<>(left);
        left.sort(Integer::compareTo);
        right = new ArrayList<>(right);
        right.sort(Integer::compareTo);
        int result = 0;
        for (int i = 0; i < left.size(); i++) {
            result += Math.abs(left.get(i) - right.get(i));
        }
        return result;
    }
}
