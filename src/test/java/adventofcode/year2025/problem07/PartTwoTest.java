package adventofcode.year2025.problem07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    @Test
    void shouldBe0for1x1withS() {
        List<List<Character>> grid = List.of(
                List.of('S')
        );
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe0for1x3withS() {
        List<List<Character>> grid = List.of(
                List.of('S'),
                List.of('.'),
                List.of('.')
        );
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forOneSplitter() {
        List<List<Character>> grid = List.of(
                List.of('.', 'S', '.'),
                List.of('.', '^', '.')
        );
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4forThreeSplitters() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', 'S', '.', '.'),
                List.of('.', '.', '^', '.', '.'),
                List.of('.', '^', '.', '^', '.')
        );
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe3forThreeSplittersWhenOneMissed() {
        List<List<Character>> grid = List.of(
                List.of('.', '.', '.', 'S', '.', '.'),
                List.of('.', '.', '.', '^', '.', '.'),
                List.of('.', '^', '.', '.', '^', '.')
        );
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe40forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<List<Character>> grid = fileLoader.loadAndParse("adventofcode/year2025/problem07_example.txt");
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(40, result);
    }

    @Test
    void shouldBe5137133207830forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<List<Character>> grid = fileLoader.loadAndParse("adventofcode/year2025/problem07_input.txt");
        PartTwo partTwo = new PartTwo(grid);
        long result = partTwo.simulate();
        Assertions.assertEquals(5137133207830L, result);
    }
}