package adventofcode.year2025.problem06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    private PartOne partOne;
    private FileLoader fileLoader;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.fileLoader = new FileLoader();
    }

    @Test
    void shouldBe3263827forAdventOfCodeExample() throws Exception {
        List<Problem> problems = fileLoader.loadProblemsFromFileForPartTwo("adventofcode/year2025/problem06_example.txt");
        long result = 0;
        for (Problem problem : problems) {
            result += partOne.calculate(problem);
        }
        Assertions.assertEquals(3263827, result);
    }

    @Test
    void shouldBe7858808482092forAdventOfCodeInput() throws Exception {
        List<Problem> problems = fileLoader.loadProblemsFromFileForPartTwo("adventofcode/year2025/problem06_input.txt");
        long result = 0;
        for (Problem problem : problems) {
            result += partOne.calculate(problem);
        }
        Assertions.assertEquals(7858808482092L, result);
    }
}