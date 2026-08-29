package problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


class SolutionTest {
    private Solution solution;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
        this.testUtils = new TestUtils();
    }

    @ParameterizedTest
    @CsvSource({
            "1abc2,12",
            "pqr3stu8vwx,38",
            "a1b2c3d4e5f,15",
            "treb7uchet,77"
    })
    void shouldBeExpectedForLine(String input, String expected) {
        int result = solution.calculateCalibrationValueForLine(input);
        Assertions.assertEquals(Integer.parseInt(expected), result);
    }

    @Test
    void shouldBe142forAdventOfCodeExample() throws Exception {
        List<String> input = testUtils.loadFromFile("problem01_example.txt");
        int result = solution.calculateCalibrationValueForLines(input);
        Assertions.assertEquals(142, result);
    }

    @Test
    void shouldBe54968forAdventOfCodeInput() throws Exception {
        List<String> input = testUtils.loadFromFile("problem01_input.txt");
        int result = solution.calculateCalibrationValueForLines(input);
        Assertions.assertEquals(54968, result);
    }

    @ParameterizedTest
    @CsvSource({
            "two1nine,29",
            "eightwothree,83",
            "abcone2threexyz,13",
            "xtwone3four,24",
            "4nineeightseven2,42",
            "zoneight234,14",
            "7pqrstsixteen,76",
            "eighthree,83"
    })
    void shouldBeExpectedForLineWithWords(String input, String expected) {
        int result = solution.calculateCalibrationValueForLineWithWords(input);
        Assertions.assertEquals(Integer.parseInt(expected), result);
    }

    @Test
    void shouldBe281forSecondAdventOfCodeExample() throws Exception {
        List<String> input = testUtils.loadFromFile("problem01_example2.txt");
        int result = solution.calculateCalibrationValueForLinesWithWords(input);
        Assertions.assertEquals(281, result);
    }

    @Test
    void shouldBe54110forAdventOfCodeInputWithWords() throws Exception {
        List<String> input = testUtils.loadFromFile("problem01_input.txt");
        int result = solution.calculateCalibrationValueForLinesWithWords(input);
        Assertions.assertEquals(54110, result);
    }
}