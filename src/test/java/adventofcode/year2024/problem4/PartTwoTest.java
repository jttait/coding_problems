package adventofcode.year2024.problem4;

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
    void shouldBe1forSingleXMAS() {
        List<List<Character>> grid = List.of(
                List.of('M', '.', 'S'),
                List.of('.', 'A', '.'),
                List.of('M', '.', 'S')
        );
        int result = partTwo.findXmas(grid);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forTwoXMAS() {
        List<List<Character>> grid = List.of(
                List.of('M', 'M', 'S', 'S'),
                List.of('.', 'A', 'A', '.'),
                List.of('M', 'M', 'S', 'S')
        );
        int result = partTwo.findXmas(grid);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBeXforAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode_year2024_problem4.txt");
        int result = partTwo.findXmas(grid);
        Assertions.assertEquals(1910, result);
    }
}