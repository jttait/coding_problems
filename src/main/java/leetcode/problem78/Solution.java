package leetcode.problem78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        recursion(nums, 0, new ArrayList<>());
        return this.result;
    }

    private void recursion(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        recursion(nums, index + 1, list);
        list.remove(list.size()-1);
        recursion(nums, index + 1, list);
    }
}
