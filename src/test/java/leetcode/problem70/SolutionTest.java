package leetcode.problem70;

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
    void shouldBe1for1Step() {
        int result = solution.climbStairs(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for2Steps() {
        int result = solution.climbStairs(2);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3for3Steps() {
        int result = solution.climbStairs(3);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe5for4Steps() {
        int result = solution.climbStairs(3);
        Assertions.assertEquals(3, result);
    }
}