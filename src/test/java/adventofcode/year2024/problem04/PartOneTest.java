package adventofcode.year2024.problem04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe0forXXXX() {
        List<List<Character>> grid = List.of(
                List.of('X', 'X', 'X', 'X')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1forHorizontalForwards() {
        List<List<Character>> grid = List.of(
                List.of('X', 'M', 'A', 'S')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forHorizontalBackwards() {
        List<List<Character>> grid = List.of(
                List.of('S', 'A', 'M', 'X')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forVerticalDownwards() {
        List<List<Character>> grid = List.of(
                List.of('X'),
                List.of('M'),
                List.of('A'),
                List.of('S')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forVerticalUpwards() {
        List<List<Character>> grid = List.of(
                List.of('S'),
                List.of('A'),
                List.of('M'),
                List.of('X')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forDiagonalUpwardsRight() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', '.', 'S'),
                List.of('.', '.', 'A', '.'),
                List.of('.', 'M', '.', '.'),
                List.of('X', '.', '.', '.')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forDiagonalDownwardsLeft() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', '.', 'X'),
                List.of('.', '.', 'M', '.'),
                List.of('.', 'A', '.', '.'),
                List.of('S', '.', '.', '.')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forDiagonalDownwardsRight() {
        List<List<Character>> grid = List.of(
                List.of('X', '.', '.', '.'),
                List.of('.', 'M', '.', '.'),
                List.of('.', '.', 'A', '.'),
                List.of('.', '.', '.', 'S')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forDiagonalUpwards() {
        List<List<Character>> grid = List.of(
                List.of('S', '.', '.', '.'),
                List.of('.', 'A', '.', '.'),
                List.of('.', '.', 'M', '.'),
                List.of('.', '.', '.', 'X')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forHorizontalForwardsAndHorizontalForwards() {
        List<List<Character>> grid = List.of(
                List.of('X', 'M', 'A', 'S', 'X', 'M', 'A', 'S')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forHorizontalForwardsAndVerticalDownwardsAndDiagonalDownwardsRight() {
        List<List<Character>> grid = List.of(
                List.of('X', 'M', 'A', 'S'),
                List.of('M', 'M', '.', '.'),
                List.of('A', '.', 'A', '.'),
                List.of('S', '.', '.', 'S')
        );
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBeXforAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem4.txt");
        int result = partOne.findXmas(grid);
        Assertions.assertEquals(2560, result);
    }
}