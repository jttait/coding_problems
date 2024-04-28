package leetcode.problem14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Map<Integer, Set<Character>> charactersAtIndex = new HashMap<>();
        int minLength = strs[0].length();
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
            for (int i = 0; i < s.length(); i++) {
                if (!charactersAtIndex.containsKey(i)) {
                    charactersAtIndex.put(i, new HashSet<>());
                }
                charactersAtIndex.get(i).add(s.charAt(i));
            }
        }
        for (int i = 0; i < minLength; i++) {
            if (charactersAtIndex.get(i).size() > 1) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, minLength);
    }
}
