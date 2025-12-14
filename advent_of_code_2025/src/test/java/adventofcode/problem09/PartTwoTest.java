package adventofcode.problem09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    // O
    // O
    @Test
    void shouldBe2forVerticalLineOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(0, 1)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(2, result);
    }

    // O
    // O
    // O
    @Test
    void shouldBe3forVerticalLineOfLength3() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(0, 2)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    // OO
    @Test
    void shouldBe2forHorizontalLineOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(1, 0)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(2, result);
    }

    // OOO
    @Test
    void shouldBe3forHorizontalLineOfLength3() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(2, 0)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    // OO
    // OO
    @Test
    void shouldBe4forSquareOfLength2() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(1, 0),
                new Tile(1, 1),
                new Tile(0, 1)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(4, result);
    }

    // OOO
    // OOO
    // OOO
    @Test
    void shouldBe9forSquareOfLength3() {
        List<Tile> tiles = List.of(
                new Tile(0, 0),
                new Tile(2, 0),
                new Tile(2, 2),
                new Tile(0, 2)
        );
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
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
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe24ForAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Tile> tiles = fileLoader.loadAndParse("problem09_example.txt");
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(24, result);
    }

    @Test
    void shouldBe1644094530ForAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<Tile> tiles = fileLoader.loadAndParse("problem09_input.txt");
        PartTwo partTwo = new PartTwo(tiles);
        long result = partTwo.calculateLargestRectangle();
        Assertions.assertEquals(1644094530, result);
    }
}