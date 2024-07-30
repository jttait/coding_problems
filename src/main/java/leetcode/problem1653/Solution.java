package leetcode.problem1653;

public class Solution {
    public int minimumDeletions(String s) {
        int[] asAfter = new int[s.length()];
        int count = (s.charAt(s.length()-1) == 'a') ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            asAfter[i] = count;
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        int bsBefore = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            result = Math.min(result, bsBefore + asAfter[i]);
            if (s.charAt(i) == 'b') {
                bsBefore++;
            }
        }
        return result;
    }
}
