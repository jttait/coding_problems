package adventofcode.year2024.problem08;

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
    void shouldBe0forSingleAntenna() {
        List<List<Character>> grid = List.of(
                List.of('a')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe4forTwoAntennas() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', 'a', '.', 'a', '.', '.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldNotIncludeAntinodesThatAreOutOfBounds() {
        List<List<Character>> grid = List.of(
                List.of('.', 'a', '.', 'a', '.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe0forTwoDifferentAntennas() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', 'a', '.', 'b', '.', '.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe0forTwoPairsOfAntennas() {
        List<List<Character>> grid = List.of(
                List.of('.','.', 'b', 'a', 'b', 'a', '.', '.','.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldWorkForVerticalAntennas() {
        List<List<Character>> grid = List.of(
                List.of('.'),
                List.of('.'),
                List.of('a'),
                List.of('.'),
                List.of('a'),
                List.of('.'),
                List.of('.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldWorkForDiagonalAntennas() {
        List<List<Character>> grid = List.of(
                List.of('.','.','.','.','.','.','.'),
                List.of('.','.','.','.','.','.','.'),
                List.of('.','.','a','.','.','.','.'),
                List.of('.','.','.','.','.','.','.'),
                List.of('.','.','.','.','a','.','.'),
                List.of('.','.','.','.','.','.','.'),
                List.of('.','.','.','.','.','.','.')
        );
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forAdventOfCodeExample1() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem8_part1_example1.txt");
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forAdventOfCodeExample2() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem8_part1_example2.txt");
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe3forAdventOfCodeExample3() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem8_part1_example3.txt");
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe3forAdventOfCodeExample4() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem8_part1_example4.txt");
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldBe273forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem8_input.txt");
        int result = partOne.countAntiNodes(grid);
        Assertions.assertEquals(273, result);
    }
}