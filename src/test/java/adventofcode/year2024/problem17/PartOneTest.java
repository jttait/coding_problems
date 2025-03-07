package adventofcode.year2024.problem17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PartOneTest {
    @Test
    void shouldBe0ifNoProgram() {
        PartOne partOne = new PartOne(0, 0, 0, new ArrayList<>());
        List<Integer> result = partOne.compute();
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void shouldBeExpectedOutForAdventOfCodeExample() {
        PartOne partOne = new PartOne(729, 0, 0, List.of(0,1,5,4,3,0));
        List<Integer> result = partOne.compute();
        List<Integer> expected = Arrays.asList(4,6,3,5,6,3,5,2,1,0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeExpectedOutForAdventOfCodeInput() {
        PartOne partOne = new PartOne(30899381, 0, 0, List.of(2,4,1,1,7,5,4,0,0,3,1,6,5,5,3,0));
        List<Integer> result = partOne.compute();
        List<Integer> expected = Arrays.asList(1,6,3,6,5,6,5,1,7);
        Assertions.assertEquals(expected, result);
    }
}