package leetcode.problem1219;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<String> visited;
    private int result;
    private int[][] grid;

    public Solution() {
        this.visited = new HashSet<>();
        this.result = 0;
    }

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                this.visited = new HashSet<>();
                result = Math.max(result, dfs(row, col));
            }
        }
        return result;
    }

    private int dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited.contains(String.valueOf(row)+String.valueOf(col))) {
            return 0;
        }
        visited.add(String.valueOf(row)+String.valueOf(col));
        int result = 0;
        result = Math.max(result, dfs(row-1, col));
        result = Math.max(result, dfs(row+1, col));
        result = Math.max(result, dfs(row, col-1));
        result = Math.max(result, dfs(row, col+1));
        visited.remove(String.valueOf(row)+String.valueOf(col));
        return result + grid[row][col];
    }
}
