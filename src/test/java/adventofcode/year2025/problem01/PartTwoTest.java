package adventofcode.year2025.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    @Test
    void shouldBe1ifL100() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L100"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifL200() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L200"));
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1ifL50() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L50"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1ifR100() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("R100"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifR200() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("R200"));
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1ifR50() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("R50"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifL100andR100() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L100", "R100"));
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1ifL50andR50() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L50", "R50"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe10ifR1000() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("R1000"));
        Assertions.assertEquals(10, result);
    }

    @Test
    void shouldBe6forAdventOfCodeExample() {
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"));
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldBe6616forAdventOfCodePartOneInput() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<String> commands = testUtils.loadFromFile("adventofcode/year2025/problem01_input.txt");
        PartTwo partTwo = new PartTwo();
        int result = partTwo.countAllZeroes(commands);
        Assertions.assertEquals(6616, result);
    }
}