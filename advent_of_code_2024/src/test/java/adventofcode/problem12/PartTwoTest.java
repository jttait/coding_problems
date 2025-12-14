package adventofcode.problem12;

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
    void shouldBe4for1x1() {
        List<List<Character>> grid = List.of(
                List.of('A')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe8for1x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldBe16for2x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A'),
                List.of('A', 'A')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(16, result);
    }

    @Test
    void shouldBe16for1x2and1x2() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A'),
                List.of('B', 'B')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(16, result);
    }

    @Test
    void shouldBe80forAdventOfCodeExample() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A', 'A', 'A'),
                List.of('B', 'B', 'C', 'D'),
                List.of('B', 'B', 'C', 'C'),
                List.of('E', 'E', 'E', 'C')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(80, result);
    }

    @Test
    void shouldBe236forAnotherAdventOfCodeExample() {
        List<List<Character>> grid = List.of(
                List.of('E', 'E', 'E', 'E', 'E'),
                List.of('E', 'X', 'X', 'X', 'X'),
                List.of('E', 'E', 'E', 'E', 'E'),
                List.of('E', 'X', 'X', 'X', 'X'),
                List.of('E', 'E', 'E', 'E', 'E')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(236, result);
    }

    @Test
    void shouldBe368forYetAnotherAdventOfCodeExample() {
        List<List<Character>> grid = List.of(
                List.of('A', 'A', 'A', 'A', 'A', 'A'),
                List.of('A', 'A', 'A', 'B', 'B', 'A'),
                List.of('A', 'A', 'A', 'B', 'B', 'A'),
                List.of('A', 'B', 'B', 'A', 'A', 'A'),
                List.of('A', 'B', 'B', 'A', 'A', 'A'),
                List.of('A', 'A', 'A', 'A', 'A', 'A')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(368, result);
    }

    @Test
    void shouldBe1206forLargerAdventOfCodeExample() {
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
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(1206, result);
    }

    @Test
    void shouldBe901100forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode/year2024/problem12_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.calculateFencingCost();
        Assertions.assertEquals(901100, result);
    }
}