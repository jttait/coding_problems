package adventofcode2025.problem04;

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
    void shouldBe1for1by1gridWithRoll() {
        List<List<Character>> grid = List.of(
                List.of('@')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1for1by1gridWithNoRoll() {
        List<List<Character>> grid = List.of(
                List.of('.')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe4for2by2gridWithRolls() {
        List<List<Character>> grid = List.of(
                List.of('@', '@'),
                List.of('@', '@')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe0for2by2gridWithNoRolls() {
        List<List<Character>> grid = List.of(
                List.of('.', '.'),
                List.of('.', '.')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe6for2by3gridWithAllRolls() {
        List<List<Character>> grid = List.of(
                List.of('@', '@', '@'),
                List.of('@', '@', '@')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldBe43forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem04_example.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(43, result);
    }

    @Test
    void shouldBe8184forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem04_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.countRemovableRolls();
        Assertions.assertEquals(8184, result);
    }
}