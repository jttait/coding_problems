package leetcode.problem1937;

public class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int col = 0; col < n; col++) {
            dp[col] = points[0][col];
        }
        for (int row = 1; row < m; row++) {
            long[] current = new long[n];
            long[] left = new long[n];
            left[0] = dp[0];
            for (int col = 1; col < n; col++) {
                left[col] = Math.max(left[col - 1] - 1, dp[col]);
            }
            long[] right = new long[n];
            right[n-1] = dp[n-1];
            for (int col = n-2; col >= 0; col--) {
                right[col] = Math.max(right[col+1]-1, dp[col]);
            }
            for (int col = 0; col < n; col++) {
                current[col] = Math.max(current[col], points[row][col] + Math.max(left[col], right[col]));
            }
            dp = current.clone();
        }
        long result = 0;
        for (int col = 0; col < n; col++) {
            result = Math.max(result, dp[col]);
        }
        return result;
    }
}
