package adventofcode.problem03;

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
    void shouldBe0forEmptyList() {
        List<Integer> batteries = List.of();
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for1() {
        List<Integer> batteries = List.of(1);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe12for12() {
        List<Integer> batteries = List.of(1, 2);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldBe123for123() {
        List<Integer> batteries = List.of(1, 2, 3);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(123, result);
    }

    @Test
    void shouldBe1234for1234() {
        List<Integer> batteries = List.of(1, 2, 3, 4);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(1234, result);
    }

    @Test
    void shouldBe987654321111for987654321111111() {
        List<Integer> batteries = List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(987654321111L, result);
    }

    @Test
    void shouldBe811111111119for811111111111119() {
        List<Integer> batteries = List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(811111111119L, result);
    }

    @Test
    void shouldBe434234234278for234234234234278() {
        List<Integer> batteries = List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(434234234278L, result);
    }

    @Test
    void shouldBe888911112111for818181911112111() {
        List<Integer> batteries = List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1);
        long result = partTwo.findLargestJoltage(batteries);
        Assertions.assertEquals(888911112111L, result);
    }

    @Test
    void shouldBe3121910778619forAdventOfCodeExample() throws Exception {
        List<List<Integer>> banks = testUtils.loadFromFile("problem03_example.txt");
        long result = 0;
        for (List<Integer> batteries : banks) {
            result += partTwo.findLargestJoltage(batteries);
        }
        Assertions.assertEquals(3121910778619L, result);
    }

    @Test
    void shouldBe170731717900423forAdventOfCodeInput() throws Exception {
        List<List<Integer>> banks = testUtils.loadFromFile("problem03_input.txt");
        long result = 0;
        for (List<Integer> batteries : banks) {
            result += partTwo.findLargestJoltage(batteries);
        }
        Assertions.assertEquals(170731717900423L, result);
    }
}