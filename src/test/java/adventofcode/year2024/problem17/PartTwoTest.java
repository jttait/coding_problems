package adventofcode.year2024.problem17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PartTwoTest {
    @Test
    @Disabled
    void shouldBe117440forAdventOfCodeExample() {
        PartTwo partTwo = new PartTwo();
        long result = partTwo.findLowestRegisterA(Arrays.asList(0,3,5,4,3,0));
        Assertions.assertEquals(117440, result);
    }

    @Test
    void shouldBe247839653009594forAdventOfCodeInput() {
        PartTwo partTwo = new PartTwo();
        long result = partTwo.findLowestRegisterA(Arrays.asList(2,4,1,1,7,5,4,0,0,3,1,6,5,5,3,0));
        Assertions.assertEquals(247839653009594L, result);
    }
}