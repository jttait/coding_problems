package adventofcode.year2024.problem5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PartTwoTest {
    private PartTwo partTwo;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe2whenSortedIntoValidOrder () {
        List<PageOrdering> pageOrderings = List.of(
                new PageOrdering(1, 2),
                new PageOrdering(2, 3)
        );
        List<Integer> pages = List.of(1, 3, 2);
        int result = partTwo.sortIntoValidOrderAndTakeMiddleValue(pageOrderings, pages);
        Assertions.assertEquals(2, result);

    }

    @Test
    void shouldBe143forAdventOfCodeExample() throws Exception {
        TestInput testInput = testUtils.loadFile("adventofcode/year2024/adventofcode_year2024_problem5_example.txt");
        int result = 0;
        for (List<Integer> section : testInput.sections()) {
            result += partTwo.sortAndGetMiddleValueIfNotValid(testInput.pageOrderings(), section);
        }
        Assertions.assertEquals(123, result);
    }

    @Test
    void shouldBe143forAdventOfCodeInput() throws Exception {
        TestInput testInput = testUtils.loadFile("adventofcode/year2024/adventofcode_year2024_problem5_input.txt");
        int result = 0;
        for (List<Integer> section : testInput.sections()) {
            result += partTwo.sortAndGetMiddleValueIfNotValid(testInput.pageOrderings(), section);
        }
        Assertions.assertEquals(6456, result);
    }
}
