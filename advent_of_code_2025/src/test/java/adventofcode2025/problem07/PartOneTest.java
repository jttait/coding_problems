package adventofcode2025.problem07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {

    @Test
    void shouldBe0for1x1withS() {
        List<List<Character>> grid = List.of(
                List.of('S')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(0, result);

    }

    @Test
    void shouldBe0for1x3withS() {
        List<List<Character>> grid = List.of(
                List.of('S'),
                List.of('.'),
                List.of('.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1forOneSplitter() {
        List<List<Character>> grid = List.of(
                List.of('.', 'S', '.'),
                List.of('.', '^', '.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3forThreeSplitters() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', 'S', '.', '.'),
                List.of('.', '.', '^', '.', '.'),
                List.of('.', '^', '.', '^', '.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe3forThreeSplittersWhenOneMissed() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', 'S', '.', '.'),
                List.of('.', '.', '^', '.', '.'),
                List.of('^', '.', '.', '^', '.')
        );
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe21forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<List<Character>> grid = fileLoader.loadAndParse("problem07_example.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(21, result);
    }

    @Test
    void shouldBe1504forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<List<Character>> grid = fileLoader.loadAndParse("problem07_input.txt");
        PartOne partOne = new PartOne(grid);
        int result = partOne.simulate();
        Assertions.assertEquals(1504, result);
    }
}