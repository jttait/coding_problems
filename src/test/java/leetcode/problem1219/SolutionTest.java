package leetcode.problem1219;

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
    void shouldBe0for1by1gridWith0() {
        int[][] grid = new int[][]{{0}};
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for1by1gridWith1() {
        int[][] grid = new int[][]{{1}};
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for2by1gridWith1s() {
        int[][] grid = new int[][]{{1,1}};
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1for3by1gridWith1and0and1() {
        int[][] grid = new int[][]{{1,0,1}};
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe5for3by2gridWith101and111() {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {1, 1, 1}
        };
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldBe6for3by3gridWith111and000and222() {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {0, 0, 0},
                {2, 2, 2}
        };
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldBe27for3by3gridWith010and199and090() {
        int[][] grid = new int[][]{
                {0, 1, 0},
                {1, 9, 9},
                {0, 9, 0}
        };
        int result = solution.getMaximumGold(grid);
        Assertions.assertEquals(27, result);
    }
}