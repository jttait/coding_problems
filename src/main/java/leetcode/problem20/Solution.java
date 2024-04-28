package leetcode.problem20;

import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matching = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c != matching.get(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
