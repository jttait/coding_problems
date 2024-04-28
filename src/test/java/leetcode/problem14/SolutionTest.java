package leetcode.problem14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void shouldBeAforAandAb() {
        String[] strs = new String[]{"a", "ab"};
        String result = solution.longestCommonPrefix(strs);
        Assertions.assertEquals("a", result);
    }

    @Test
    void shouldBeAforAbAndA() {
        String[] strs = new String[]{"ab", "a"};
        String result = solution.longestCommonPrefix(strs);
        Assertions.assertEquals("a", result);
    }

    @Test
    void shouldBeEmptyForAandB() {
        String[] strs = new String[]{"a", "b"};
        String result = solution.longestCommonPrefix(strs);
        Assertions.assertEquals("", result);
    }

    @Test
    void shouldBeBasForBaseAndBasic() {
        String[] strs = new String[]{"base", "basic"};
        String result = solution.longestCommonPrefix(strs);
        Assertions.assertEquals("bas", result);
    }

    @Test
    void shouldBeEmptyForAbcAndEmpty() {
        String[] strs = new String[]{"abc", ""};
        String result = solution.longestCommonPrefix(strs);
        Assertions.assertEquals("", result);
    }

}