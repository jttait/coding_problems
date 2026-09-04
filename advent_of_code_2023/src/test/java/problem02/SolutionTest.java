package problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    private Solution solution;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBePossibleForOneRevealWithAllElevens() {
        Game game = new Game(1, List.of(
                new Reveal(11, 11, 11)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBePossibleForOneRevealWith12redsAnd13greensAnd14blues() {
        Game game = new Game(1, List.of(
                new Reveal(12, 13, 14)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeImpossibleForOneRevealWith13reds() {
        Game game = new Game(1, List.of(
                new Reveal(13, 0, 0)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeImpossibleForOneRevealWith14greens() {
        Game game = new Game(1, List.of(
                new Reveal(0, 14, 0)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBeImpossibleForOneRevealWith15blues() {
        Game game = new Game(1, List.of(
                new Reveal(0, 0, 15)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBePossibleForTwoRevealWith10ofEachColorEach() {
        Game game = new Game(1, List.of(
                new Reveal(10, 10, 10),
                new Reveal(10, 10, 10)
        ));
        boolean result = solution.isGamePossible(12, 13, 14, game);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBe1whenGame1isPossible() {
        List<Game> games = List.of(
            new Game(1, List.of(new Reveal(1, 1, 1)))
        );
        int result = solution.sumIdsOfPossibleGames(12, 13, 14, games);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2whenGame1isImpossibleAndGame2isPossible() {
        List<Game> games = List.of(
                new Game(1, List.of(new Reveal(100, 100, 100))),
                new Game(2, List.of(new Reveal(1, 1, 1)))
        );
        int result = solution.sumIdsOfPossibleGames(12, 13, 14, games);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3whenGame1isPossibleAndGame2isPossible() {
        List<Game> games = List.of(
                new Game(1, List.of(new Reveal(1, 1, 1))),
                new Game(2, List.of(new Reveal(1, 1, 1)))
        );
        int result = solution.sumIdsOfPossibleGames(12, 13, 14, games);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe8forAdventOfCodeExample() throws Exception {
        List<Game> games = testUtils.loadFromFile("problem02_example.txt");
        int result = solution.sumIdsOfPossibleGames(12, 13, 14, games);
        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldBe2593forAdventOfCodeInput() throws Exception {
        List<Game> games = testUtils.loadFromFile("problem02_input.txt");
        int result = solution.sumIdsOfPossibleGames(12, 13, 14, games);
        Assertions.assertEquals(2593, result);
    }

    @Test
    void shouldBe1forOneRevealWithAllOnes() {
        Game game = new Game(1, List.of(
                new Reveal(1, 1, 1)
        ));
        int result = solution.calculateMinimumPowerOfGame(game);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe8forOneRevealWithAllTwos() {
        Game game = new Game(1, List.of(
                new Reveal(2, 2, 2)
        ));
        int result = solution.calculateMinimumPowerOfGame(game);
        Assertions.assertEquals(8, result);
    }

    @Test
    void shouldBe27forOneRevealWithAllThrees() {
        Game game = new Game(1, List.of(
                new Reveal(3, 3, 3)
        ));
        int result = solution.calculateMinimumPowerOfGame(game);
        Assertions.assertEquals(27, result);
    }

    @Test
    void shouldBe2286forAdventOfCodeExample() throws Exception {
        List<Game> games = testUtils.loadFromFile("problem02_example.txt");
        int result = solution.sumMinimumPowersOfGames(games);
        Assertions.assertEquals(2286, result);
    }

    @Test
    void shouldBe54699forAdventOfCodeInput() throws Exception {
        List<Game> games = testUtils.loadFromFile("problem02_input.txt");
        int result = solution.sumMinimumPowersOfGames(games);
        Assertions.assertEquals(54699, result);
    }
}