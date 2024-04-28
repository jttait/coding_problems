package leetcode.problem70;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0;
        int twoSteps = 1;
        int oneStep = 2;
        for (int i = n - 3; i >= 0; i--) {
            result = twoSteps + oneStep;
            twoSteps = oneStep;
            oneStep = result;
        }
        return result;
    }
}
