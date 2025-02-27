package adventofcode.year2024.problem12;

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
    void shouldBe4for1x1() {
        List<List<Character>> grid = List.of(
                List.of('A')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe12for1x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldBe32for2x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A'),
                List.of('A', 'A')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(32, result);
    }

    @Test
    void shouldBe24for1x2and1x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A'),
                List.of('B', 'B')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(24, result);
    }

    @Test
    void shouldBe1930forAdventOfCodeExample() {
        List<List<Character>> grid = List.of(
                List.of('R', 'R', 'R', 'R', 'I', 'I', 'C', 'C', 'F', 'F'),
                List.of('R', 'R', 'R', 'R', 'I', 'I', 'C', 'C', 'C', 'F'),
                List.of('V', 'V', 'R', 'R', 'R', 'C', 'C', 'F', 'F', 'F'),
                List.of('V', 'V', 'R', 'C', 'C', 'C', 'J', 'F', 'F', 'F'),
                List.of('V', 'V', 'V', 'V', 'C', 'J', 'J', 'C', 'F', 'E'),
                List.of('V', 'V', 'I', 'V', 'C', 'C', 'J', 'J', 'E', 'E'),
                List.of('V', 'V', 'I', 'I', 'I', 'C', 'J', 'J' ,'E', 'E'),
                List.of('M', 'I', 'I', 'I', 'I', 'I', 'J', 'J', 'E', 'E'),
                List.of('M', 'I', 'I', 'I', 'S', 'I', 'J', 'E', 'E', 'E'),
                List.of('M', 'M', 'M', 'I', 'S', 'S', 'J', 'E', 'E', 'E')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(1930, result);
    }

    @Test
    void shouldBe1473276forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem12_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.calculateFencingCost();
        Assertions.assertEquals(1473276, result);
    }
}