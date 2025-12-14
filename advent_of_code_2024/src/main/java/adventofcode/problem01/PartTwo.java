package adventofcode.problem01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {

    public int similarityScore(List<Integer> left, List<Integer> right) {
        Map<Integer, Integer> leftOccurrences = new HashMap<>();
        Map<Integer, Integer> rightOccurrences = new HashMap<>();
        for (int i = 0; i < left.size(); i++) {
            int leftNumber = left.get(i);
            leftOccurrences.putIfAbsent(leftNumber, 0);
            leftOccurrences.put(leftNumber, leftOccurrences.get(leftNumber) + 1);
            int rightNumber = right.get(i);
            rightOccurrences.putIfAbsent(rightNumber, 0);
            rightOccurrences.put(rightNumber, rightOccurrences.get(rightNumber) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : leftOccurrences.entrySet()) {
            int rightOccurrence = rightOccurrences.getOrDefault(entry.getKey(), 0);
            result += entry.getKey() * entry.getValue() * rightOccurrence;
        }
        return result;
    }
}
