package adventofcode.year2024.problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class PartTwoTest {
    private PartTwo partTwo;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
    }

    @Test
    void shouldBeTruefor1and2and3() {
        List<Integer> levels = List.of(1, 2, 3);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf3and2and1() {
        List<Integer> levels = List.of(3, 2, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and3and2() {
        List<Integer> levels = List.of(1, 3, 2);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and5and6() {
        List<Integer> levels = List.of(1, 5, 6);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and4and6() {
        List<Integer> levels = List.of(1, 4, 6);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf6and5and1() {
        List<Integer> levels = List.of(6, 5, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf6and4and1() {
        List<Integer> levels = List.of(6, 4, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeFalseIf1and5and9() {
        List<Integer> levels = List.of(1, 5, 9);
        Assertions.assertFalse(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeFalseIf9and5and1() {
        List<Integer> levels = List.of(9, 5, 1);
        Assertions.assertFalse(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeFalseIf1and3and2and2() {
        List<Integer> levels = List.of(1, 3, 2, 2);
        Assertions.assertFalse(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf7and6and4and2and1() {
        List<Integer> levels = List.of(7, 6, 4, 2, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeFalseIf1and2and7and8and9() {
        List<Integer> levels = List.of(1, 2, 7, 8, 9);
        Assertions.assertFalse(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeFalseIf9and7and6and2and1() {
        List<Integer> levels = List.of(9, 7, 6, 2, 1);
        Assertions.assertFalse(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and3and2and4and5() {
        List<Integer> levels = List.of(1, 3, 2, 4, 5);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf8and6and4and4and4and1() {
        List<Integer> levels = List.of(8, 6, 4, 4, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and3and6and7and9() {
        List<Integer> levels = List.of(1, 3, 6, 7, 9);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf48and46and47and49and51and54and56() {
        List<Integer> levels = List.of(48, 46, 47, 49, 51, 54, 56);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and1and2and3and4and5() {
        List<Integer> levels = List.of(1, 1, 2, 3, 4, 5);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and2and3and4and5and5() {
        List<Integer> levels = List.of(1, 2, 3, 4, 5, 5);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf5and1and2and3and4and5() {
        List<Integer> levels = List.of(5, 1, 2, 3, 4, 5);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and4and3and2and1() {
        List<Integer> levels = List.of(1, 4, 3, 2, 1);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and6and7and8and9() {
        List<Integer> levels = List.of(1, 6, 7, 8, 9);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf1and2and3and4and3() {
        List<Integer> levels = List.of(1, 2, 3, 4, 3);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf9and8and7and6and7() {
        List<Integer> levels = List.of(9, 8, 7, 6, 7);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf7and10and8and10and11() {
        List<Integer> levels = List.of(7, 10, 8, 10, 11);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf29and28and27and25and26and25and22and20() {
        List<Integer> levels = List.of(29, 28, 27, 25, 26, 25, 22, 20);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf75and77and72and70and69() {
        List<Integer> levels = List.of(75, 77, 72, 70, 69);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf52and51and52and49and47and45() {
        List<Integer> levels = List.of(52, 51, 52, 49, 47, 45);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf16and19and21and24and23() {
        List<Integer> levels = List.of(16, 19, 21, 24, 23);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeTrueIf90and89and86and84and83and79() {
        List<Integer> levels = List.of(90, 89, 86, 84, 83, 79);
        Assertions.assertTrue(partTwo.areLevelsSafeWithProblemDampener(levels));
    }

    @Test
    void shouldBeXforAdventOfCodeProblem() throws Exception {
        List<List<Integer>> reports = loadFileToListOfStrings("adventofcode/year2024/problem2.txt");
        int result = 0;
        for (List<Integer> levels : reports) {
            if (partTwo.areLevelsSafeWithProblemDampener(levels)) {
                result++;
            }
        }
        Assertions.assertEquals(544, result);
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