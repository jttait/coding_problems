package leetcode.problem2441;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaxK(int[] nums) {
        Set<Integer> negativeNumbers = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                negativeNumbers.add(num * -1);
            }
        }
        int result = -1;
        for (int num : nums) {
            if (num > 0 && negativeNumbers.contains(num)) {
                result = Math.max(result, num);
            }
        }
        return result;
    }
}
