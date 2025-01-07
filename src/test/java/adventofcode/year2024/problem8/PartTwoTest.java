package adventofcode.year2024.problem8;

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
    void shouldBe3ForTwoAntennas() {
        List<List<Character>> grid = List.of(
                List.of('a', 'a', '.', '.', '.')
        );
        int result = partTwo.countAntinodes(grid);
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldBe9ForTwoAdventOfCodeExample1() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode_year2024_problem8_part2_example1.txt");
        int result = partTwo.countAntinodes(grid);
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldBe9ForTwoAdventOfCodeExample2() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode_year2024_problem8_part2_example2.txt");
        int result = partTwo.countAntinodes(grid);
        Assertions.assertEquals(34, result);
    }

    @Test
    void shouldBe9ForTwoAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFile("adventofcode_year2024_problem8_input.txt");
        int result = partTwo.countAntinodes(grid);
        Assertions.assertEquals(1017, result);
    }
}