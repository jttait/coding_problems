package adventofcode2025.problem11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

class PartTwoTest {
    @Test
    void shouldBe0ifNoDacOrFft() {
        Map<String, Set<String>> connections = Map.of(
                "svr", Set.of("out")
        );
        PartTwo partTwo = new PartTwo(connections);
        long result = partTwo.countPathsFromSvrToOut();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe0ifNoDac() {
        Map<String, Set<String>> connections = Map.of(
                "svr", Set.of("fft"),
                "fft", Set.of("out")
        );
        PartTwo partTwo = new PartTwo(connections);
        long result = partTwo.countPathsFromSvrToOut();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1ifDacAndFft() {
        Map<String, Set<String>> connections = Map.of(
                "svr", Set.of("fft"),
                "fft", Set.of("dac"),
                "dac", Set.of("out")
        );
        PartTwo partTwo = new PartTwo(connections);
        long result = partTwo.countPathsFromSvrToOut();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        Map<String, Set<String>> connections = fileLoader.loadAndParse("problem11_example_part2.txt");
        PartTwo partTwo = new PartTwo(connections);
        long result = partTwo.countPathsFromSvrToOut();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe429399933071120forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        Map<String, Set<String>> connections = fileLoader.loadAndParse("problem11_input.txt");
        PartTwo partTwo = new PartTwo(connections);
        long result = partTwo.countPathsFromSvrToOut();
        Assertions.assertEquals(429399933071120L, result);
    }
}