package adventofcode.year2025.problem08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldBe1forTwoJunctionBoxesAnd1pair() {
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0, 0, 0),
                new JunctionBox(1, 0, 0)
        );
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 1);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forThreeJunctionBoxesAnd1pair() {
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0, 0, 0),
                new JunctionBox(1, 0, 0),
                new JunctionBox(100, 0, 0)
        );
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 1);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1forThreeJunctionBoxesAnd2pairs() {
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0, 0, 0),
                new JunctionBox(1, 0, 0),
                new JunctionBox(100, 0, 0)
        );
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe2forFourJunctionBoxesAnd2pairs() {
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0, 0, 0),
                new JunctionBox(1, 0, 0),
                new JunctionBox(100, 0, 0),
                new JunctionBox(101, 0, 0)
        );
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 2);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe2forFourJunctionBoxesAnd3pairs() {
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0, 0, 0),
                new JunctionBox(1, 0, 0),
                new JunctionBox(100, 0, 0),
                new JunctionBox(101, 0, 0)
        );
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 3);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe40forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<JunctionBox> junctionBoxes = fileLoader.loadAndParse("adventofcode/year2025/problem08_example.txt");
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 10);
        Assertions.assertEquals(40, result);
    }

    @Test
    void shouldBe42840forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<JunctionBox> junctionBoxes = fileLoader.loadAndParse("adventofcode/year2025/problem08_input.txt");
        PartOne partOne = new PartOne();
        int result = partOne.calculateThreeLargestCircuits(junctionBoxes, 1000);
        Assertions.assertEquals(42840, result);
    }
}