package problem03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBeZeroWhenEmptyGrid() {
        List<List<Character>> grid = List.of(
                List.of()
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeZeroWhenNoNumbers() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', '.')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeZeroWhenNoSymbols() {
        List<List<Character>> grid = List.of(
                List.of('1', '2', '3')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe123whenDollarSymbol() {
        List<List<Character>> grid = List.of(
                List.of('1', '2', '3', '$')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(123, result);
    }

    @Test
    void shouldBe300whenTwoNumbersSeparatedBySymbol() {
        List<List<Character>> grid = List.of(
                List.of('1', '0', '0', '$', '2', '0', '0')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(300, result);
    }

    @Test
    void shouldBe0whenTwoNumbersSeparatedByFullStop() {
        List<List<Character>> grid = List.of(
                List.of('1', '0', '0', '.', '2', '0', '0')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe500whenTwoNumbersTouchingSymbolsOnDifferentRows() {
        List<List<Character>> grid = List.of(
                List.of('1', '0', '0', '$'),
                List.of('.', '.', '.', '.'),
                List.of('#', '4', '0', '0')
        );
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(500, result);
    }

    @Test
    void shouldBe4361forAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem03_example.txt");
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(4361, result);
    }

    @Test
    void shouldBe539590forAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem03_input.txt");
        Solution solution = new Solution(grid);
        int result = solution.sumParts();
        Assertions.assertEquals(539590, result);
    }

    @Test
    void shouldBeGearRatioZeroWhenEmptyGrid() {
        List<List<Character>> grid = List.of(
                List.of()
        );
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeGearRatioOfZeroWhenNoNumbers() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', '.')
        );
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeGearRatioOfZeroWhenNoAsterisks() {
        List<List<Character>> grid = List.of(
                List.of('1', '2', '3')
        );
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBeGearRatioOfZeroWhenDollarSymbol() {
        List<List<Character>> grid = List.of(
                List.of('1', '2', '3', '$')
        );
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe20000whenTwoNumbersSeparatedByAsterisk() {
        List<List<Character>> grid = List.of(
                List.of('1', '0', '0', '*', '2', '0', '0')
        );
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(20000, result);
    }

    @Test
    void shouldBe467835whenAdventOfCodeExample() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem03_example.txt");
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(467835, result);
    }

    @Test
    void shouldBe80703636whenAdventOfCodeInput() throws Exception {
        List<List<Character>> grid = testUtils.loadFromFile("problem03_input.txt");
        Solution solution = new Solution(grid);
        int result = solution.findGearRatio();
        Assertions.assertEquals(80703636, result);
    }
}