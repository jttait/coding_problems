package adventofcode2025.problem12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldFitIfNoShapes() {
        Tree tree = new Tree(List.of(), 1, 1);
        PartOne partOne = new PartOne(tree, List.of());
        boolean result = partOne.canShapesFitInGrid();
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFitIfBigGridAndOnePresent() {
        Tree tree = new Tree(List.of(1), 99, 99);
        PartOne partOne = new PartOne(tree, List.of(1));
        boolean result = partOne.canShapesFitInGrid();
        Assertions.assertTrue(result);
    }

    @Test
    void shouldNotFitIfSmallGridAndManyPresents() {
        Tree tree = new Tree(List.of(99), 1, 1);
        PartOne partOne = new PartOne(tree, List.of(9));
        boolean result = partOne.canShapesFitInGrid();
        Assertions.assertFalse(result);
    }

    @Test
    void shouldBe557forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        Problem problem = fileLoader.loadAndParse("problem12_input.txt");
        int result = 0;
        for (Tree tree : problem.trees()) {
            PartOne partOne = new PartOne(tree, problem.presentSizes());
            result += partOne.canShapesFitInGrid() ? 1 : 0;
        }
        Assertions.assertEquals(557, result);
    }
}