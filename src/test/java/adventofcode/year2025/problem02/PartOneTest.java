package adventofcode.year2025.problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldBeValidFor10() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeInvalidFor11() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(11);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor22() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(22);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor99() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(99);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor1010() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(1010);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor1188511885() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(1188511885);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor222222() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(222222);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor446446() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(446446);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor38593859() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(38593859);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeValidFor38593858() {
        PartOne partOne = new PartOne();
        boolean result = partOne.isValid(38593858);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBe33for11to22() {
        PartOne partOne = new PartOne();
        long result = partOne.sumInvalidNumbers(11, 22);
        Assertions.assertEquals(33, result);
    }

    @Test
    void shouldBe99for95to115() {
        PartOne partOne = new PartOne();
        long result = partOne.sumInvalidNumbers(95, 115);
        Assertions.assertEquals(99, result);
    }

    @Test
    void shouldBe38593859for38593856to38593862() {
        PartOne partOne = new PartOne();
        long result = partOne.sumInvalidNumbers(38593856, 38593862);
        Assertions.assertEquals(38593859, result);
    }

    @Test
    void shouldBe0for2121212118to2121212124() {
        PartOne partOne = new PartOne();
        long result = partOne.sumInvalidNumbers(2121212118, 2121212124);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1227775554forAdventOfCodeExample() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<List<Long>> pairs = testUtils.loadFromFile("adventofcode/year2025/problem02_example.txt");
        PartOne partOne = new PartOne();
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partOne.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(1227775554L, result);
    }

    @Test
    void shouldBe29818212493forAdventOfCodeInput() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<List<Long>> pairs = testUtils.loadFromFile("adventofcode/year2025/problem02_input.txt");
        PartOne partOne = new PartOne();
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partOne.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(29818212493L, result);
    }
}