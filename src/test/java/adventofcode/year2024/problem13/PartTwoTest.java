package adventofcode.year2024.problem13;

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
    void shouldBe0forFirstClawMachine() {
        PartTwo partTwo = new PartTwo(94, 34, 22, 67, 8400, 5400);
        long result = partTwo.calculateCost();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe459236326669forSecondClawMachine() {
        PartTwo partTwo = new PartTwo(26, 66, 67, 21, 12748, 12176);
        long result = partTwo.calculateCost();
        Assertions.assertEquals(459236326669L, result);
    }

    @Test
    void shouldBe0forThirdClawMachine() {
        PartTwo partTwo = new PartTwo(17, 86, 84, 37, 7870, 6450);
        long result = partTwo.calculateCost();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe416082282239forFourthClawMachine() {
        PartTwo partTwo = new PartTwo(69, 23, 27, 71, 18641, 10279);
        long result = partTwo.calculateCost();
        Assertions.assertEquals(416082282239L, result);
    }

    @Test
    void shouldBe76358113886726forAdventOfCodeInput() throws Exception {
        List<List<Integer>> input = testUtils.loadFile("adventofcode/year2024/problem13_input.txt");
        long result = 0;
        for (List<Integer> machineProperties : input) {
            PartTwo partTwo = new PartTwo(
                machineProperties.get(0),
                machineProperties.get(1),
                machineProperties.get(2),
                machineProperties.get(3),
                machineProperties.get(4),
                machineProperties.get(5)
            );
            result += partTwo.calculateCost();
        }
        Assertions.assertEquals(76358113886726L, result);
    }
}