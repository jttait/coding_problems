package adventofcode.year2024.problem18;

import adventofcode.year2024.common.Cell;
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
    void shouldBe2for2x2gridAndNoFallingBytes() {
        List<Cell> fallingBytes = List.of();
        PartOne partOne = new PartOne(2, 2, fallingBytes);
        partOne.simulate(10);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4for3x3gridAndNoFallingBytes() {
        List<Cell> fallingBytes = List.of();
        PartOne partOne = new PartOne(3, 3, fallingBytes);
        partOne.simulate(10);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe16for5x5gridAndFallingBytes() {
        List<Cell> fallingBytes = List.of(
            new Cell(0, 1),
            new Cell(1, 1),
            new Cell(2, 1),
            new Cell(3, 1),
            new Cell(1, 3),
            new Cell(2, 3),
            new Cell(3, 3),
            new Cell(4, 3)
        );
        PartOne partOne = new PartOne(5, 5, fallingBytes);
        partOne.simulate(10);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(16, result);
    }

    @Test
    void shouldBe22forAdventOfCodeExample() throws Exception {
        List<Cell> fallingBytes = testUtils.loadFile("adventofcode/year2024/problem18_example.txt");
        PartOne partOne = new PartOne(7, 7, fallingBytes);
        partOne.simulate(12);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(22, result);
    }

    @Test
    void shouldBe310forAdventOfCodeInput() throws Exception {
        List<Cell> fallingBytes = testUtils.loadFile("adventofcode/year2024/problem18_input.txt");
        PartOne partOne = new PartOne(71, 71, fallingBytes);
        partOne.simulate(1024);
        int result = partOne.findShortestPath();
        Assertions.assertEquals(310, result);
    }
}