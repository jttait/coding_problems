package adventofcode.year2024.problem3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartTwoTest {
    private PartTwo partTwo;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe2024forMul44and46() {
        String s = "mul(44,46)";
        int result = partTwo.parseSection(s);
        Assertions.assertEquals(2024, result);
    }

    @Test
    void shouldBe0ifDont() {
        String s = "don't()mul(44,46)";
        int result = partTwo.parseSection(s);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe2024ifDontThenDo() {
        String s = "don't()do()mul(44,46)";
        int result = partTwo.parseSection(s);
        Assertions.assertEquals(2024, result);
    }

    @Test
    void shouldBe48forAdventOfCodeExample() {
        String s = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        int result = partTwo.parseSection(s);
        Assertions.assertEquals(48, result);
    }

    @Test
    void shouldBe97529391forAdventOfCodeProblem() throws Exception {
        String program = testUtils.loadFileToListOfStrings("adventofcode/year2024/problem3.txt");
        int result = partTwo.parseSection(program);
        Assertions.assertEquals(97529391, result);
    }
}