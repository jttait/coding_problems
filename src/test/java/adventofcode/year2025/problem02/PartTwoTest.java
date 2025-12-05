package adventofcode.year2025.problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    @Test
    void shouldBeValidFor10() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeInvalidFor11() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(11);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor22() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(22);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor99() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(99);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor111() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(111);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor2121212121() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(2121212121);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor824824824() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(824824824);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeValidFor824824825() {
        PartTwo partTwo = new PartTwo();
        boolean result = partTwo.isValid(824824825);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBe1227775554forAdventOfCodeExample() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<List<Long>> pairs = testUtils.loadFromFile("adventofcode/year2025/problem02_example.txt");
        PartTwo partTwo = new PartTwo();
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partTwo.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(4174379265L, result);
    }

    @Test
    void shouldBe37432260594forAdventOfCodeInput() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<List<Long>> pairs = testUtils.loadFromFile("adventofcode/year2025/problem02_input.txt");
        PartTwo partTwo = new PartTwo();
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partTwo.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(37432260594L, result);
    }
}