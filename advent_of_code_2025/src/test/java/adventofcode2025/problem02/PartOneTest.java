package adventofcode2025.problem02;

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
    void shouldBeValidFor10() {
        boolean result = partOne.isValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeInvalidFor11() {
        boolean result = partOne.isValid(11);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor22() {
        boolean result = partOne.isValid(22);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor99() {
        boolean result = partOne.isValid(99);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor1010() {
        boolean result = partOne.isValid(1010);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor1188511885() {
        boolean result = partOne.isValid(1188511885);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor222222() {
        boolean result = partOne.isValid(222222);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor446446() {
        boolean result = partOne.isValid(446446);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeInvalidFor38593859() {
        boolean result = partOne.isValid(38593859);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeValidFor38593858() {
        boolean result = partOne.isValid(38593858);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBe33for11to22() {
        long result = partOne.sumInvalidNumbers(11, 22);
        Assertions.assertEquals(33, result);
    }

    @Test
    void shouldBe99for95to115() {
        long result = partOne.sumInvalidNumbers(95, 115);
        Assertions.assertEquals(99, result);
    }

    @Test
    void shouldBe38593859for38593856to38593862() {
        long result = partOne.sumInvalidNumbers(38593856, 38593862);
        Assertions.assertEquals(38593859, result);
    }

    @Test
    void shouldBe0for2121212118to2121212124() {
        long result = partOne.sumInvalidNumbers(2121212118, 2121212124);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1227775554forAdventOfCodeExample() throws Exception {
        List<List<Long>> pairs = testUtils.loadFromFile("problem02_example.txt");
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partOne.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(1227775554L, result);
    }

    @Test
    void shouldBe29818212493forAdventOfCodeInput() throws Exception {
        List<List<Long>> pairs = testUtils.loadFromFile("problem02_input.txt");
        long result = 0;
        for (List<Long> pair : pairs) {
            result += partOne.sumInvalidNumbers(pair.get(0), pair.get(1));
        }
        Assertions.assertEquals(29818212493L, result);
    }
}