package leetcode.problem1;

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
    void shouldBe0and1forArrayLength2() {
        int[] nums = new int[]{1,1};
        int target = 2;
        int[] result = solution.twoSum(nums, target);
        int[] expected = new int[]{0,1};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBe0and2forArrayLength3() {
        int[] nums = new int[]{1,2,1};
        int target = 2;
        int[] result = solution.twoSum(nums, target);
        int[] expected = new int[]{0,2};
        Assertions.assertArrayEquals(expected, result);
    }
}