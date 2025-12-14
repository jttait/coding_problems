package adventofcode.problem20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe1forAdjacentCells() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#'),
                List.of('#', 'S', 'E', '#'),
                List.of('#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forCellsSeparatedByOne() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '.', 'E', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe84forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem20_example.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(84, result);
    }

    @Test
    void shouldBe0cheatsForAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem20_example.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findNumberOfCheatsThatSave100picoseconds();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1445cheatsForAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem20_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findNumberOfCheatsThatSave100picoseconds();
        Assertions.assertEquals(1445, result);
    }
}