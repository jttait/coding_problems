package adventofcode.problem22;

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
    void shouldBe23forStartingNumbersOf1and2and3and2024() {
        List<Integer> startingNumbers = List.of(1, 2, 3, 2024);
        long result = partTwo.maximiseProfit(startingNumbers);
        Assertions.assertEquals(23, result);
    }

    @Test
    void shouldBe1831forAdventOfCodeInput() throws Exception {
        List<Integer> startingNumbers = testUtils.loadFromFile("problem22_input.txt");
        long result = partTwo.maximiseProfit(startingNumbers);
        Assertions.assertEquals(1831L, result); // 1881 is too high
    }
}