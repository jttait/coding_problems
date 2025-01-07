package adventofcode.year2024.problem1;

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
    void shouldBe1forLeftOf1andRightOf1() {
        List<Integer> left = List.of(1);
        List<Integer> right = List.of(1);
        int result = partTwo.similarityScore(left, right);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe4forLeftOf2andRightOf2() {
        List<Integer> left = List.of(2);
        List<Integer> right = List.of(2);
        int result = partTwo.similarityScore(left, right);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe0forLeftOf1andRightOf2() {
        List<Integer> left = List.of(1);
        List<Integer> right = List.of(2);
        int result = partTwo.similarityScore(left, right);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe27forLeftOf3and3and3andRightOf3and3and3() {
        List<Integer> left = List.of(3, 3, 3);
        List<Integer> right = List.of(3, 3, 3);
        int result = partTwo.similarityScore(left, right);
        Assertions.assertEquals(27, result);
    }

    @Test
    void shouldBe27forAdventOfCodeWorkedExample() {
        List<Integer> left = List.of(3, 4, 2, 1, 3, 3);
        List<Integer> right = List.of(4, 3, 5, 3, 9, 3);
        int result = partTwo.similarityScore(left, right);
        Assertions.assertEquals(31, result);
    }

    @Test
    void shouldBe19457120forAdventOfCodeProblem() throws Exception {
        List<List<Integer>> lists = loadFileToListOfStrings("adventofcode/year2024/adventofcode_year2024_problem1.txt");
        List<Integer> left = lists.get(0);
        List<Integer> right = lists.get(1);
        int result = this.partTwo.similarityScore(left, right);
        Assertions.assertEquals(19457120, result);
    }

    private List<List<Integer>> loadFileToListOfStrings(String filename) throws Exception {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            String[] parts = line.split("   ");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        }
        return List.of(left, right);
    }
}