package adventofcode.year2024.problem09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartTwoTest {

    private PartTwo partTwo;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partTwo = new PartTwo();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe0forSingleFile() {
        String diskMap = "1";
        long checksum = partTwo.compact(diskMap);
        Assertions.assertEquals(0, checksum);
    }

    @Test
    void shouldBe1forTwoFiles() {
        String diskMap = "101";
        long checksum = partTwo.compact(diskMap);
        Assertions.assertEquals(1, checksum);
    }

    @Test
    void shouldBe2858forExample() {
        String diskMap = "2333133121414131402";
        long checksum = partTwo.compact(diskMap);
        Assertions.assertEquals(2858, checksum);
    }

    @Test
    void shouldBe6321896265143forAdventOfCodeInput() throws Exception {
        String diskMap = testUtils.loadFile("adventofcode/year2024/problem9_input.txt");
        long checksum = partTwo.compact(diskMap);
        Assertions.assertEquals(6321896265143L, checksum);
    }
}