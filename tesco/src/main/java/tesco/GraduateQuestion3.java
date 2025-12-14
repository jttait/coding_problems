package tesco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraduateQuestion3 {
    public static int mode(List<Integer> list) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int item : list) {
            occurrences.putIfAbsent(item, 0);
            occurrences.put(item, occurrences.get(item) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
