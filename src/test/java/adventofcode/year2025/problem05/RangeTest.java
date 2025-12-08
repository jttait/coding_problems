package adventofcode.year2025.problem05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RangeTest {
    @Test
    void shouldContain() {
        Range range = new Range(0, 10);
        boolean result = range.contains(5);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldNotContain() {
        Range range = new Range(0, 10);
        boolean result = range.contains(15);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeOverlapping() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeOverlappingWhenRangesReversed() {
        Range range1 = new Range(5, 15);
        Range range2 = new Range(0, 10);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeNonOverlapping() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(20, 30);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeNonOverlappingWhenRangesReversed() {
        Range range1 = new Range(20, 30);
        Range range2 = new Range(0, 10);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeOverlappingIfJustTouching() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(10, 20);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1, 0, 1, true",
        "0, 1, 0, 2, true",
        "0, 1, 0, 3, true",
        "0, 1, 1, 2, true",
        "0, 1, 1, 3, true",
        "0, 1, 2, 3, false",
        "0, 2, 0, 1, true",
        "0, 2, 0, 2, true",
        "0, 2, 0, 3, true",
        "0, 2, 1, 2, true",
        "0, 2, 1, 3, true",
        "0, 2, 2, 3, true",
        "0, 3, 0, 1, true",
        "0, 3, 0, 2, true",
        "0, 3, 0, 3, true",
        "0, 3, 1, 2, true",
        "0, 3, 1, 3, true",
        "0, 3, 2, 3, true",
        "1, 2, 0, 1, true",
        "1, 2, 0, 2, true",
        "1, 2, 0, 3, true",
        "1, 2, 1, 2, true",
        "1, 2, 1, 3, true",
        "1, 2, 2, 3, true",
        "1, 3, 0, 1, true",
        "1, 3, 0, 2, true",
        "1, 3, 0, 3, true",
        "1, 3, 1, 2, true",
        "1, 3, 1, 3, true",
        "1, 3, 2, 3, true",
        "2, 3, 0, 1, false",
        "2, 3, 0, 2, true",
        "2, 3, 0, 3, true",
        "2, 3, 1, 2, true",
        "2, 3, 1, 3, true",
        "2, 3, 2, 3, true"
    })
    void shouldBeCorrectForParameterizedTests(int s1, int e1, int s2, int e2, boolean expected) {
        Range range1 = new Range(s1, e1);
        Range range2 = new Range(s2, e2);
        boolean result = range1.isOverlapping(range2);
        Assertions.assertEquals(expected, result);
    }
}