package adventofcode.year2024.problem07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBeTrueForSingleNumber() {
        List<Equation> equations = List.of(new Equation(BigInteger.TEN, List.of(BigInteger.TEN)));
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.TEN, result);
    }

    @Test
    void shouldBeTrueForAddingTwoNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.TWO, List.of(BigInteger.ONE, BigInteger.ONE)));
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.TWO, result);
    }

    @Test
    void shouldBeFalseForSingleNumber() {
        List<Equation> equations = List.of(new Equation(BigInteger.TWO, List.of(BigInteger.ONE)));
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void shouldBeTrueForMultiplyingTwoNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.valueOf(20), List.of(BigInteger.TEN, BigInteger.TWO)));
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(20), result);
    }

    @Test
    void shouldBe3749forAdventOfCodeExample() throws Exception {
        List<Equation> equations = testUtils.loadFile("adventofcode/year2024/problem7_example.txt");
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(3749), result);
    }

    @Test
    void shouldBe12839601725877forAdventOfCodeInput() throws Exception {
        List<Equation> equations = testUtils.loadFile("adventofcode/year2024/problem7_input.txt");
        BigInteger result = partOne.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(12839601725877L), result);
    }
}