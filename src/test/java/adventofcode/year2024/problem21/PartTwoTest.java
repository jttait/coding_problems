package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartTwoTest {
    @Test
    void shouldBe12for029AwithNoRobots() {
        PartTwo partTwo = new PartTwo(0);
        long result = partTwo.solve("029A");
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldBe28for029AwithOneRobots() {
        PartTwo partTwo = new PartTwo(1);
        long result = partTwo.solve("029A");
        Assertions.assertEquals(28, result);
    }

    @Test
    void shouldBe68for029AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("029A");
        Assertions.assertEquals(68, result);
    }

    @Test
    void shouldBe60for980AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("980A");
        Assertions.assertEquals(60, result);
    }

    @Test
    void shouldBe68for179AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("179A");
        Assertions.assertEquals(68, result);
    }

    @Test
    void shouldBe64for456AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("456A");
        Assertions.assertEquals(64, result);
    }

    @Test
    void shouldBe64for379AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("379A");
        Assertions.assertEquals(64, result);
    }

    @Test
    void shouldBe70for539AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("539A");
        Assertions.assertEquals(70, result);
    }

    @Test
    void shouldBe72for964AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("964A");
        Assertions.assertEquals(72, result);
    }

    @Test
    void shouldBe76for803AwithTwoRobots() {
        PartTwo partTwo = new PartTwo(2);
        long result = partTwo.solve("803A");
        Assertions.assertEquals(76, result);
    }

    @Test
    void shouldBe231564forAdventOfCodeInputWithTwoRobots() {
        PartTwo partOne = new PartTwo(2);
        long result = 0;
        result += partOne.solve("539A") * 539;
        result += partOne.solve("964A") * 964;
        result += partOne.solve("803A") * 803;
        result += partOne.solve("149A") * 149;
        result += partOne.solve("789A") * 789;
        Assertions.assertEquals(231564, result);
    }

    @Test
    void shouldBe281212077733592forAdventOfCodeInputWithTwentyFiveRobots() {
        PartTwo partOne = new PartTwo(25);
        long result = 0;
        result += partOne.solve("539A") * 539;
        result += partOne.solve("964A") * 964;
        result += partOne.solve("803A") * 803;
        result += partOne.solve("149A") * 149;
        result += partOne.solve("789A") * 789;
        Assertions.assertEquals(281212077733592L, result);
    }
}