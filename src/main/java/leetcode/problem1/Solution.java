package leetcode.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.get(nums[i]).add(i);
            } else {
                m.put(nums[i], new ArrayList<>());
                m.get(nums[i]).add(i);
            }
        }
        for (int num : nums) {
            int remaining = target - num;
            if (m.containsKey(remaining) && num == remaining) {
                return new int[]{m.get(remaining).get(0), m.get(remaining).get(1)};
            } else if (m.containsKey(remaining)) {
                return new int[]{m.get(remaining).get(0), num};
            }
        }
        return new int[]{-1,-1};
    }
}
