package adventofcode.year2024.problem19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartTwoTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBePossibleForExactMatch() {
        List<String> availableTowels = List.of("r");
        PartTwo partTwo = new PartTwo(availableTowels);
        long result = partTwo.countPossibleArrangements("r");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBePossibleForExactMatchWithListOfTwoAvailableTowels() {
        List<String> availableTowels = List.of("gr", "r");
        PartTwo partTwo = new PartTwo(availableTowels);
        long result = partTwo.countPossibleArrangements("r");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBePossibleForCombiningTwoTowels() {
        List<String> availableTowels = List.of("r");
        PartTwo partTwo = new PartTwo(availableTowels);
        long result = partTwo.countPossibleArrangements("rr");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBePossibleForCombiningTwoDifferentTowels() {
        List<String> availableTowels = List.of("r", "g");
        PartTwo partTwo = new PartTwo(availableTowels);
        long result = partTwo.countPossibleArrangements("gr");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forBWRRandAdventOfCodeExample() throws Exception {
        List<String> availableTowels = testUtils.loadAvailableTowelsFromFile("adventofcode/year2024/problem19_example.txt");
        PartTwo partTwo = new PartTwo(availableTowels);
        long result = partTwo.countPossibleArrangements("brwrr");
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe16possibleArrangementsForAdventOfCodeExample() throws Exception {
        List<String> availableTowels = testUtils.loadAvailableTowelsFromFile("adventofcode/year2024/problem19_example.txt");
        PartTwo partTwo = new PartTwo(availableTowels);
        List<String> designs = testUtils.loadDesignsFromFile("adventofcode/year2024/problem19_example.txt");
        long result = partTwo.countPossibleArrangementsForDesigns(designs);
        Assertions.assertEquals(16, result);
    }

    @Test
    void shouldBe6possibleArrangementsForAdventOfCodeInput() throws Exception {
        List<String> availableTowels = testUtils.loadAvailableTowelsFromFile("adventofcode/year2024/problem19_input.txt");
        PartTwo partTwo = new PartTwo(availableTowels);
        List<String> designs = testUtils.loadDesignsFromFile("adventofcode/year2024/problem19_input.txt");
        long result = partTwo.countPossibleArrangementsForDesigns(designs);
        Assertions.assertEquals(758890600222015L, result);
    }
}