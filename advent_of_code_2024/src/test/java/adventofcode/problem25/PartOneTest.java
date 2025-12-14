package adventofcode.problem25;

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
    void shouldBe0forOverlappingLockAndKey() {
        List<List<Integer>> locks = List.of(List.of(0, 5, 3, 4, 3));
        List<List<Integer>> keys = List.of(List.of(5, 0, 2, 1, 3));
        PartOne partOne = new PartOne(locks, keys);
        int result = partOne.countFittingLocksAndKeys();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1forNonOverlappingLockAndKey() {
        List<List<Integer>> locks = List.of(List.of(0, 5, 3, 4, 3));
        List<List<Integer>> keys = List.of(List.of(5, 0, 2, 1, 2));
        PartOne partOne = new PartOne(locks, keys);
        int result = partOne.countFittingLocksAndKeys();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3forAdventOfCodeExample() {
        List<List<Integer>> locks = List.of(
                List.of(0, 5, 3, 4, 3),
                List.of(1, 2, 0, 5, 3)
        );
        List<List<Integer>> keys = List.of(
                List.of(5, 0, 2, 1, 3),
                List.of(4, 3, 4, 0, 2),
                List.of(3, 0, 2, 0, 1)
        );
        PartOne partOne = new PartOne(locks, keys);
        int result = partOne.countFittingLocksAndKeys();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe3forReadingAdventOfCodeExampleFromFile() throws Exception {
        List<List<Integer>> locks = testUtils.loadLocksFromFile("problem25_example.txt");
        List<List<Integer>> keys = testUtils.loadKeysFromFile("problem25_example.txt");
        PartOne partOne = new PartOne(locks, keys);
        int result = partOne.countFittingLocksAndKeys();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe3057forAdventOfCodeInput() throws Exception {
        List<List<Integer>> locks = testUtils.loadLocksFromFile("problem25_input.txt");
        List<List<Integer>> keys = testUtils.loadKeysFromFile("problem25_input.txt");
        PartOne partOne = new PartOne(locks, keys);
        int result = partOne.countFittingLocksAndKeys();
        Assertions.assertEquals(3057, result);
    }
}