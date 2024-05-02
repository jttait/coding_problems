package leetcode.problem2441;

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
    void shouldBe1for1andMinus1() {
        int[] nums = new int[]{-1, 1};
        int result = solution.findMaxK(nums);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeNegativeOneForMinus1andTwo() {
        int[] nums = new int[]{-1, 2};
        int result = solution.findMaxK(nums);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldBeNegativeOneForSingleNegativeNumber() {
        int[] nums = new int[]{-1};
        int result = solution.findMaxK(nums);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldBeNegativeOneForSinglePositiveNumber() {
        int[] nums = new int[]{1};
        int result = solution.findMaxK(nums);
        Assertions.assertEquals(-1, result);
    }
}