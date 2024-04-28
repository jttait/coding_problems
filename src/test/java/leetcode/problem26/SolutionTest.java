package leetcode.problem26;

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
    void shouldBe1forListWithOneNumber() {
        int[] nums = new int[]{1};
        int result = solution.removeDuplicates(nums);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forListWithTwoDifferentNumbers() {
        int[] nums = new int[]{1,2};
        int result = solution.removeDuplicates(nums);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1forListWithTwoOfTheSameNumber() {
        int[] nums = new int[]{1,1};
        int result = solution.removeDuplicates(nums);
        Assertions.assertEquals(1, result);
    }
}