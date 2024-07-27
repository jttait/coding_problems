package leetcode.problem2976;

public class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int originalIndex = original[i] - 'a';
            int changedIndex = changed[i] - 'a';
            dist[originalIndex][changedIndex] = Math.min(dist[originalIndex][changedIndex], cost[i]);
        }
        /* Floyd Warshall */
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceIndex = source.charAt(i) - 'a';
            int targetIndex = target.charAt(i) - 'a';
            if (dist[sourceIndex][targetIndex] == Integer.MAX_VALUE / 2) {
                return -1;
            }
            result += dist[sourceIndex][targetIndex];

        }
        return result;
    }
}
