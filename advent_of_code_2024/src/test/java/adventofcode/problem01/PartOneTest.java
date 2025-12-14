package adventofcode.problem01;

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
    void shouldBe0for1and1() {
        List<Integer> left = List.of(1);
        List<Integer> right = List.of(1);
        int result = this.partOne.totalDistance(left, right);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for1and2() {
        List<Integer> left = List.of(1);
        List<Integer> right = List.of(2);
        int result = this.partOne.totalDistance(left, right);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe0forLeftOf1and2andRightOf1and2() {
        List<Integer> left = List.of(1, 2);
        List<Integer> right = List.of(1, 2);
        int result = this.partOne.totalDistance(left, right);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe0forLeftOf1and2andRightOf2and1() {
        List<Integer> left = List.of(1, 2);
        List<Integer> right = List.of(2, 1);
        int result = this.partOne.totalDistance(left, right);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe2264607forAdventOfCodeProblem() throws Exception {
        List<List<Integer>> lists = loadFileToListOfStrings("problem1.txt");
        List<Integer> left = lists.get(0);
        List<Integer> right = lists.get(1);
        int result = this.partOne.totalDistance(left, right);
        Assertions.assertEquals(2264607, result);
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