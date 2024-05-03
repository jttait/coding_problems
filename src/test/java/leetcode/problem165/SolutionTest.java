package leetcode.problem165;

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
    void shouldBeOneFor1p1and1p0() {
        int result = solution.compareVersion("1.1", "1.0");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeMinusOneFor1p0and1p1() {
        int result = solution.compareVersion("1.0", "1.1");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldBeOneFor1and0() {
        int result = solution.compareVersion("1", "0");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeMinusOneFor0and1() {
        int result = solution.compareVersion("0", "1");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldIgnoreLeadingZeroes() {
        int result = solution.compareVersion("1.1", "1.00001");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldHandleTwoDotsCorrectly() {
        int result = solution.compareVersion("1.0.1", "1.0.0");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldHandleThreeDotsCorrectly() {
        int result = solution.compareVersion("1.0.0.1", "1.0.0.0");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldHandleMoreDotsInVersion2() {
        int result = solution.compareVersion("1.0", "1.0.0.0");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldHandleMoreDotsInVersion1() {
        int result = solution.compareVersion("1.0.0.1", "1.0");
        Assertions.assertEquals(1, result);
    }
}