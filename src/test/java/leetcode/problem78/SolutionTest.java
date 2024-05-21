package leetcode.problem78;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void shouldBeEmptyAnd0for0() {
        int[] nums = new int[]{0};
        List<List<Integer>> result = solution.subsets(nums);
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(0)
        );
        Assertions.assertTrue(expected.containsAll(result));
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    void shouldBeEmptyAnd0and1and010for01() {
        int[] nums = new int[]{0,1};
        List<List<Integer>> result = solution.subsets(nums);
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(0),
                List.of(1),
                List.of(0, 1)
        );
        Assertions.assertTrue(expected.containsAll(result));
        Assertions.assertEquals(expected.size(), result.size());
    }
}