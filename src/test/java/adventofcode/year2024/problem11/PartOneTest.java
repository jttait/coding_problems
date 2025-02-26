package adventofcode.year2024.problem11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private PartOne partOne;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
    }

    @Test
    void shouldBe1for0after1blink() {
        List<Long> stones = List.of(0L);
        long result = partOne.stoneAfterBlinks(stones, 1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for12after1blink() {
        List<Long> stones = List.of(12L);
        long result = partOne.stoneAfterBlinks(stones, 1);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1for1after1blink() {
        List<Long> stones = List.of(1L);
        long result = partOne.stoneAfterBlinks(stones, 1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe7for0and1and10and99and999after1blink() {
        List<Long> stones = List.of(0L, 1L, 10L, 99L, 999L);
        long result = partOne.stoneAfterBlinks(stones, 1);
        Assertions.assertEquals(7, result);
    }

    @Test
    void shouldBe22for125and17after6blinks() {
        List<Long> stones = List.of(125L, 17L);
        long result = partOne.stoneAfterBlinks(stones, 6);
        Assertions.assertEquals(22, result);
    }

    @Test
    void shouldBe186175forAdventOfCodeInputAfter25blinks() {
        List<Long> stones = List.of(5688L, 62084L, 2L, 3248809L, 179L, 79L, 0L, 172169L);
        long result = partOne.stoneAfterBlinks(stones, 75);
        Assertions.assertEquals(186175, result);
    }
}