package adventofcode.problem13;

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
    void shouldBe3forAonce() {
        PartOne partOne = new PartOne(1, 3, 100, 100, 1, 3);
        int result = partOne.calculateCost();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe280forFirstClawMachine() {
        PartOne partOne = new PartOne(94, 34, 22, 67, 8400, 5400);
        int result = partOne.calculateCost();
        Assertions.assertEquals(280, result);
    }

    @Test
    void shouldBe0forSecondClawMachine() {
        PartOne partOne = new PartOne(26, 66, 67, 21, 12748, 12176);
        int result = partOne.calculateCost();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe200forThirdClawMachine() {
        PartOne partOne = new PartOne(17, 86, 84, 37, 7870, 6450);
        int result = partOne.calculateCost();
        Assertions.assertEquals(200, result);
    }

    @Test
    void shouldBe0forFourthClawMachine() {
        PartOne partOne = new PartOne(69, 23, 27, 71, 18641, 10279);
        int result = partOne.calculateCost();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe36758forAdventOfCodeInput() throws Exception {
        List<List<Integer>> input = testUtils.loadFile("adventofcode/year2024/problem13_input.txt");
        int result = 0;
        for (List<Integer> machineProperties : input) {
            PartOne partOne = new PartOne(
                machineProperties.get(0),
                machineProperties.get(1),
                machineProperties.get(2),
                machineProperties.get(3),
                machineProperties.get(4),
                machineProperties.get(5)
            );
            result += partOne.calculateCost();
        }
        Assertions.assertEquals(36758, result);
    }
}