package leetcode.problem1653;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void shouldBeZeroForA() {
        int result = solution.minimumDeletions("a");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeZeroForB() {
        int result = solution.minimumDeletions("b");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeZeroForAB() {
        int result = solution.minimumDeletions("ab");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeOneForBA() {
        int result = solution.minimumDeletions("ba");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeOneForBBA() {
        int result = solution.minimumDeletions("bba");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeOneForBAB() {
        int result = solution.minimumDeletions("bab");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeTwoForFirstLeetcodeExample() {
        int result = solution.minimumDeletions("aababbab");
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBeTwoForSecondLeetcodeExample() {
        int result = solution.minimumDeletions("bbaaaaabb");
        Assertions.assertEquals(2, result);
    }
}