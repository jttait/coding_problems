package leetcode.problem58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int indexOfLastSpace = s.lastIndexOf(' ');
        return s.length() - indexOfLastSpace - 1;
    }
}
