package adventofcode.year2024.problem18;

import adventofcode.year2024.common.Cell;
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
    void shouldBeThirdFallingByteFor3x3grid() {
        List<Cell> fallingBytes = List.of(
                new Cell(0, 1),
                new Cell(1, 1),
                new Cell(2, 1)
        );
        PartTwo partTwo = new PartTwo(3, 3, fallingBytes);
        Cell result = partTwo.findFirstBlockingCell();
        Cell expected = new Cell(2, 1);
        Assertions.assertEquals(expected.x(), result.x());
        Assertions.assertEquals(expected.y(), result.y());
    }

    @Test
    void shouldBe6and1forAdventOfCodeExample() throws Exception {
        List<Cell> fallingBytes = testUtils.loadFile("adventofcode/year2024/problem18_example.txt");
        PartTwo partTwo = new PartTwo(7, 7, fallingBytes);
        Cell result = partTwo.findFirstBlockingCell();
        Cell expected = new Cell(1, 6);
        Assertions.assertEquals(expected.x(), result.x());
        Assertions.assertEquals(expected.y(), result.y());
    }

    @Test
    void shouldBe6and1forAdventOfCodeInput() throws Exception {
        List<Cell> fallingBytes = testUtils.loadFile("adventofcode/year2024/problem18_input.txt");
        PartTwo partTwo = new PartTwo(71, 71, fallingBytes);
        Cell result = partTwo.findFirstBlockingCell();
        Cell expected = new Cell(46, 16);
        Assertions.assertEquals(expected.x(), result.x());
        Assertions.assertEquals(expected.y(), result.y());
    }
}