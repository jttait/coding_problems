package leetcode.problem2812;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void shouldBe0for1by1gridWithThief() {
        List<List<Integer>> grid = List.of(List.of(1));
        int result = solution.maximumSafenessFactor(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for2by2gridWithThief() {
        List<List<Integer>> grid = List.of(
                List.of(0, 1),
                List.of(0, 0)
        );
        int result = solution.maximumSafenessFactor(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for3by3gridWithThief() {
        List<List<Integer>> grid = List.of(
                List.of(0, 0, 1),
                List.of(0, 0, 0),
                List.of(0, 0, 0)
        );
        int result = solution.maximumSafenessFactor(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forThirdLeetcodeExample() {
        List<List<Integer>> grid = List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0),
                List.of(1, 0, 0, 0)
        );
        int result = solution.maximumSafenessFactor(grid);
        Assertions.assertEquals(2, result);
    }
}