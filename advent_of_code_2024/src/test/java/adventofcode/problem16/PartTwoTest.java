package adventofcode.problem16;

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
    void shouldBe2forAdjacentStartAndEnd() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#'),
                List.of('#', 'S', 'E', '#'),
                List.of('#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forAdjacentStartAndEndAndAnticlockwiseRotation() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#'),
                List.of('#', 'E', '#'),
                List.of('#', 'S', '#'),
                List.of('#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forTwoCellsBetweenStartAndEnd() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '.', 'E', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe7forTurningTwoCorners() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#'),
                List.of('#', 'S', '.', '.', '#'),
                List.of('#', '#', '#', '.', '#'),
                List.of('#', 'E', '.', '.', '#'),
                List.of('#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(7, result);
    }

    @Test
    void shouldBe45forFirstAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("problem16_example1.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(45, result);
    }

    @Test
    void shouldBe64forSecondAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("problem16_example2.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(64, result);
    }

    @Test
    void shouldBe670forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("problem16_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.findBestSeats();
        Assertions.assertEquals(670, result);
    }
}