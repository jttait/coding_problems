package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartTwoTest {
    @Test
    void shouldBe281212077733592forAdventOfCodeInputWithTwentyFiveRobots() {
        PartOne partOne = new PartOne(25);
        long result = 0;
        result += partOne.solve("539A") * 539;
        result += partOne.solve("964A") * 964;
        result += partOne.solve("803A") * 803;
        result += partOne.solve("149A") * 149;
        result += partOne.solve("789A") * 789;
        Assertions.assertEquals(281212077733592L, result);
    }
}