package leetcode.problem2000;

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
    void shouldBeCbadefForAbcdefAndC() {
        String result = solution.reversePrefix("abcdef", 'c');
        String expected = "cbadef";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeAbcdefForAbcdefAndA() {
        String result = solution.reversePrefix("abcdef", 'a');
        String expected = "abcdef";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeFedcbaForAbcdefAndF() {
        String result = solution.reversePrefix("abcdef", 'f');
        String expected = "fedcba";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeAaaForAaaaaaAndA() {
        String result = solution.reversePrefix("aaaaaa", 'a');
        String expected = "aaaaaa";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeAaaForAaaaaaAndB() {
        String result = solution.reversePrefix("aaaaaa", 'b');
        String expected = "aaaaaa";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeCbadcfForAbcdefAndC() {
        String result = solution.reversePrefix("abcdcf", 'c');
        String expected = "cbadcf";
        Assertions.assertEquals(expected, result);
    }
}