package adventofcode.year2024.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartTwoTest {
    @Test
    void name() {
        PartTwo partTwo = new PartTwo();
        long result = partTwo.lengthOfShortestPath(2);
        Assertions.assertEquals(5, result);
    }
}