package leetcode.problem268;

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
    void shouldBe2for3and0and1() {
        int[] nums = new int[]{3, 0, 1};
        int result = solution.missingNumber(nums);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe0for3and2and1() {
        int[] nums = new int[]{3, 2, 1};
        int result = solution.missingNumber(nums);
        Assertions.assertEquals(0, result);
    }
}