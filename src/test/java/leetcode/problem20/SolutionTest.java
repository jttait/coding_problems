package leetcode.problem20;

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
    void shouldBeTrueForOpenCloseRound() {
        boolean result = solution.isValid("()");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeTrueForOpenRound() {
        boolean result = solution.isValid("(");
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeTrueForOpenOpenCloseCloseRound() {
        boolean result = solution.isValid("(())");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeTrueForOpenCloseSquare() {
        boolean result = solution.isValid("[]");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeTrueForOpenSquare() {
        boolean result = solution.isValid("[");
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeTrueForOpenOpenCloseCloseSquare() {
        boolean result = solution.isValid("[[]]");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeTrueForOpenCloseCurly() {
        boolean result = solution.isValid("{}");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeTrueForOpenCurly() {
        boolean result = solution.isValid("{");
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeTrueForOpenOpenCloseCloseCurly() {
        boolean result = solution.isValid("{{}}");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeFalseForOpenRoundCloseSquare() {
        boolean result = solution.isValid("(]");
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeTrueForOpenRoundOpenSquareCloseSquareCloseRound() {
        boolean result = solution.isValid("([])");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeFalseForOpenRoundOpenSquareCloseRoundCloseSquare() {
        boolean result = solution.isValid("([)]");
        Assertions.assertFalse(result);
    }
}