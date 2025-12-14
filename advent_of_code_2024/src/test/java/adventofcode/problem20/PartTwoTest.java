package adventofcode.problem20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe1forSimpleExample() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '#', 'E', '#'),
                List.of('#', '.', '.', '.', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findSavings(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3forSlightlyMoreComplicatedExample() throws Exception {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '#', 'E', '#'),
                List.of('#', '.', '#', '.', '#'),
                List.of('#', '.', '.', '.', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findSavings(1);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe84forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("problem20_example.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findSavings(50);
        Assertions.assertEquals(285, result);
    }

    @Test
    void shouldBe1008040forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("problem20_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findSavings(100);
        Assertions.assertEquals(1008040, result);
    }

}