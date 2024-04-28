package leetcode.problem26;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }
}
