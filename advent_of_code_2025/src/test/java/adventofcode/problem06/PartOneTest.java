package adventofcode.problem06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private PartOne partOne;
    private FileLoader fileLoader;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.fileLoader = new FileLoader();
    }

    @Test
    void shouldBe1for1and1and1andMultiply() {
        Problem problem = new Problem(List.of(1L, 1L, 1L), Operation.MULTIPLY);
        long result = partOne.calculate(problem);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3for1and1and1andAdd() {
        Problem problem = new Problem(List.of(1L, 1L, 1L), Operation.ADD);
        long result = partOne.calculate(problem);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe4277556forAdventOfCodeExample() throws Exception {
        List<Problem> problems = fileLoader.loadProblemsFromFile("problem06_example.txt");
        long result = 0;
        for (Problem problem : problems) {
            result += partOne.calculate(problem);
        }
        Assertions.assertEquals(4277556, result);
    }

    @Test
    void shouldBe4412382293768forAdventOfCodeInput() throws Exception {
        List<Problem> problems = fileLoader.loadProblemsFromFile("problem06_input.txt");
        long result = 0;
        for (Problem problem : problems) {
            result += partOne.calculate(problem);
        }
        Assertions.assertEquals(4412382293768L, result);
    }
}