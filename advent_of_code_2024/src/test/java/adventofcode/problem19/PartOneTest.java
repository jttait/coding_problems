package adventofcode.problem19;

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
    void shouldBePossibleForExactMatch() {
        List<String> availableTowels = List.of("r");
        PartOne partOne = new PartOne(availableTowels);
        boolean result = partOne.isDesignPossible("r");
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBePossibleForExactMatchWithListOfTwoAvailableTowels() {
        List<String> availableTowels = List.of("gr", "r");
        PartOne partOne = new PartOne(availableTowels);
        Assertions.assertTrue(partOne.isDesignPossible("r"));
    }

    @Test
    void shouldBePossibleForCombiningTwoTowels() {
        List<String> availableTowels = List.of("r");
        PartOne partOne = new PartOne(availableTowels);
        Assertions.assertTrue(partOne.isDesignPossible("rr"));
    }

    @Test
    void shouldBePossibleForCombiningTwoDifferentTowels() {
        List<String> availableTowels = List.of("r", "g");
        PartOne partOne = new PartOne(availableTowels);
        Assertions.assertTrue(partOne.isDesignPossible("gr"));
    }

    @Test
    void shouldBe6possibleDesignsForAdventOfCodeExample() throws Exception {
        List<String> availableTowels = testUtils.loadAvailableTowelsFromFile("problem19_example.txt");
        PartOne partOne = new PartOne(availableTowels);
        List<String> designs = testUtils.loadDesignsFromFile("problem19_example.txt");
        int result = partOne.countPossibleDesigns(designs);
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldBe336possibleDesignsForAdventOfCodeInput() throws Exception {
        List<String> availableTowels = testUtils.loadAvailableTowelsFromFile("problem19_input.txt");
        PartOne partOne = new PartOne(availableTowels);
        List<String> designs = testUtils.loadDesignsFromFile("problem19_input.txt");
        int result = partOne.countPossibleDesigns(designs);
        Assertions.assertEquals(336, result);
    }
}