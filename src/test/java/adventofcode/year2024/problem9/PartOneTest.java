package adventofcode.year2024.problem9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartOneTest {
    private PartOne partOne;
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.partOne = new PartOne();
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe0forSingleFile() {
        String diskMap = "1";
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(0, checksum);
    }

    @Test
    void shouldBe1forTwoFiles() {
        String diskMap = "101";
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(1, checksum);
    }

    @Test
    void shouldBe1forTwoFilesWithGapBetween() {
        String diskMap = "111";
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(1, checksum);
    }

    @Test
    void shouldBe1for60for12345() {
        String diskMap = "12345";
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(60, checksum);
    }

    @Test
    void shouldBe1928forAdventOfCodeExample() {
        String diskMap = "2333133121414131402";
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(1928, checksum);
    }

    @Test
    void shouldBe6288599492129forAdventOfCodeInput() throws Exception {
        String diskMap = testUtils.loadFile("adventofcode/year2024/problem9_input.txt");
        long checksum = partOne.compact(diskMap);
        Assertions.assertEquals(6288599492129L, checksum);
    }
}