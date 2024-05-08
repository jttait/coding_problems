package leetcode.problem506;

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
    void shouldBeGoldMedalForLength1() {
        int[] score = new int[]{1};
        String[] result = solution.findRelativeRanks(score);
        String[] expected = new String[]{"Gold Medal"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBeGoldMedalAndSilverMedalForLength2() {
        int[] score = new int[]{1,2};
        String[] result = solution.findRelativeRanks(score);
        String[] expected = new String[]{"Silver Medal", "Gold Medal"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBeGoldMedalAndSilverMedalAndSilverMedalForLength3() {
        int[] score = new int[]{3,1,2};
        String[] result = solution.findRelativeRanks(score);
        String[] expected = new String[]{"Gold Medal", "Bronze Medal", "Silver Medal"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void shouldBeGoldMedalAndSilverMedalAndSilverMedalAnd4ForLength4() {
        int[] score = new int[]{3,1,2,5};
        String[] result = solution.findRelativeRanks(score);
        String[] expected = new String[]{"Silver Medal", "4", "Bronze Medal", "Gold Medal"};
        Assertions.assertArrayEquals(expected, result);
    }
}