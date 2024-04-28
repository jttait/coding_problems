package leetcode.problem169;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        int N = nums.length / 2;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num)+1);
            if (counts.get(num) > N) {
                return num;
            }
        }
        return -1;
    }
}
