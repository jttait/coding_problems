package adventofcode2025.problem10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldBe0ifTargetAllFalse() {
        List<Boolean> target = List.of(false);
        List<List<Integer>> buttons = List.of();
        PartOne partOne = new PartOne(new Machine(target, buttons, null));
        int result = partOne.countRequiredPresses();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1ifTargetTrueAndButtonIs0() {
        List<Boolean> target = List.of(true);
        List<List<Integer>> buttons = List.of(List.of(0));
        PartOne partOne = new PartOne(new Machine(target, buttons, null));
        int result = partOne.countRequiredPresses();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forFirstAdventOfCodeExample() {
        List<Boolean> target = List.of(false, true, true, false);
        List<List<Integer>> buttons = List.of(
                List.of(3),
                List.of(1,3),
                List.of(2),
                List.of(2, 3),
                List.of(0, 2),
                List.of(0, 1)
        );
        PartOne partOne = new PartOne(new Machine(target, buttons, null));
        int result = partOne.countRequiredPresses();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forSecondAdventOfCodeExample() {
        List<Boolean> target = List.of(false, false, false, true, false);
        List<List<Integer>> buttons = List.of(
                List.of(0, 2, 3, 4),
                List.of(2,3),
                List.of(0, 4),
                List.of(0, 1, 2),
                List.of(1, 2, 3, 4)
        );
        PartOne partOne = new PartOne(new Machine(target, buttons, null));
        int result = partOne.countRequiredPresses();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe2forThirdAdventOfCodeExample() {
        List<Boolean> target = List.of(false, true, true, true, false, true);
        List<List<Integer>> buttons = List.of(
                List.of(0, 1, 2, 3, 4),
                List.of(0, 3, 4),
                List.of(0, 1, 2, 4, 5),
                List.of(1, 2)
        );
        PartOne partOne = new PartOne(new Machine(target, buttons, null));
        int result = partOne.countRequiredPresses();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe7forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Machine> machines = fileLoader.loadAndParse("problem10_example.txt");
        int result = 0;
        for (Machine machine : machines) {
            PartOne partOne = new PartOne(machine);
            result += partOne.countRequiredPresses();
        }
        Assertions.assertEquals(7, result);
    }

    @Test
    void shouldBe517forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Machine> machines = fileLoader.loadAndParse("problem10_input.txt");
        int result = 0;
        for (Machine machine : machines) {
            PartOne partOne = new PartOne(machine);
            result += partOne.countRequiredPresses();
        }
        Assertions.assertEquals(517, result);
    }
}