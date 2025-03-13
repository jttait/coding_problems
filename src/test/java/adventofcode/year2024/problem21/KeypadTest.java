package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KeypadTest {
    @Test
    void shouldBe1shortestPathFromAtoZero() {
        Keypad numericKeypad = new Keypad(Grid.NUMERIC);
        List<List<Character>> result = numericKeypad.shortestPaths('A', '0');
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(List.of('<'), result.get(0));
    }

    @Test
    void shouldBe1shortestPathFromAto9() {
        Keypad numericKeypad = new Keypad(Grid.NUMERIC);
        List<List<Character>> result = numericKeypad.shortestPaths('A', '9');
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void shouldBe2shortestPathFrom7to5() {
        Keypad numericKeypad = new Keypad(Grid.NUMERIC);
        List<List<Character>> result = numericKeypad.shortestPaths('7', '5');
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void shouldBe2shortestPathFrom1to0() {
        Keypad numericKeypad = new Keypad(Grid.NUMERIC);
        List<List<Character>> result = numericKeypad.shortestPaths('1', '0');
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void shouldBe2shortestPathFromAtoLeft() {
        Keypad directionalKeypad = new Keypad(Grid.DIRECTIONAL);
        List<List<Character>> result = directionalKeypad.shortestPaths('A', '<');
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void shouldBe1shortestPathFromAtoRight() {
        Keypad directionalKeypad = new Keypad(Grid.DIRECTIONAL);
        List<List<Character>> result = directionalKeypad.shortestPaths('A', '>');
        Assertions.assertEquals(1, result.size());
    }
}