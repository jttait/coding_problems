package adventofcode.year2024.problem6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    private PartTwo partTwo;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe0ifTopRow() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('^')
        );
        int result = partTwo.possibleObstacles(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1ifSurroundedOnNorthEastAndSouth() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#'),
                List.of('.', '^', '#'),
                List.of('#', '#', '#')
        );
        int result = partTwo.possibleObstacles(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe6forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/adventofcode_year2024_problem6_example.txt");
        int result = partTwo.possibleObstacles(grid);
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldBe6forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/adventofcode_year2024_problem6_input.txt");
        int result = partTwo.possibleObstacles(grid);
        Assertions.assertEquals(1939, result);
    }
}