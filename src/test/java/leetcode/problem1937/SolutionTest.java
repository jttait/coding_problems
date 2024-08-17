package leetcode.problem1937;

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
    void shouldBeCorrectFor1by1matrix() {
        int[][] points = new int[][]{
                {1}
        };
        long result = solution.maxPoints(points);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBeCorrectFor2by1matrix() {
        int[][] points = new int[][]{
                {1,2}
        };
        long result = solution.maxPoints(points);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBeCorrectFor1by2matrix() {
        int[][] points = new int[][]{
                {1},
                {2}
        };
        long result = solution.maxPoints(points);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBeCorrectForFirstLeetcodeExample() {
        int[][] points = new int[][]{
                {1,2,3},
                {1,5,1},
                {3,1,1}
        };
        long result = solution.maxPoints(points);
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldBeCorrectForSecondLeetcodeExample() {
        int[][] points = new int[][]{
                {1,5},
                {2,3},
                {4,2}
        };
        long result = solution.maxPoints(points);
        Assertions.assertEquals(11, result);
    }
}