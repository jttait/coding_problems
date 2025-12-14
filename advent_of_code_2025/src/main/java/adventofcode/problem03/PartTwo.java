package adventofcode.problem03;

import java.util.LinkedList;
import java.util.List;

public class PartTwo {
    public long findLargestJoltage(List<Integer> batteries) {
        LinkedList<Integer> digits = new LinkedList<>();
        for (Integer battery : batteries) {
            digits = shiftLeft(digits);
            if (digits.size() < 12) {
                digits.add(battery);
            } else if (battery > digits.get(11)) {
                digits.set(11, battery);
            }
        }
        long result = 0;
        long multiplier = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            long digit = digits.get(i);
            result += digit * multiplier;
            multiplier *= 10;
        }
        return result;
    }

    private LinkedList<Integer> shiftLeft(LinkedList<Integer> input) {
        LinkedList<Integer> result = new LinkedList<>();

        if (input.size() < 12) {
            result.addAll(input);
            return result;
        }

        int i = 0;
        boolean shifted = false;
        while (i < input.size() - 1 && !shifted) {
            if (input.get(i+1) > input.get(i)) {
                result.add(input.get(i+1));
                shifted = true;
                i += 2;
            } else {
                result.add(input.get(i));
                i++;
            }
        }
        while (i < input.size()) {
            result.add(input.get(i));
            i++;
        }
        return result;
    }
}
