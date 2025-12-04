package adventofcode.year2025.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    @Test
    void shouldBe51if50andR1() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "R1");
        Assertions.assertEquals(51, result);
    }

    @Test
    void shouldBe49if50andL1() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "L1");
        Assertions.assertEquals(49, result);
    }

    @Test
    void shouldBe60if50andR10() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "R10");
        Assertions.assertEquals(60, result);
    }

    @Test
    void shouldBe60if50andL10() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "L10");
        Assertions.assertEquals(40, result);
    }

    @Test
    void shouldBe0if99andR1() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(99, "R1");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe9if99andR10() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(99, "R10");
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldBe99if0andL1() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(0, "L1");
        Assertions.assertEquals(99, result);
    }

    @Test
    void shouldBe95if5andL10() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(5, "L10");
        Assertions.assertEquals(95, result);
    }

    @Test
    void shouldBe50if50andR100() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "R100");
        Assertions.assertEquals(50, result);
    }

    @Test
    void shouldBe50if50andR200() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "R200");
        Assertions.assertEquals(50, result);
    }

    @Test
    void shouldBe50if50andL200() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "L200");
        Assertions.assertEquals(50, result);
    }

    @Test
    void shouldBe0if0andL200() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(0, "L200");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe0if50andR250() {
        PartOne partOne = new PartOne();
        int result = partOne.updateDial(50, "R250");
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1ifL50() {
        PartOne partOne = new PartOne();
        int result = partOne.countZeroes(List.of("L50"));
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifL50andR50andL50() {
        PartOne partOne = new PartOne();
        int result = partOne.countZeroes(List.of("L50", "R50", "L50"));
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forAdventOfCodeExample() {
        PartOne partOne = new PartOne();
        int result = partOne.countZeroes(List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"));
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe1092forAdventOfCodePartOneInput() throws Exception {
        TestUtils testUtils = new TestUtils();
        List<String> commands = testUtils.loadFromFile("adventofcode/year2025/problem01_input.txt");
        PartOne partOne = new PartOne();
        int result = partOne.countZeroes(commands);
        Assertions.assertEquals(1092, result);
    }
}