package leetcode.problem165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int longestArray = Math.max(array1.length, array2.length);
        for (int i = 0; i < longestArray; i++) {
            int rev1 = (i < array1.length ? Integer.parseInt(array1[i]) : 0);
            int rev2 = (i < array2.length ? Integer.parseInt(array2[i]) : 0);
            if (rev1 > rev2) {
                return 1;
            }
            if (rev2 > rev1) {
                return -1;
            }
        }
        return 0;
    }
}
