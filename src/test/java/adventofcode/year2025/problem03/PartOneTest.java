package adventofcode.year2025.problem03;

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
    void shouldBe0forEmptyList() {
        List<Integer> batteries = List.of();
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for1() {
        List<Integer> batteries = List.of(1);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe12for12() {
        List<Integer> batteries = List.of(1, 2);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldBe23for123() {
        List<Integer> batteries = List.of(1, 2, 3);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(23, result);
    }

    @Test
    void shouldBe23for1234() {
        List<Integer> batteries = List.of(1, 2, 3, 4);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(34, result);
    }

    @Test
    void shouldBe52for512() {
        List<Integer> batteries = List.of(5, 1, 2);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(52, result);
    }

    @Test
    void shouldBe98for987654321111111() {
        PartOne partOne = new PartOne();
        List<Integer> batteries = List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(98, result);
    }

    @Test
    void shouldBe89for811111111111119() {
        List<Integer> batteries = List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  1, 9);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(89, result);
    }

    @Test
    void shouldBe78for234234234234278() {
        List<Integer> batteries = List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(78, result);
    }

    @Test
    void shouldBe92for818181911112111() {
        List<Integer> batteries = List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1);
        int result = partOne.findLargestJoltage(batteries);
        Assertions.assertEquals(92, result);
    }

    @Test
    void shouldBe357forAdventOfCodeExample() throws Exception {
        List<List<Integer>> banks = testUtils.loadFromFile("adventofcode/year2025/problem03_example.txt");
        int result = 0;
        for (List<Integer> batteries : banks) {
            result += partOne.findLargestJoltage(batteries);
        }
        Assertions.assertEquals(357, result);
    }

    @Test
    void shouldBe17263forAdventOfCodeInput() throws Exception {
        List<List<Integer>> banks = testUtils.loadFromFile("adventofcode/year2025/problem03_input.txt");
        int result = 0;
        for (List<Integer> batteries : banks) {
            result += partOne.findLargestJoltage(batteries);
        }
        Assertions.assertEquals(17263, result);
    }
}