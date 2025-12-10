package adventofcode.year2025.problem06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileLoaderTest {
    private FileLoader fileLoader;

    @BeforeEach
    void setUp() {
        this.fileLoader = new FileLoader();
    }

    @Test
    void shouldParseAdventOfCodeExample() {
        List<String> lines = List.of(
                "123 328  51 64",
                "45  64  387 23",
                "6   98  215 314",
                "*   +   *   +"
        );
        List<Problem> result = this.fileLoader.parseLinesIntoProblems(lines);
        List<Problem> expected = List.of(
            new Problem(List.of(123L, 45L, 6L), Operation.MULTIPLY),
            new Problem(List.of(328L, 64L, 98L), Operation.ADD),
            new Problem(List.of(51L, 387L, 215L), Operation.MULTIPLY),
            new Problem(List.of(64L, 23L, 314L), Operation.ADD)
        );
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldParseAdventOfCodeExampleForPartTwo() {
        List<String> lines = List.of(
                "123 328  51 64 ",
                " 45 64  387 23 ",
                "  6 98  215 314",
                "*   +   *   +  "
        );
        List<Problem> result = this.fileLoader.parseLinesIntoProblemsForPartTwo(lines);
        List<Problem> expected = List.of(
                new Problem(List.of(356L, 24L, 1L), Operation.MULTIPLY),
                new Problem(List.of(8L, 248L, 369L), Operation.ADD),
                new Problem(List.of(175L, 581L, 32L), Operation.MULTIPLY),
                new Problem(List.of(623L, 431L, 4L), Operation.ADD)
        );
        Assertions.assertEquals(expected, result);
    }
}