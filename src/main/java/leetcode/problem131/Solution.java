package leetcode.problem131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<List<String>> result;

    public Solution() {
        this.result = new ArrayList<>();
    }

    public List<List<String>> partition(String s) {
        List<String> substrings = new ArrayList<>();
        substrings.add(String.valueOf(s.charAt(0)));
        recursion(s, 1, substrings);
        return this.result;
    }

    private void recursion(String s, int index, List<String> substrings) {
        if (index >= s.length()) {
            if (substrings.stream().allMatch(this::isPalindromic)) {
                result.add(new ArrayList<>(substrings));
            }
            return;
        }

        substrings.set(substrings.size()-1, substrings.get(substrings.size()-1) + s.charAt(index));
        recursion(s, index + 1, substrings);
        substrings.set(substrings.size()-1, substrings.get(substrings.size()-1).substring(0, substrings.get(substrings.size()-1).length()-1));

        substrings.add(String.valueOf(s.charAt(index)));
        recursion(s, index+1, substrings);
        substrings.remove(substrings.size()-1);
    }

    private boolean isPalindromic(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
