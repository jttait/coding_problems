package adventofcode.problem07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

class PartTwoTest {
    private PartTwo partTwo;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBeTrueForSingleNumber() {
        List<Equation> equations = List.of(new Equation(BigInteger.TEN, List.of(BigInteger.TEN)));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.TEN, result);
    }

    @Test
    void shouldBeTrueForAddingTwoNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.TWO, List.of(BigInteger.ONE, BigInteger.ONE)));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.TWO, result);
    }

    @Test
    void shouldBeFalseForSingleNumber() {
        List<Equation> equations = List.of(new Equation(BigInteger.TWO, List.of(BigInteger.ONE)));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void shouldBeTrueForMultiplyingTwoNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.valueOf(20), List.of(BigInteger.TEN, BigInteger.TWO)));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(20), result);
    }

    @Test
    void shouldBeTrueForConcatenatingTwoNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.valueOf(156), List.of(BigInteger.valueOf(15), BigInteger.valueOf(6))));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(156), result);
    }

    @Test
    void shouldBeTrueForConcatenatingThreeNumbers() {
        List<Equation> equations = List.of(new Equation(BigInteger.valueOf(15678), List.of(BigInteger.valueOf(15), BigInteger.valueOf(6), BigInteger.valueOf(78))));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(15678), result);
    }

    @Test
    void shouldBeTrueForCombinationOfMultiplicationAndConcatenation() {
        List<Equation> equations = List.of(new Equation(BigInteger.valueOf(7290), List.of(
                BigInteger.valueOf(6),
                BigInteger.valueOf(8),
                BigInteger.valueOf(6),
                BigInteger.valueOf(15)
        )));
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(7290), result);
    }

    @Test
    void shouldBe11387forAdventOfCodeExample() throws Exception {
        List<Equation> equations = testUtils.loadFile("problem7_example.txt");
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(11387), result);
    }

    @Test
    void shouldBe11387forAdventOfCodeInput() throws Exception {
        List<Equation> equations = testUtils.loadFile("problem7_input.txt");
        BigInteger result = partTwo.totalCalibrationResult(equations);
        Assertions.assertEquals(BigInteger.valueOf(149956401519484L), result);
    }
}