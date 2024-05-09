package leetcode.problem3075;

import java.util.Arrays;

public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0;
        int decrement = 0;
        for (int i = happiness.length - 1; i >= 0 && k > 0 && happiness[i] - decrement > 0; i--) {
            result += happiness[i] - decrement;
            k--;
            decrement++;
        }
        return result;
    }
}
