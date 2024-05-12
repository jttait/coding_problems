package leetcode.problem2373;

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
    void shouldWorkForMatrixOfAllOnes() {
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int[][] result = solution.largestLocal(grid);
        int[][] expected = {
                {1,1},
                {1,1}
        };
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBeAllTwosWhenMiddleElementIsTwo() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        int[][] result = solution.largestLocal(grid);
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        Assertions.assertArrayEquals(expected, result);
    }

}