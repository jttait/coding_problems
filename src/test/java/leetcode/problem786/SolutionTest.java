package leetcode.problem786;

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
    void shouldBe1and3for1and3() {
        int[] arr = new int[]{1, 3};
        int[] result = solution.kthSmallestPrimeFraction(arr, 1);
        int[] expected = new int[]{1, 3};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBe1and5for1and3and5() {
        int[] arr = new int[]{1, 3, 5};
        int[] result = solution.kthSmallestPrimeFraction(arr, 1);
        int[] expected = new int[]{1, 5};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBe1and5for1and5and3() {
        int[] arr = new int[]{1, 5, 3};
        int[] result = solution.kthSmallestPrimeFraction(arr, 1);
        int[] expected = new int[]{1, 5};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBe1and3for1and5and3andKof2() {
        int[] arr = new int[]{1, 5, 3};
        int[] result = solution.kthSmallestPrimeFraction(arr, 2);
        int[] expected = new int[]{1, 3};
        Assertions.assertArrayEquals(expected, result);
    }
}