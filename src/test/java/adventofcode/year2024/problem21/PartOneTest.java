package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldBe68for029A() {
        List<Character> buttons = List.of('0', '2', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(68, shortestPath);
    }

    @Test
    void shouldBe60for980A() {
        List<Character> buttons = List.of('9', '8', '0', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(60, shortestPath);
    }

    @Test
    void shouldBe68for179A() {
        List<Character> buttons = List.of('1', '7', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(68, shortestPath);
    }

    @Test
    void shouldBe64for456A() {
        List<Character> buttons = List.of('4', '5', '6', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(64, shortestPath);
    }

    @Test
    void shouldBe64for379A() {
        List<Character> buttons = List.of('3', '7', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(64, shortestPath);
    }

    @Test
    void shouldBe70for539A() {
        List<Character> buttons = List.of('5', '3', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(70, shortestPath);
    }

    @Test
    void shouldBe72for964A() {
        List<Character> buttons = List.of('9', '6', '4', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(72, shortestPath);
    }

    @Test
    void shouldBe76for803A() {
        List<Character> buttons = List.of('8', '0', '3', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(76, shortestPath);
    }

    @Test
    void shouldBe76for149A() {
        List<Character> buttons = List.of('1', '4', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(76, shortestPath);
    }

    @Test
    void shouldBe66for789A() {
        List<Character> buttons = List.of('7', '8', '9', 'A');
        PartOne partOne = new PartOne();
        int shortestPath = partOne.shortestPath(buttons);
        Assertions.assertEquals(66, shortestPath);
    }

    @Test
    void shouldBe231564forAdventOfCodeInput() {
        PartOne partOne = new PartOne();
        int result = 0;
        result += partOne.shortestPath(List.of('5', '3', '9', 'A')) * 539;
        result += partOne.shortestPath(List.of('9', '6', '4', 'A')) * 964;
        result += partOne.shortestPath(List.of('8', '0', '3', 'A')) * 803;
        result += partOne.shortestPath(List.of('1', '4', '9', 'A')) * 149;
        result += partOne.shortestPath(List.of('7', '8', '9', 'A')) * 789;
        Assertions.assertEquals(231564, result);
    }
}