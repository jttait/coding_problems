package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartOneTest {
    @Test
    void shouldBe12for029AwithNoRobots() {
        PartOne partOne = new PartOne(0);
        long result = partOne.solve("029A");
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldBe28for029AwithOneRobots() {
        PartOne partOne = new PartOne(1);
        long result = partOne.solve("029A");
        Assertions.assertEquals(28, result);
    }

    @Test
    void shouldBe68for029AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("029A");
        Assertions.assertEquals(68, result);
    }

    @Test
    void shouldBe60for980AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("980A");
        Assertions.assertEquals(60, result);
    }

    @Test
    void shouldBe68for179AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("179A");
        Assertions.assertEquals(68, result);
    }

    @Test
    void shouldBe64for456AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("456A");
        Assertions.assertEquals(64, result);
    }

    @Test
    void shouldBe64for379AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("379A");
        Assertions.assertEquals(64, result);
    }

    @Test
    void shouldBe70for539AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("539A");
        Assertions.assertEquals(70, result);
    }

    @Test
    void shouldBe72for964AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("964A");
        Assertions.assertEquals(72, result);
    }

    @Test
    void shouldBe76for803AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("803A");
        Assertions.assertEquals(76, result);
    }

    @Test
    void shouldBe76for149AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("149A");
        Assertions.assertEquals(76, result);
    }

    @Test
    void shouldBe66for789AwithTwoRobots() {
        PartOne partOne = new PartOne(2);
        long result = partOne.solve("803A");
        Assertions.assertEquals(76, result);
    }

    @Test
    void shouldBe231564forAdventOfCodeInput() {
        PartOne partOne = new PartOne(2);
        long result = 0;
        result += partOne.solve("539A") * 539;
        result += partOne.solve("964A") * 964;
        result += partOne.solve("803A") * 803;
        result += partOne.solve("149A") * 149;
        result += partOne.solve("789A") * 789;
        Assertions.assertEquals(231564, result);
    }
}