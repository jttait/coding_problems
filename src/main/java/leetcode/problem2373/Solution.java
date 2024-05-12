package leetcode.problem2373;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for (int row = 1; row < n-1; row++) {
            for (int col = 1; col < n-1; col++) {
                int maximum = 0;
                for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
                    for (int colDiff = -1; colDiff <= 1; colDiff++) {
                        maximum = Math.max(maximum, grid[row+rowDiff][col+colDiff]);
                    }
                }
                result[row-1][col-1] = maximum;
            }
        }
        return result;
    }
}
