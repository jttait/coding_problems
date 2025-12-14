package adventofcode.problem10;

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
    void shouldBe1forSingleRow() {
        List<List<Integer>> grid = List.of(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forSingleColumn() {
        List<List<Integer>> grid = List.of(
                List.of(0),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(4),
                List.of(5),
                List.of(6),
                List.of(7),
                List.of(8),
                List.of(9)
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forHorizontalAndVerticalTrails() {
        List<List<Integer>> grid = List.of(
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(4, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(5, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(6, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(7, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(9, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4forHorizontalAndVerticalTrailsFromTwoTrailheads() {
        List<List<Integer>> grid = List.of(
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 8),
                List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 7),
                List.of(3, 1, 1, 1, 1, 1, 1, 1, 1, 6),
                List.of(4, 1, 1, 1, 1, 1, 1, 1, 1, 5),
                List.of(5, 1, 1, 1, 1, 1, 1, 1, 1, 4),
                List.of(6, 1, 1, 1, 1, 1, 1, 1, 1, 3),
                List.of(7, 1, 1, 1, 1, 1, 1, 1, 1, 2),
                List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe2forFirstAdventOfCodeExample() {
        List<List<Integer>> grid = List.of(
               List.of(1, 1, 1, 0, 1, 1, 1),
               List.of(1, 1, 1, 1, 1, 1, 1),
               List.of(1, 1, 1, 2, 1, 1, 1),
               List.of(6, 5, 4, 3, 4, 5, 6),
               List.of(7, 1, 1, 1, 1, 1, 7),
               List.of(8, 1, 1, 1, 1, 1, 8),
               List.of(9, 1, 1, 1, 1, 1, 9)
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4forSecondAdventOfCodeExample() {
        List<List<Integer>> grid = List.of(
                List.of(1, 1, 9, 0, 3, 1, 9),
                List.of(1, 1, 1, 1, 1, 9, 8),
                List.of(1, 1, 1, 2, 1, 1, 7),
                List.of(6, 5, 4, 3, 4, 5, 6),
                List.of(7, 6, 5, 1, 9, 8, 7),
                List.of(8, 7, 6, 1, 1, 1, 1),
                List.of(9, 8, 7, 1, 1, 1, 1)
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe587forAdventOfCodeInput() throws Exception {
        List<List<Integer>> grid = testUtils.loadFile("problem10_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.sumTrailheadScores();
        Assertions.assertEquals(587, result);
    }
}