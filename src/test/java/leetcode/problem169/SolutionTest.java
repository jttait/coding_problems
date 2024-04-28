package leetcode.problem169;

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
    void shouldBe1for1and1and2() {
        int[] nums = new int[]{1,1,2};
        int result = solution.majorityElement(nums);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for2and1and1and2and2() {
        int[] nums = new int[]{2,1,1,2,2};
        int result = solution.majorityElement(nums);
        Assertions.assertEquals(2, result);
    }
}