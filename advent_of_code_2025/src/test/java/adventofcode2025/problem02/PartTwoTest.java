package adventofcode2025.problem02;

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
    void shouldBeValidFor10() {
        boolean result = partTwo.isValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeInvalidFor11() {
        boolean result = partTwo.isValid(11);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor22() {
        boolean result = partTwo.isValid(22);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor99() {
        boolean result = partTwo.isValid(99);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor111() {
        boolean result = partTwo.isValid(111);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor2121212121() {
        boolean result = partTwo.isValid(2121212121);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor824824824() {
        boolean result = partTwo.isValid(824824824);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeValidFor824824825() {
        boolean result = partTwo.isValid(824824825);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBe1227775554forAdventOfCodeExample() throws Exception {
        List<List<Long>> pairs = testUtils.loadFromFile("problem02_example.txt");
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partTwo.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(4174379265L, result);
    }

    @Test
    void shouldBe37432260594forAdventOfCodeInput() throws Exception {
        List<List<Long>> pairs = testUtils.loadFromFile("problem02_input.txt");
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partTwo.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(37432260594L, result);
    }
}