package leetcode.problem2976;

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
    void shouldBeZeroIfSourceAndTargetAreSame() {
        long result = solution.minimumCost("a", "a", new char[]{}, new char[]{}, new int[]{});
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeOneIfOneConversionNeeded() {
        long result = solution.minimumCost("a", "b", new char[]{'a'}, new char[]{'b'}, new int[]{1});
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeNegativeOneForImpossibleExample() {
        long result = solution.minimumCost("a", "b", new char[]{}, new char[]{}, new int[]{});
        Assertions.assertEquals(-1, result);
    }

    @Test
    void shouldFollowChainOfConversions() {
        long result = solution.minimumCost("a", "c", new char[]{'a', 'b'}, new char[]{'b', 'c'}, new int[]{1,1});
        Assertions.assertEquals(2, result);
    }
}