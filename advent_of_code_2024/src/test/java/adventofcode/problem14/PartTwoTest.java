package adventofcode.problem14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartTwoTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Disabled
    @Test
    void shouldBe229839456forAdventOfCodeInput() throws Exception {
        List<Robot> robots = testUtils.loadFile("problem14_input.txt");
        PartTwo partTwo = new PartTwo(robots, 101, 103);
        partTwo.calculateIterationsForEasterEgg();
    }

}