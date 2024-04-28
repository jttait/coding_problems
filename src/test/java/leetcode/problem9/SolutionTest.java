package leetcode.problem9;

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
    void shouldBeTrueFor121() {
        Assertions.assertTrue(solution.isPalindrome(121));
    }

    @Test
    void shouldBeFalseFor123() {
        Assertions.assertFalse(solution.isPalindrome(123));
    }
}