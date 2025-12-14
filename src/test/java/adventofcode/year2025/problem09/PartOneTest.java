package adventofcode.year2025.problem09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    // O
    // O
    @Test
    void shouldBe2forVerticalLineOfLength1() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(0, 1)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(2, result);
    }

    // O
    // O
    // O
    @Test
    void shouldBe3forVerticalLineOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(0, 2)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    // OO
    @Test
    void shouldBe2forHorizontalLineOfLength1() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(1, 0)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(2, result);
    }

    // OOO
    @Test
    void shouldBe3forHorizontalLineOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(2, 0)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    // OO
    // OO
    @Test
    void shouldBe4forSquareOfLength1() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(1, 1)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(4, result);
    }

    // OOO
    // OOO
    // OOO
    @Test
    void shouldBe9forSquareOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(2, 2)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(9, result);
    }

    // O
    // O
    // O
    @Test
    void shouldBe3forVerticalLineOfLength1andVerticalLineOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(0, 1),
                new Tile(0, 2)
        );
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe50ForAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Tile> tiles = fileLoader.loadAndParse("adventofcode/year2025/problem09_example.txt");
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(50, result);
    }

    @Test
    void shouldBe4737096935ForAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Tile> tiles = fileLoader.loadAndParse("adventofcode/year2025/problem09_input.txt");
        PartOne partOne = new PartOne(tiles);
        long result = partOne.calculateLargestRectangle();
        Assertions.assertEquals(4737096935L, result);
    }
}