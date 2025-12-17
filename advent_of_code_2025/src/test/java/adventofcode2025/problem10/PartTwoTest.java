package adventofcode2025.problem10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    @Test
    void shouldBe0ifNoJoltageRequirements() {
        List<List<Integer>> buttons = List.of();
        List<Integer> joltageRequirements = List.of();
        PartTwo partTwo = new PartTwo(new Machine(null, buttons, joltageRequirements));
        int result = partTwo.countRequiredPresses();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1ifJoltageOf1andButtonOf1() {
        List<List<Integer>> buttons = List.of(List.of(0));
        List<Integer> joltageRequirements = List.of(1);
        PartTwo partTwo = new PartTwo(new Machine(null, buttons, joltageRequirements));
        int result = partTwo.countRequiredPresses();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifJoltageOf2andButtonOf1() {
        List<List<Integer>> buttons = List.of(List.of(0));
        List<Integer> joltageRequirements = List.of(2);
        PartTwo partTwo = new PartTwo(new Machine(null, buttons, joltageRequirements));
        int result = partTwo.countRequiredPresses();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2ifJoltageOf2and2andButtonOf01() {
        List<List<Integer>> buttons = List.of(List.of(0, 1));
        List<Integer> joltageRequirements = List.of(2, 2);
        PartTwo partTwo = new PartTwo(new Machine(null, buttons, joltageRequirements));
        int result = partTwo.countRequiredPresses();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4ifJoltageOf2and2andButtonOf0andButtonOf1() {
        List<List<Integer>> buttons = List.of(List.of(0), List.of(1));
        List<Integer> joltageRequirements = List.of(2, 2);
        PartTwo partTwo = new PartTwo(new Machine(null, buttons, joltageRequirements));
        int result = partTwo.countRequiredPresses();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe33forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Machine> machines = fileLoader.loadAndParse("problem10_example.txt");
        int result = 0;
        for (Machine machine : machines) {
            PartTwo partTwo = new PartTwo(machine);
            result += partTwo.countRequiredPresses();
        }
        Assertions.assertEquals(33, result);
    }

    @Test
    void shouldBe21469forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Machine> machines = fileLoader.loadAndParse("problem10_input.txt");
        int result = 0;
        for (Machine machine : machines) {
            PartTwo partTwo = new PartTwo(machine);
            result += partTwo.countRequiredPresses();
        }
        Assertions.assertEquals(21469, result);
    }
}