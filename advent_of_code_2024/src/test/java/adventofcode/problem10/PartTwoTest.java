package adventofcode.problem10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe1forSingleRow() {
        List<List<Integer>> grid = List.of(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forTwoRoutes() {
        List<List<Integer>> grid = List.of(
                List.of(0, 1, 2, 3, 4, 5, 6, 7),
                List.of(1, 8, 1, 1, 1, 1, 1, 8),
                List.of(2, 3, 4, 5, 6, 7, 8, 9)
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forFirstAdventOfCodeExample() {
        List<List<Integer>> grid = List.of(
                List.of(8, 8, 8, 8, 8, 0, 8),
                List.of(8, 8, 4, 3, 2, 1, 8),
                List.of(8, 8, 5, 8, 8, 2, 8),
                List.of(8, 8, 6, 5, 4, 3, 8),
                List.of(1, 1, 7, 1, 1, 4, 1),
                List.of(1, 1, 8, 7, 6, 5, 1),
                List.of(1, 1, 9, 1, 1, 1, 1)
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe227forAdventOfCodeExample() {
        List<List<Integer>> grid = List.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8),
                List.of(4, 1, 6, 7, 8, 9),
                List.of(5, 6, 7, 8, 9, 1)
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(227, result);
    }

    @Test
    void shouldBe81forAdventOfCodeExample() {
        List<List<Integer>> grid = List.of(
                List.of(8, 9, 0, 1, 0, 1, 2, 3),
                List.of(7, 8, 1, 2, 1, 8, 7, 4),
                List.of(8, 7, 4, 3, 0, 9, 6, 5),
                List.of(9, 6, 5, 4, 9, 8, 7, 4),
                List.of(4, 5, 6, 7, 8, 9, 0, 3),
                List.of(3, 2, 0, 1, 9, 0, 1, 2),
                List.of(0, 1, 3, 2, 9, 8, 0, 1),
                List.of(1, 0, 4, 5, 6, 7, 3, 2)
        );
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(81, result);
    }

    @Test
    void shouldBe1340forAdventOfCodeInput() throws Exception {
        List<List<Integer>> grid = testUtils.loadFile("problem10_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        int result = partTwo.sumTrailheadScores();
        Assertions.assertEquals(1340, result);
    }
}