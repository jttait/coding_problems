package adventofcode.year2024.problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class PartOneTest {
    private PartOne partOne;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
    }

    @Test
    void shouldBeTrueIf1and2and3() {
        List<Integer> levels = List.of(1, 2, 3);
        Assertions.assertTrue(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeTrueIf3and2and1() {
        List<Integer> levels = List.of(3, 2, 1);
        Assertions.assertTrue(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeFalseIf1and3and2() {
        List<Integer> levels = List.of(1, 3, 2);
        Assertions.assertFalse(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeFalseIf1and5and6() {
        List<Integer> levels = List.of(1, 5, 6);
        Assertions.assertFalse(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeTrueIf1and4and6() {
        List<Integer> levels = List.of(1, 4, 6);
        Assertions.assertTrue(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeFalseIf6and5and1() {
        List<Integer> levels = List.of(6, 5, 1);
        Assertions.assertFalse(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBeTrueIf6and4and1() {
        List<Integer> levels = List.of(6, 4, 1);
        Assertions.assertTrue(partOne.areLevelsSafe(levels));
    }

    @Test
    void shouldBe502forAdventOfCodeProblem() throws Exception {
        List<List<Integer>> reports = loadFileToListOfStrings("adventofcode/year2024/problem2.txt");
        int result = 0;
        for (List<Integer> levels : reports) {
            if (partOne.areLevelsSafe(levels)) {
                result++;
            }
        }
        Assertions.assertEquals(502, result);
    }

    private List<List<Integer>> loadFileToListOfStrings(String filename) throws Exception {
        List<List<Integer>> result = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            String[] parts = line.split(" ");
            List<Integer> lineList = new ArrayList<>();
            for (String s : parts) {
                lineList.add(Integer.parseInt(s));
            }
            result.add(lineList);
        }
        return result;
    }
}