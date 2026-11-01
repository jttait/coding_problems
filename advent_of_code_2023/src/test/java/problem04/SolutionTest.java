package problem04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void shouldBe0whenHaveNoMatchingNumbers() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(1), Set.of(2));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1whenHaveOneMatchingNumbers() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(1), Set.of(1));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2whenHaveTwoMatchingNumbers() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(1, 2), Set.of(1, 2));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4whenHaveThreeMatchingNumbers() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(1, 2, 3), Set.of(1, 2, 3));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe8whenHaveFourMatchingNumbers() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(1, 2, 3, 4), Set.of(1, 2, 3, 4));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldBe8whenHaveFirstAdventOfCodeExample() {
        Scratchcard scratchcard = new Scratchcard(1, Set.of(41, 48, 83, 86, 17), Set.of(83, 86, 6, 31, 17, 9, 48, 53));
        long result = solution.calculatePoints(scratchcard);
        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldBe23678ForAdventOfCodeInput() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<Scratchcard> scratchcards = testUtils.loadFromFile("problem04_input.txt");
        long result = 0;
        for (Scratchcard scratchcard : scratchcards) {
            result += solution.calculatePoints(scratchcard);
        }
        Assertions.assertEquals(23678, result);
    }

    @Test
    void shouldBe1whenOneScratchcardAndDoesNotMatch() {
        List<Scratchcard> scratchcards = List.of(
                new Scratchcard(1, Set.of(1), Set.of(2))
        );
        long result = solution.countWonScratchcards(scratchcards);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1whenOneScratchcardAndDoesMatch() {
        List<Scratchcard> scratchcards = List.of(
                new Scratchcard(1, Set.of(1), Set.of(1))
        );
        long result = solution.countWonScratchcards(scratchcards);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3whenTwoScratchcardAndBothMatch() {
        List<Scratchcard> scratchcards = List.of(
                new Scratchcard(1, Set.of(1), Set.of(1)),
                new Scratchcard(2, Set.of(2), Set.of(2))
        );
        long result = solution.countWonScratchcards(scratchcards);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe15455663ForAdventOfCodeInputAndPartTwo() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<Scratchcard> scratchcards = testUtils.loadFromFile("problem04_input.txt");
        long result = solution.countWonScratchcards(scratchcards);
        Assertions.assertEquals(15455663, result);
    }

}