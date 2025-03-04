package adventofcode.year2024.problem16;

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
    void shouldBe1forAdjacentStartAndEnd() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#'),
                List.of('#', 'S', 'E', '#'),
                List.of('#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1001forAdjacentStartAndEndAndAnticlockwiseRotation() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#'),
                List.of('#', 'E', '#'),
                List.of('#', 'S', '#'),
                List.of('#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(1001, result);
    }

    @Test
    void shouldBe2forTwoCellsBetweenStartAndEnd() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '.', 'E', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2006forTurningTwoCorners() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '.', '.', '#'),
                List.of('#', '#', '#', '.', '#'),
                List.of('#', 'E', '.', '.', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(2006, result);
    }

    @Test
    void shouldBe7036forFirstAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem16_example1.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(7036, result);
    }

    @Test
    void shouldBe11048forSecondAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem16_example2.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(11048, result);
    }

    @Test
    void shouldBe147628forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem16_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.findLowestScore();
        Assertions.assertEquals(147628, result);
    }
}