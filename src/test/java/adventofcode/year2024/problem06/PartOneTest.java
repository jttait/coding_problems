package adventofcode.year2024.problem06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldThrowIfNoStartPosition() {
        List<List<Character>> grid = List.of(
                List.of('.')
        );
        Exception exception = assertThrows(Exception.class, () -> {
            partOne.distinctPositions(grid);
        });
        Assertions.assertEquals("Starting position not found", exception.getMessage());
    }

    @Test
    void shouldBe1ifTopRow() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('^')
        );
        int result = partOne.distinctPositions(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifSecondRowAndClear() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('.'),
                List.of('^')
        );
        int result = partOne.distinctPositions(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1ifRightmostColumnAndObstacleAbove() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('#'),
                List.of('^')
        );
        int result = partOne.distinctPositions(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1ifLeftmostColumnAndObstaclesAboveRightAndBelow() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('#', '#'),
                List.of('^', '#'),
                List.of('#', '#')
        );
        int result = partOne.distinctPositions(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe5561forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem6_input.txt");
        int result = partOne.distinctPositions(grid);
        Assertions.assertEquals(5551, result);
    }
}