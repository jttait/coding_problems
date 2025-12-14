package adventofcode.problem22;

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
    void shouldBe15887950forFirstSecretNumberOf123() {
        long result = partOne.getNthSecretNumber(123, 1);
        Assertions.assertEquals(15887950, result);
    }

    @Test
    void shouldBe16495136forSecondSecretNumberOf123() {
        long result = partOne.getNthSecretNumber(123, 2);
        Assertions.assertEquals(16495136, result);
    }

    @Test
    void shouldBe527345forThirdSecretNumberOf123() {
        long result = partOne.getNthSecretNumber(123, 3);
        Assertions.assertEquals(527345, result);
    }

    @Test
    void shouldBe704524forFourthSecretNumberOf123() {
        long result = partOne.getNthSecretNumber(123, 4);
        Assertions.assertEquals(704524, result);
    }

    @Test
    void shouldBe5908254forTenthSecretNumberOf123() {
        long result = partOne.getNthSecretNumber(123, 10);
        Assertions.assertEquals(5908254, result);
    }

    @Test
    void shouldBe8685429for2000thSecretNumberOf1() {
        long result = partOne.getNthSecretNumber(1, 2000);
        Assertions.assertEquals(8685429, result);
    }

    @Test
    void shouldBe4700978for2000thSecretNumberOf10() {
        long result = partOne.getNthSecretNumber(10, 2000);
        Assertions.assertEquals(4700978, result);
    }

    @Test
    void shouldBe15273692for2000thSecretNumberOf100() {
        long result = partOne.getNthSecretNumber(100, 2000);
        Assertions.assertEquals(15273692, result);
    }

    @Test
    void shouldBe8667524for2000thSecretNumberOf2024() {
        long result = partOne.getNthSecretNumber(2024, 2000);
        Assertions.assertEquals(8667524, result);
    }

    @Test
    void shouldBe14691757043forAdventOfCodeInput() throws Exception {
        List<Integer> startingNumbers = testUtils.loadFromFile("problem22_input.txt");
        long result = 0;
        for (int startingNumber : startingNumbers) {
            result += partOne.getNthSecretNumber(startingNumber, 2000);
        }
        Assertions.assertEquals(14691757043L, result);
    }
}