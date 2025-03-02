package adventofcode.year2024.problem15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PartOneTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe101forSingleBox() {
        List<List<Character>> grid = List.of(
                List.of('#', '#', '#'),
                List.of('#', 'O', '#'),
                List.of('#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of();
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(101, result);
    }

    @Test
    void shouldPushBoxLeft() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#'),
                Arrays.asList('#', '.', 'O', '@', '#'),
                Arrays.asList('#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(Command.LEFT);
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(101, result);
    }

    @Test
    void shouldPushTwoBoxesLeft() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '.', 'O', 'O', '@', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(Command.LEFT);
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(101 + 102, result);
    }

    @Test
    void shouldPushTwoBoxesRight() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '@', 'O', 'O', '.', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(Command.LEFT);
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(102 + 103, result);
    }

    @Test
    void shouldPushTwoBoxesUp() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#'),
                Arrays.asList('#', '.', '#'),
                Arrays.asList('#', 'O', '#'),
                Arrays.asList('#', 'O', '#'),
                Arrays.asList('#', '@', '#'),
                Arrays.asList('#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(Command.UP);
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(101 + 201, result);
    }

    @Test
    void shouldPushTwoBoxesDown() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#'),
                Arrays.asList('#', '@', '#'),
                Arrays.asList('#', 'O', '#'),
                Arrays.asList('#', 'O', '#'),
                Arrays.asList('#', '.', '#'),
                Arrays.asList('#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(Command.DOWN);
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(301 + 401, result);
    }

    @Test
    void shouldBe2028forSmallerAdventOfCodeExample() {
        List<List<Character>> grid = Arrays.asList(
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#'),
                Arrays.asList('#', '.', '.', 'O', '.', 'O', '.', '#'),
                Arrays.asList('#', '#', '@', '.', 'O', '.', '.', '#'),
                Arrays.asList('#', '.', '.', '.', 'O', '.', '.', '#'),
                Arrays.asList('#', '.', '#', '.', 'O', '.', '.', '#'),
                Arrays.asList('#', '.', '.', '.', 'O', '.', '.', '#'),
                Arrays.asList('#', '.', '.', '.', '.', '.', '.', '#'),
                Arrays.asList('#', '#', '#', '#', '#', '#', '#', '#')
        );
        PartOne partOne = new PartOne(grid);
        List<Command> commands = List.of(
                Command.LEFT,
                Command.UP,
                Command.UP,
                Command.RIGHT,
                Command.RIGHT,
                Command.RIGHT,
                Command.DOWN,
                Command.DOWN,
                Command.LEFT,
                Command.DOWN,
                Command.RIGHT,
                Command.RIGHT,
                Command.DOWN,
                Command.LEFT,
                Command.LEFT
        );
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(2028, result);
    }

    @Test
    void shouldBe10092forLargerAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem15_example.txt");
        PartOne partOne = new PartOne(grid);
        List<Command> commands = testUtils.loadCommandsFromFile("adventofcode/year2024/problem15_example.txt");
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(10092, result);
    }

    @Test
    void shouldBe1478649forLargerAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadGridFromFile("adventofcode/year2024/problem15_input.txt");
        PartOne partOne = new PartOne(grid);
        List<Command> commands = testUtils.loadCommandsFromFile("adventofcode/year2024/problem15_input.txt");
        partOne.simulate(commands);
        int result = partOne.sumBoxGpsCoordinates(grid);
        Assertions.assertEquals(1478649, result);
    }
}