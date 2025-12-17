package adventofcode2025.problem08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    @Test
    void shouldBe25272forAdventOfCodeExample() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<JunctionBox> junctionBoxes = fileLoader.loadAndParse("problem08_example.txt");
        PartTwo partTwo = new PartTwo();
        long result = partTwo.findLastNeededConnection(junctionBoxes);
        Assertions.assertEquals(25272, result);
    }

    @Test
    void shouldBe170629052forAdventOfCodeInput() throws Exception {
        FileLoader fileLoader = new FileLoader();
        List<JunctionBox> junctionBoxes = fileLoader.loadAndParse("problem08_input.txt");
        PartTwo partTwo = new PartTwo();
        long result = partTwo.findLastNeededConnection(junctionBoxes);
        Assertions.assertEquals(170629052, result);
    }
}