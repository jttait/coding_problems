package adventofcode.problem15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PartTwoTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe101forSingleBox() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#', '#', '#', '#'),
                List.of('#', '#', '[', ']', '#', '#'),
                List.of('#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of();
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102, result);
    }

    @Test
    void shouldPushBoxLeft() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '@', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.LEFT);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102, result);
    }

    @Test
    void shouldPushTwoBoxesLeft() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '[', ']', '@', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.LEFT);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102 + 104, result);
    }

    @Test
    void shouldPushTwoBoxesRight() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '@', '[', ']', '[', ']', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.RIGHT);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(104 + 106, result);
    }

    @Test
    void shouldPushTwoBoxesUp() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '@', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.UP);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102 + 202, result);
    }

    @Test
    void shouldPushMultipleAdjacentBoxesUp() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '@', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.UP);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102 + 203 + 104, result);
    }

    @Test
    void shouldPushMultipleAdjacentBoxesUpFromRightHandSide() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '@', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.UP);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102 + 203 + 104, result);
    }

    @Test
    void shouldNotPushMultipleAdjacentBoxesUpIfOneBlocked() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '#', '.', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '@', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.UP);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(202 + 303 + 204, result);
    }

    @Test
    void shouldPushMultipleAdjacentBoxesDown() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '@', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '[', ']', '.', '#', '#'),
                Arrays.asList('#', '#', '[', ']', '[', ']', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(Command.DOWN);
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(402 + 303 + 404, result);
    }

    @Test
    void shouldBeXforAdventOfCodeExample() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '[', ']', '[', ']', '@', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '[', ']', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = List.of(
                Command.LEFT,
                Command.DOWN,
                Command.DOWN,
                Command.LEFT,
                Command.LEFT,
                Command.UP,
                Command.UP,
                Command.LEFT,
                Command.LEFT,
                Command.UP,
                Command.UP
        );
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(105 + 207 + 306, result);
    }

    @Test
    void shouldBe9021forLargerAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFileForPartTwo("adventofcode/year2024/problem15_example.txt");
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = testUtils.loadCommandsFromFile("adventofcode/year2024/problem15_example.txt");
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(9021, result);
    }

    @Test
    void shouldBe1495455forLargerAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFileForPartTwo("adventofcode/year2024/problem15_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        List<Command> commands = testUtils.loadCommandsFromFile("adventofcode/year2024/problem15_input.txt");
        partTwo.simulate(commands);
        int result = partTwo.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(1495455, result);
    }
}