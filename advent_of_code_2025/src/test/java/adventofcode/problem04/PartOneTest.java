package adventofcode.problem04;

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
    void shouldBe1for1by1gridWithRoll() {
        List<List<Character>> grid = List.of(
              List.of('@')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe0for1by1gridWithNoRoll() {
        List<List<Character>> grid = List.of(
                List.of('.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe4for2by2gridWithRolls() {
        List<List<Character>> grid = List.of(
                List.of('@', '@'),
                List.of('@', '@')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe0for2by2gridWithNoRolls() {
        List<List<Character>> grid = List.of(
                List.of('.', '.'),
                List.of('.', '.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe4for2by3gridWithAllRolls() {
        List<List<Character>> grid = List.of(
                List.of('@', '@', '@'),
                List.of('@', '@', '@')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe13forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem04_example.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(13, result);
    }

    @Test
    void shouldBe1363forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem04_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.countAccessibleRolls();
        Assertions.assertEquals(1363, result);
    }
}