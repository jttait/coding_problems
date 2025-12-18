package adventofcode2025.problem11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

class PartOneTest {
    @Test
    void shouldBe1forSimplestCase() {
        Map<String, Set<String>> connections = Map.of(
                "you", Set.of("out")
        );
        PartOne partOne = new PartOne(connections);
        int result = partOne.countPathsFromYouToOut();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forSinglePathWithTwoDevices() {
        Map<String, Set<String>> connections = Map.of(
                "you", Set.of("aaa"),
                "aaa", Set.of("out")
        );
        PartOne partOne = new PartOne(connections);
        int result = partOne.countPathsFromYouToOut();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forTwoSimplePaths() {
        Map<String, Set<String>> connections = Map.of(
                "you", Set.of("aaa", "bbb"),
                "aaa", Set.of("out"),
                "bbb", Set.of("out")
        );
        PartOne partOne = new PartOne(connections);
        int result = partOne.countPathsFromYouToOut();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe5forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader  = new FileLoader();
        Map<String, Set<String>> connections = fileLoader.loadAndParse("problem11_example_part1.txt");
        PartOne partOne = new PartOne(connections);
        int result = partOne.countPathsFromYouToOut();
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldBe662forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader  = new FileLoader();
        Map<String, Set<String>> connections = fileLoader.loadAndParse("problem11_input.txt");
        PartOne partOne = new PartOne(connections);
        int result = partOne.countPathsFromYouToOut();
        Assertions.assertEquals(662, result);
    }
}