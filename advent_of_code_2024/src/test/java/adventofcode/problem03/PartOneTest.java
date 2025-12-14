package adventofcode.problem03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe2024forMul44and46() {
        String s = "mul(44,46)";
        int result = partOne.parseSection(s);
        Assertions.assertEquals(2024, result);
    }

    @Test
    void shouldBe0forMissingClosingBracket() {
        String s = "mul(44,46";
        int result = partOne.parseSection(s);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe13forMul2and2andMul3and3() {
        String s = "mul(2,2)mul(3,3)";
        int result = partOne.parseSection(s);
        Assertions.assertEquals(13, result);
    }

    @Test
    void shouldBe4forMul2and2() {
        String s = "mul(2,2)mul(3;3)";
        int result = partOne.parseSection(s);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe168539636forAdventOfCodeProblem() throws Exception {
        String program = testUtils.loadFileToListOfStrings("adventofcode/year2024/problem3.txt");
        int result = partOne.parseSection(program);
        Assertions.assertEquals(168539636, result);
    }
}