package leetcode.problem131;

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
    void shouldBeAforA() {
        List<List<String>> result = solution.partition("a");
        List<List<String>> expected = List.of(
                List.of("a")
        );
        Assertions.assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    void shouldBeAandBforAB() {
        List<List<String>> result = solution.partition("ab");
        List<List<String>> expected = List.of(
                List.of("a", "b")
        );
        Assertions.assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    void shouldBeAandAandBandAAandBforAAB() {
        List<List<String>> result = solution.partition("aab");
        List<List<String>> expected = List.of(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        );
        Assertions.assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    void shouldBeAandBandAandABAforABA() {
        List<List<String>> result = solution.partition("aba");
        List<List<String>> expected = List.of(
                List.of("a", "b", "a"),
                List.of("aba")
        );
        Assertions.assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }
}