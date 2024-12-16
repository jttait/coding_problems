package adventofcode.year2024.problem5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBeTrueForTwoPagesInValidOrder() {
        List<PageOrdering> pageOrderings = List.of(new PageOrdering(1, 2));
        List<Integer> pages = List.of(1, 2);
        boolean result = partOne.isInValidOrder(pageOrderings, pages);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeFalseForTwoPagesNotInValidOrder() {
        List<PageOrdering> pageOrderings = List.of(new PageOrdering(1, 2));
        List<Integer> pages = List.of(2, 1);
        boolean result = partOne.isInValidOrder(pageOrderings, pages);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBe143forAdventOfCodeExample() throws Exception {
        TestInput testInput = testUtils.loadFile("adventofcode_year2024_problem5_example.txt");
        int result = 0;
        for (List<Integer> section : testInput.sections()) {
            if (partOne.isInValidOrder(testInput.pageOrderings(), section)) {
                result += section.get((section.size()/2));
            }
        }
        Assertions.assertEquals(143, result);
    }

    @Test
    void shouldBeXforAdventOfCodeInput() throws Exception {
        TestInput testInput = testUtils.loadFile("adventofcode_year2024_problem5_input.txt");
        int result = 0;
        for (List<Integer> section : testInput.sections()) {
            if (partOne.isInValidOrder(testInput.pageOrderings(), section)) {
                result += section.get((section.size()/2));
            }
        }
        Assertions.assertEquals(4569, result);
    }
}